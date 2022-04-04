package my.firstapp.byblos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity_CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create_account);

        Button createAccountFinalButton = (Button) findViewById(R.id.createAccountFinal);

        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();

        createAccountFinalButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //EditText username = (EditText) findViewById(R.id.usernameCreate);
                //String name = username.getText().toString();

                EditText email = (EditText) findViewById(R.id.emailID);
                String emailId = email.getText().toString();
                boolean isCorrect = emailCheck(emailId);

                EditText password1 = (EditText) findViewById(R.id.passwordSet);
                EditText password2 = (EditText) findViewById(R.id.passwordSet2);
                String pass1 = password1.getText().toString();
                String pass2 = password2.getText().toString();
                boolean pass = passwordCheck(pass1, pass2);


                /*
                //RadioGroup checked = (RadioGroup) findViewById(R.id.radioGroup);
                boolean checked = ((RadioButton) v).isChecked();
                String accountType = "";
                switch (v.getId()) {
                    case R.id.customerRadioButton:
                        if(checked)
                            accountType = "Customer";
                        break;

                    case R.id.employeeRadioButton:
                        if(checked)
                            accountType = "Employee";
                        break;
                }
                 */

                /*
                String customer = "";
                RadioButton accountTypeCustomer = (RadioButton) findViewById(R.id.customerRadioButton);
                customer = accountTypeCustomer.getText().toString();

                String employee = "";
                RadioButton accountTypeEmployee = (RadioButton) findViewById(R.id.employeeRadioButton);
                employee = accountTypeEmployee.getText().toString();


                 */

                /*
                String accountType = "";

                if (accountTypeCustomer.isChecked()) {
                    accountType = "Customer";
                }
                else if (accountTypeEmployee.isChecked()) {
                    accountType = "Employee";
                }


                 */


                /*
                if (!customer.equals("Customer")) {
                    accountType = customer;
                }
                else {
                    accountType = employee;
                }
                */

                /*
                if (!isCorrect) {
                    username.setText("");
                    password1.setText("");
                    password2.setText("");
                    email.setText("");
                }


                 */

                if(!pass) {
                    password1.setText("");
                    password2.setText("");
                }

                else {
                    Intent intent = new Intent(MainActivity_CreateAccount.this, MainActivity.class);
                    Intent intent2 = new Intent(MainActivity_CreateAccount.this, MainActivity2.class);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();

                    /*
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference newUserPassReference = database.getReference("users/" + name + "/password");
                    DatabaseReference newUserEmailReference = database.getReference("users/" + name + "/email");
                    DatabaseReference newUserTypeReference = database.getReference("users/" + name + "/accountType");

                    newUserPassReference.setValue(pass2);
                    newUserEmailReference.setValue(emailId);
                    newUserTypeReference.setValue(accountType);
                    */
                    //String finalAccountType = accountType;
                    mAuth.createUserWithEmailAndPassword(emailId, pass2)
                            .addOnCompleteListener(MainActivity_CreateAccount.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        //Log.d(TAG, "createUserWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();

                                        //FirebaseDatabase database = FirebaseDatabase.getInstance();
                                        //FirebaseUser userForDatabase = user;
                                        //String uid = task.getResult().getUser().getUid();
                                        //String uid = user.getEmail();
                                        CurrentUser.currentUserId = "";
                                        //CurrentUser.currentUserId = user.getUid();
                                        //updateUI(user);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        //Toast.makeText(MainActivity_CreateAccount.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                        updateUI(null);
                                    }
                                }
                            });



                    //MainActivity2 m = new MainActivity2();
                    //m.message(name, accountType );

                    //FirebaseUser user = mAuth.getCurrentUser();
                    //String uid = user.getUid();
                    //CurrentUser.currentUserId = user;

                    //CurrentUser.currentUserId = mAuth.signInWithEmailAndPassword(emailId, pass2).getResult().getUser().getUid();

                    //if (mAuth.signInWithEmailAndPassword(emailId,pass2).isSuccessful()) {
                    //    FirebaseUser user = mAuth.getCurrentUser();
                    //    CurrentUser.currentUserId = user.getUid();
                    //}


                    //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    //CurrentUser.currentUserId = user.getUid();

                    //FirebaseUser user = mAuth.getCurrentUser();
                    //DatabaseReference userData = null;

                    //if (user != null) {
                    //    userData = FirebaseDatabase.getInstance().getReference().child("users")
                    //            .child(user.getUid());
                    //}

                    //CurrentUser.currentUserId = userData.getKey().toString();
                    //FirebaseAuth.getInstance().signOut();

                    DatabaseReference mdatabase;
                    mdatabase = database.getReference();

                    //mdatabase.child("users").child(CurrentUser.currentUserId);
                    CurrentUser.currentUserFirstTime = "T";
                    mAuth.signOut();
                    /*
                    FirebaseAuth mAuthTwo = FirebaseAuth.getInstance();
                    CurrentUser.currentUserId = "";
                    mAuthTwo.signInWithEmailAndPassword(emailId, pass2);
                    CurrentUser.currentUserId = mAuthTwo.getUid();
                    mAuthTwo.signOut();

                    DatabaseReference newUserTypeReference = database.getReference("users/" + CurrentUser.currentUserId + "/accountType");
                    DatabaseReference newUserNameReference = database.getReference("users/" + CurrentUser.currentUserId + "/userName");
                    newUserTypeReference.setValue(finalAccountType);
                    newUserNameReference.setValue(name);


                     */
                    //®FirebaseAuth.getInstance().signOut();

                    startActivity(intent);
                }


            }
        });

        //Insert Code to pass data from Linked List.


    }

    public void updateUI(FirebaseUser user) {
        //CurrentUser.currentUserId = user.getUid();
        return;
    }



    //checking if email is valid
    public boolean emailCheck (String emailId) {
        //boolean isCorrect = true;
        int atTheRateCounter = 0;

        for (int i = 0; i < emailId.length()-3; i++) {
            if (atTheRateCounter > 1) {
                //isCorrect = false;
                //break;
                return false;
            }
            char letter = emailId.charAt(i);
            if (letter == '@') {
                atTheRateCounter++;
            }
        }

        String lastFour = "";
        for (int i = emailId.length()-4; i < emailId.length(); i++) {
            lastFour += emailId.charAt(i);
        }
        if (!lastFour.equals(".com")) {
            //isCorrect = false;
            return false;
        }
        return true;
    }

    //confirmation if password is entered correctly both times when creating new account
    public boolean passwordCheck (String password1, String password2) {
        if (!password1.equals(password2)) {
            return false;
        }

        if (password1.length() < 6) {
            return false;
        }
        return true;
    }



}