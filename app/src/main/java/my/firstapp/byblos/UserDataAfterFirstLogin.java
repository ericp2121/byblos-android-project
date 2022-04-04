package my.firstapp.byblos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserDataAfterFirstLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data_after_first_login);

        Button saveUserDataButton = (Button) findViewById(R.id.buttonSaveUserData);

        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();

        EditText username = (EditText) findViewById(R.id.usernameCreate5);
        EditText email = (EditText) findViewById(R.id.emailID5);

        saveUserDataButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                User user = new User();




                //EditText password1 = (EditText) findViewById(R.id.passwordSet);
                //EditText password2 = (EditText) findViewById(R.id.passwordSet2);
                //String pass1 = password1.getText().toString();
                //String pass2 = password2.getText().toString();
                //boolean pass = passwordCheck(pass1, pass2);


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

                String customer = "";
                RadioButton accountTypeCustomer = (RadioButton) findViewById(R.id.customerRadioButton);
                customer = accountTypeCustomer.getText().toString();

                String employee = "";
                RadioButton accountTypeEmployee = (RadioButton) findViewById(R.id.employeeRadioButton);
                employee = accountTypeEmployee.getText().toString();


                String accountType = "";

                if (accountTypeCustomer.isChecked()) {
                    accountType = "Customer";
                }
                else if (accountTypeEmployee.isChecked()) {
                    accountType = "Employee";
                }

                CurrentUser.currentUserAccountType = accountType;
                user.userAccountType = accountType;

//                if(user.userAccountType.equals("Employee")) {
//                    username.setHint("Enter Code");
//                }

                String name = username.getText().toString();


                String emailId = email.getText().toString();
                boolean isCorrect = emailCheck(emailId);

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

                else if(!pass) {
                    password1.setText("");
                    password2.setText("");
                }

                 */



                    Intent intent = new Intent(UserDataAfterFirstLogin.this, CustomerHomeScreen.class);
                    Intent intent2 = new Intent(UserDataAfterFirstLogin.this, Admin_Master.class);
                    Intent employeeZip = new Intent(UserDataAfterFirstLogin.this, EmployeeZipCodeAfterFirstLogin.class);

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
                    String finalAccountType = accountType;

                    /*
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


                     */


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

                    //mAuth.signOut();
                    FirebaseAuth mAuthTwo = FirebaseAuth.getInstance();
                    CurrentUser.currentUserId = "";
                    //mAuthTwo.signInWithEmailAndPassword(emailId, pass2);
                    CurrentUser.currentUserId = mAuthTwo.getUid();
                    //mAuthTwo.signOut();

                    String firstTime = "F";
                    CurrentUser.currentUserFirstTime = firstTime;

                    user.userFirstTime = firstTime;
                    user.userName = name;

                    if (user.userAccountType.equals("Customer")) {
                        user.zipCode = null;
                        user.isVerified = null;
                    }
                    else {
                        user.zipCode = "";
                        user.isVerified = "F";
                    }

                    //DatabaseReference ref = database.getReference();

                    //DatabaseReference newUserTypeReference = database.child("users/.")
                    //DatabaseReference newUserTypeReference = database.getReference("users/" + CurrentUser.currentUserId + "/accountType");
                    //DatabaseReference newUserNameReference = database.getReference("users/" + CurrentUser.currentUserId + "/userName");
                    //DatabaseReference userFirstSignIn = database.getReference("users/" + CurrentUser.currentUserId + "/firstLogin");
                    //newUserTypeReference.setValue(finalAccountType);
                    //newUserNameReference.setValue(name);
                    //userFirstSignIn.setValue(firstTime);

                    DatabaseReference mdatabase;
                    mdatabase = database.getInstance().getReference();

                    mdatabase.child("users").child(CurrentUser.currentUserId).setValue(user);

                    //DatabaseReference ref = database.getReference("server/path/to/users");

                    // Attach a listener to read the data at your profile reference
                /*
                    userFirstSignIn.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ContactsContract.Profile profile = dataSnapshot.getValue(ContactsContract.Profile.class);
                        //CurrentUser.currentUserFirstTime = profile.
                        //System.out.println(profile.getUsername());

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                });

                 */

                    /*
                    ref.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                        Post newPost = dataSnapshot.getValue(Post.class);
                        System.out.println("Author: " + newPost.author);
                        System.out.println("Title: " + newPost.title);
                        System.out.println("Previous Post ID: " + prevChildKey);
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {}

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

                    @Override
                    public void onCancelled(DatabaseError databaseError) {}
                });

                     */


                    //®FirebaseAuth.getInstance().signOut();

//                    startActivity(intent);

                    if (user.userAccountType.equals("Employee")) {
                        startActivity(employeeZip);
                    }
                    else {
                        startActivity(intent);
                    }


            }
        });

        //finish();

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