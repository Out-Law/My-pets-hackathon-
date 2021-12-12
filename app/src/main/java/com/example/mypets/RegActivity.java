package com.example.mypets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegActivity extends AppCompatActivity {

    private TextView registerUser;
    private EditText editTextFullName, editTextPassport, editTextEmail, editTextPassword;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        mAuth = FirebaseAuth.getInstance();

        editTextFullName = (EditText) findViewById(R.id.fullname);
        editTextEmail = (EditText) findViewById(R.id.email_reg);
        editTextPassword = (EditText) findViewById(R.id.password_reg);

    }

    public void onClick(View view) {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String fullName = editTextFullName.getText().toString().trim();

        if(fullName.isEmpty()){
            editTextFullName.setError("Full name is requried!");
            editTextFullName.requestFocus();
            return;
        }

        if(email.isEmpty()){
            editTextFullName.setError("Email name is requried!");
            editTextFullName.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please provide valid email!");
            editTextEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length() < 6){
            editTextPassword.setError("Min password lenght should be 6 character");
            editTextPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            User user = new User(fullName, email);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()){
                                        Toast.makeText(RegActivity.this, "User has " +
                                                "been registered succsessfull!", Toast.LENGTH_LONG)
                                                .show();
                                    }
                                    else
                                    {
                                        Toast.makeText(RegActivity.this, "Failed to" +
                                                "   register! Try again!", Toast.LENGTH_LONG)
                                                .show();
                                    }
                                }
                            });

                        }
                        else
                        {
                            Toast.makeText(RegActivity.this, "Faild to register",
                                    Toast.LENGTH_LONG)
                                    .show();
                        }

                    }
                });
        finish();
        Toast.makeText(RegActivity.this, "The account is registered. Waiting for email confirmation.",
                Toast.LENGTH_LONG)
                .show();
    }
}
