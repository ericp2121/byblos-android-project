package my.firstapp.byblos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EmployeeZipCodeAfterFirstLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_zip_code_after_first_login);

        EditText zipCodeEntered = (EditText) findViewById(R.id.zipCodeEditor);
        Button saveZipCodeButton = (Button) findViewById(R.id.zipCodeSubmitBtn);

        saveZipCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zipCodeString = zipCodeEntered.getText().toString();
                CurrentUser.zipCode = zipCodeString;

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference mdatabase = database.getReference();
                DatabaseReference ref = mdatabase.child("employees").child(zipCodeString);

                //User userLoggingIn = new User();

                ValueEventListener postListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get Post object and use the values to update the UI
                        if(!dataSnapshot.exists()) {
                            CurrentUser.isVerified = "F";
                        }
                        else {
                            CurrentUser.isVerified = "T";
                        }
                        // ..

                        DatabaseReference refUpdate = mdatabase.child("users").child(CurrentUser.currentUserId);
                        User user = new User(CurrentUser.currentUserName, CurrentUser.currentUserAccountType,
                                CurrentUser.currentUserFirstTime, CurrentUser.zipCode, CurrentUser.isVerified);
                        refUpdate.setValue(user);

                        Intent intentEmployee = new Intent(EmployeeZipCodeAfterFirstLogin.this, Employee_login.class);
                        Intent toBeVerified = new Intent(EmployeeZipCodeAfterFirstLogin.this, MainActivity2.class);

                        if (CurrentUser.isVerified.equals("T")) {
                            startActivity(intentEmployee);
                        }
                        else {
                            startActivity(toBeVerified);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Getting Post failed, log a message
                        //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    }
                };
                ref.addValueEventListener(postListener);

                //finish();


            }
        });

    }
}