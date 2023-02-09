package com.example.youtubeapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity {
    ImageView backBtn;
    Button whatsappBtn, googleBtn;
    FirebaseAuth firebaseAuth;
    EditText number;
    private static final int RC_SIGN_IN = 101;
    GoogleSignInClient mGoogleSignInClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeVariable();
        
        
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginwithGoogle();
            }
        });

        whatsappBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number.getText().toString().isEmpty())
                {
                    number.setError("Please fill your mobile number");
                }
                else
                {
                    String phone=number.getText().toString();
                    String url = "https://api.whatsapp.com/send?phone="+phone;
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(new Intent(MainActivity.this,WatchVideo.class));

                }

            }
        });
    }

    private void loginwithGoogle() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        Intent intent=mGoogleSignInClient.getSignInIntent();
        startActivityForResult(intent,RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check condition
        if (requestCode == RC_SIGN_IN) {
            // When request code is equal to 100
            // Initialize task
            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn
                    .getSignedInAccountFromIntent(data);

            // check condition
            if (signInAccountTask.isSuccessful()) {
                // When google sign in successful
                // Initialize string
                String s = "Google sign in successful";
                // Display Toast
                Toast.makeText(this, "Google Signup successfully !", Toast.LENGTH_LONG).show();
                // Initialize sign in account
                try {
                    // Initialize sign in account
                    GoogleSignInAccount googleSignInAccount = signInAccountTask
                            .getResult(ApiException.class);
                    // Check condition
                    if (googleSignInAccount != null) {
                        // When sign in account is not equal to null
                        // Initialize auth credential
                        AuthCredential authCredential = GoogleAuthProvider
                                .getCredential(googleSignInAccount.getIdToken()
                                        , null);
                        // Check credential
                        firebaseAuth.signInWithCredential(authCredential)
                                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        // Check condition
                                        if (task.isSuccessful()) {
                                            // When task is successful
                                            // Redirect to profile activity
                                            startActivity(new Intent(MainActivity.this
                                                    , WatchVideo.class)
                                                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                            // Display Toast
//                                            Toast.makeText(LoginActivity.this,"Firebase authentication successful",Toast.LENGTH_LONG).show();
                                        } else {
                                            // When task is unsuccessful
                                            // Display Toast
                                            Toast.makeText(MainActivity.this, "Authentication Failed :" + task.getException()
                                                    .getMessage(), Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });

                    }
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void initializeVariable() {
        backBtn=findViewById(R.id.imageView_backBtn);
        whatsappBtn=findViewById(R.id.wp_btn);
        googleBtn=findViewById(R.id.google_btn);
        firebaseAuth=FirebaseAuth.getInstance();
        number=findViewById(R.id.mobile);
    }
}