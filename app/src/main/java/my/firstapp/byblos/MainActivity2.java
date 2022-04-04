package my.firstapp.byblos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseUser;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    //FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static User userLoggedIn = new User();

    public String defaultName, defaultRole;

    public void message(String userName, String role ) {
        TextView eText = findViewById(R.id.usernameWelcome);
        eText.setText("Hello "+ userName + "!");

        TextView cText = findViewById(R.id.roleWelcome);
        cText.setText("Your are logged in as a " + role.toLowerCase() + ".");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Eric's part of the deliverable 1
        defaultRole = "Default Role";
        defaultName = "Default Name";


        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        CurrentUser.currentUserId = mAuth.getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mdatabase = database.getReference();
        //user = new User();
        DatabaseReference ref = mdatabase.child("users").child(CurrentUser.currentUserId);
        //userLoggedIn = mdatabase.child("users").child("2UvhPhAGcDRtjYUcP9tAVe0fgkk2").get().getResult().getValue(User.class);

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                userLoggedIn = dataSnapshot.getValue(User.class);
                // ..
                if (!(CurrentUser.currentUserName == null))
                    CurrentUser.currentUserName = userLoggedIn.getUserName();
                    //defaultName = CurrentUser.currentUserName;
                message(userLoggedIn.userName, userLoggedIn.userAccountType);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        ref.addValueEventListener(postListener);



        /*
        FirebaseAuth mAuthTwo = FirebaseAuth.getInstance();
        //String uid = mAuthTwo.getUid().toString();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference accountTypeReference = database.getReference("users/" + CurrentUser.currentUserId + "/accountType");
        DatabaseReference userNameReference = database.getReference("users/" + CurrentUser.currentUserId + "/userName");
        //defaultRole = accountTypeReference.getKey();
        */

        //String Role;
        /*
        accountTypeReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //ContactsContract.Profile profile = dataSnapshot.getValue(ContactsContract.Profile.class);
                //CurrentUser.currentUserFirstTime = profile.
                //System.out.println(profile.getUsername());
                String value = dataSnapshot.getValue(String.class);

                //defaultRole = value.firstLogin;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

         */

        /*
        DatabaseReference user = database.getReference("users/" + CurrentUser.currentUserId + "/firstLogin");
        user.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                //UserInformation information = dataSnapshot.getValue(UserInformation.class);
                //defaultRole = information.getAccountType();
                defaultRole = dataSnapshot.getValue(UserInformation.class).toString();
                //System.out.println(information.toString());
                //System.out.println(dataSnapshot.getKey() + " was " + dinosaur.height + " meters tall.");
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                //UserInformation information = snapshot.getValue(UserInformation.class);
                //defaultRole = information.getAccountType();
                defaultRole = snapshot.getValue(UserInformation.class).toString();
                //System.out.println(information.toString());

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //UserInformation information = snapshot.getValue(UserInformation.class);
                //defaultRole = information.getAccountType();
                defaultRole = snapshot.getValue(UserInformation.class).toString();
                //System.out.println(information.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

            // ...
        });
        */

        //defaultRole = accountTypeReference.child().toString();

//        if (!(CurrentUser.currentUserName == null))
//                defaultName = CurrentUser.currentUserName;
//        message(defaultName, userLoggedIn.userAccountType);

        Button signOutButton = (Button) findViewById(R.id.signOut);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                mAuth.signOut();
                finish();
            }
        });
    };

}

