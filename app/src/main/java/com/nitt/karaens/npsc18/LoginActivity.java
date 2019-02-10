package com.nitt.karaens.npsc18;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    EditText Email,Password;
    Button signIn;
    private FirebaseAuth mAuth;
    TextView SignUp;
    private final String adEmail="skaraen@gmail.com";
    private final String adPass="skaraen@99";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Email=findViewById(R.id.Email);
        Password=findViewById(R.id.Password);
        signIn=findViewById(R.id.signIn);
        mAuth=FirebaseAuth.getInstance();
        SignUp=findViewById(R.id.SignUp);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email=Email.getText().toString();
                final String password=Password.getText().toString();
                Log.d("tag","s0");

                if(email.isEmpty()){
                    Email.setError("Fill in email id !");
                    Email.findFocus();
                }
                if(password.isEmpty()){
                    Password.setError("Enter the password !");
                    Password.findFocus();
                }
                if(!(password.isEmpty()||email.isEmpty())) {
                    Log.d("tag","s1");
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {
                                Log.d("tag","s2");
                                if(email.equals(adEmail)&&password.equals(adPass)){
                                    Toast.makeText(LoginActivity.this, "Welcome Karaen !", Toast.LENGTH_LONG).show();
                                    SharedPreferences.Editor editor = getSharedPreferences("Login", MODE_PRIVATE).edit();
                                    editor.putInt("state",1);
                                    editor.apply();
                                    startActivity(new Intent(LoginActivity.this,AdminActivity.class));
                            }
                            else {
                                    Toast.makeText(LoginActivity.this, "Success !", Toast.LENGTH_LONG).show();
                                    SharedPreferences.Editor editor = getSharedPreferences("Login", MODE_PRIVATE).edit();
                                    editor.putInt("state",1);
                                    editor.apply();

                                    startActivity(new Intent(LoginActivity.this,CatalogActivity.class));
                                }

                            }
                            else
                                Toast.makeText(LoginActivity.this, "failure", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });
    }

    User user=new User();
    User getUserDb(String uid){
        DatabaseReference DbRef=FirebaseDatabase.getInstance().getReference();
        DbRef.child("users").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    user=dataSnapshot.getValue(User.class);
                    Log.d("tag","c1");
                }
                else
                    user=null;
                Log.d("tag","c2");

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                user=null;
                Log.d("tag","c3");

            }
        });
        return user;
    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }
}
