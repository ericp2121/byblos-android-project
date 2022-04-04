//Hello Eric!
package my.firstapp.byblos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    public static User userLoggingIn = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createAccountInitialButton = (Button) findViewById(R.id.createAccount);

        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();

        createAccountInitialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MainActivity_CreateAccount.class);
                startActivity(intent);
            }
        });

        Button loginAccountButton = (Button) findViewById(R.id.loginButton);
        /*
        EditText name = (EditText) findViewById(R.id.username);
        String userName = name.getText().toString();

        EditText pass = (EditText) findViewById(R.id.password);
        String passWord = pass.getText().toString();
         */




        loginAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent, intentAdmin, intentLogin;
                intent = new Intent(MainActivity.this, UserDataAfterFirstLogin.class);
                intentLogin = new Intent(MainActivity.this, MainActivity2.class);
                Intent customerHomeScreen = new Intent(MainActivity.this, CustomerHomeScreen.class);
                intentAdmin = new Intent(MainActivity.this, Admin_Master.class);
                Intent registeredEmployeeLogin = new Intent(MainActivity.this, Employee_login.class);
                // why tf this aint work :(
                /*
                if ((userName.equals("admin") && passWord.equals("admin"))) {
                    intent = new Intent(MainActivity.this, AdminFunctionality.class);
                    startActivity(intent);
                }
                else {
                    intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
                */

                EditText name = (EditText) findViewById(R.id.username);
                String userName = name.getText().toString();

                EditText pass = (EditText) findViewById(R.id.password);
                String passWord = pass.getText().toString();

                //if ((userName.length() == 0) || (passWord.length() == 0)) {
                //    userName = "t@t.com";
                //    passWord = "123456";
                //    CurrentUser.currentUserName = userName;
                //}

                if (userName.equals("admin")) {
                    if (passWord.equals("admin")) {
                        userName = "admin@admin.com";
                        passWord = "admin123";
                    }
                }

                if (userName.equals("employee")) {
                    if (passWord.equals("employee")) {
                        userName = "employee@employee.com";
                        passWord = "employee";
                    }
                }

                String finalUserName = userName;
                mAuth.signInWithEmailAndPassword(userName, passWord)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    //Log.d(TAG, "signInWithEmail:success");
                                    final FirebaseUser[] user = {mAuth.getCurrentUser()};
                                    updateUI(user[0]);
                                    if (finalUserName.equals("admin@admin.com")) {
                                        startActivity(intentAdmin);
                                    }
                                    else {
                                        //FirebaseDatabase database = FirebaseDatabase.getInstance();
                                        //DatabaseReference accountTypeReference = database.getReference("users/" + CurrentUser.currentUserId + "/accountType");
                                        //database.child("users").child(UserID).child("profile").child("username").getValue().toString();
                                        //startActivity(intent);

                                        /*
                                        accountTypeReference.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                ContactsContract.Profile profile = dataSnapshot.getValue(ContactsContract.Profile.class);
                                                CurrentUser.currentUserFirstTime = profile.toString();
                                                //System.out.println(profile.getUsername());

                                            }

                                            @Override
                                            public void onCancelled(DatabaseError databaseError) {
                                                System.out.println("The read failed: " + databaseError.getCode());
                                            }
                                        });

                                         */

                                        //if (CurrentUser.currentUserFirstTime.equals("F")) {
                                          //  startActivity(intentLogin);
                                        //}
                                        //else {
                                           // startActivity(intent);
                                        //}

                                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                                        DatabaseReference mdatabase = database.getInstance().getReference();
                                        //user = new User();
                                        DatabaseReference ref = mdatabase.child("users").child(CurrentUser.currentUserId).getRef();


//                                        mdatabase.child("users").child(CurrentUser.currentUserId).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//                                            @Override
//                                            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                                                if (!task.isSuccessful()) {
//                                                    userLoggingIn = task.getResult().getValue(User.class);
//                                                    //Log.e("firebase", "Error getting data", task.getException());
//                                                }
//                                                else {
//                                                    //Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                                                }
//                                            }
//                                        });

                                        ValueEventListener postListener = new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                // Get Post object and use the values to update the UI
                                                userLoggingIn = dataSnapshot.getValue(User.class);

                                                // ..

                                                if (userLoggingIn == null) {
                                                    CurrentUser.currentUserFirstTime = "T";
                                                }
                                                else {
                                                    CurrentUser.currentUserFirstTime = userLoggingIn.userFirstTime;
                                                    CurrentUser.isVerified = userLoggingIn.isVerified;
                                                }

                                                if (CurrentUser.currentUserFirstTime.equals("F")) {

                                                    if (CurrentUser.isVerified != null) {
                                                        if (CurrentUser.isVerified.equals("T")) {
                                                            startActivity(registeredEmployeeLogin);
                                                        }
                                                        else {
                                                            startActivity(intentLogin);
                                                        }
                                                    }
                                                    else {
                                                        startActivity(customerHomeScreen);
                                                    }

//                                                    else {
//                                                        if (CurrentUser.currentUserFirstTime.equals("T")||(userLoggingIn == null) ) {
//                                                            startActivity(intent);
//                                                        }
//                                                        else {
//                                                            startActivity(customerHomeScreen);
//                                                        }
//                                                    }

//                                                    if (CurrentUser.isVerified.equals("T")) {
//                                                        startActivity(registeredEmployeeLogin);
//                                                    }
//                                                    else if (CurrentUser.isVerified == null) {
//                                                        startActivity(intentLogin);
//                                                    }
                                                }
                                                else if (CurrentUser.currentUserFirstTime.equals("T")||(userLoggingIn == null) ) {
                                                    startActivity(intent);
                                                }
                                                else {
                                                    startActivity(customerHomeScreen);
                                                }


                                            }

                                            @Override
                                            public void onCancelled(DatabaseError databaseError) {
                                                // Getting Post failed, log a message
                                                //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                                            }
                                        };
                                        ref.addValueEventListener(postListener);

//                                        if (userLoggingIn.userFirstTime.equals("F")) {
//                                            startActivity(intentLogin);
//                                        }
//                                        else if (userLoggingIn.userFirstTime.equals("T")) {
//                                            startActivity(intent);
//                                        }

                                    }
                                    //startActivity(intent);
                                }

                                //finish();
//                                else {
//                                    // If sign in fails, display a message to the user.
//                                    //Log.w(TAG, "signInWithEmail:failure", task.getException());
//                                    //Toast.makeText(MainActivity.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
//                                    //updateUI(null);
//                                }
                            }
                        });




                //  FirebaseDatabase database = FirebaseDatabase.getInstance();
                //DatabaseReference databaseReference = database.getReference("users/" + userName);

                //if (databaseReference.child("password").toString().equals(passWord)) {
                  //  startActivity(intent);
                //}
                /*
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                DatabaseReference mostafa = ref.child("users").child(userName).child("password");

                mostafa.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String pass = dataSnapshot.getValue(String.class);
                        //do what you want with the email
                        if (pass.equals(passWord))
                            startActivity(intent);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        name.setText("");
                        pass.setText("");
                    }
                });
                */

                /*
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String value = snapshot.getValue(String.class);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        name.setText("");
                        pass.setText("");
                        Toast.makeText(MainActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
                    }
                });
                */
                //Insert Code to pass data from Linked List.
                //String name = usernameFilled();
                //String pass = passwordFilled();



            }
        });
    }

    public void updateUI (FirebaseUser user) {
        if (user == null) return;
        CurrentUser.currentUserName = user.getEmail();
        CurrentUser.currentUserId = user.getUid();
    }

    public String usernameFilled () {
        EditText username = (EditText) findViewById(R.id.username);
        String name = username.getText().toString();
        return name;
    }

    public String passwordFilled () {
        EditText password = (EditText) findViewById(R.id.password);
        String pass = password.getText().toString();
        return pass;
    }

    @Override
    protected void onResume() {
        super.onResume();
//        FirebaseAuth mAuth = FirebaseAuth.getInstance();
//        mAuth.signOut();
//        finish();
    }


}