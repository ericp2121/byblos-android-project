package my.firstapp.byblos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CustomerHomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home_screen);

        EditText zipCode = (EditText) findViewById(R.id.customerZipCodeEditor);
        Button searchBranch = (Button) findViewById(R.id.zipCodeSearchBtn);
        TextView resultText = (TextView) findViewById(R.id.branchFoundText);
        Button carRentalCustomer = (Button) findViewById(R.id.carRentalCustomerBtn);
        Button truckRentalCustomer = (Button) findViewById(R.id.truckRentalCustomerBtn);
        Button movingAssistanceCustomer = (Button) findViewById(R.id.movingAssistance);
        Button signOutCustomer = (Button) findViewById(R.id.signOutBtnCustomer);

        searchBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String zipCodeString = zipCode.getText().toString();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference mdatabase = database.getReference();
                DatabaseReference ref = mdatabase.child("employees").child(zipCodeString);

                //User userLoggingIn = new User();

                ValueEventListener postListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get Post object and use the values to update the UI
                        if(dataSnapshot.exists()) {
                            resultText.setText("Branch Found at the given ZIP Code!");
//                            Employee employee = dataSnapshot.getValue(Employee.class);
//                            String resultString = "Branch Found at the given ZIP Code!";
//                            resultText.setText(resultString);
                        }
                        else {
                            resultText.setText("Branch not found!");
                        }
//                        if(!dataSnapshot.exists()) {
//                            CurrentUser.isVerified = "F";
//                        }
//                        else {
//                            CurrentUser.isVerified = "T";
//                        }
                        // ..

//                        DatabaseReference refUpdate = mdatabase.child("users").child(CurrentUser.currentUserId);
//                        User user = new User(CurrentUser.currentUserName, CurrentUser.currentUserAccountType,
//                                CurrentUser.currentUserFirstTime, CurrentUser.zipCode, CurrentUser.isVerified);
//                        refUpdate.setValue(user);
//
//                        Intent intentEmployee = new Intent(EmployeeZipCodeAfterFirstLogin.this, Employee_login.class);
//                        Intent toBeVerified = new Intent(EmployeeZipCodeAfterFirstLogin.this, MainActivity2.class);
//
//                        if (CurrentUser.isVerified.equals("T")) {
//                            startActivity(intentEmployee);
//                        }
//                        else {
//                            startActivity(toBeVerified);
//                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Getting Post failed, log a message
                        //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    }
                };
                ref.addValueEventListener(postListener);

            }
        });

        carRentalCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CurrentUser.currentUserAccountType = "Customer";
                Intent intentCarRental = new Intent(CustomerHomeScreen.this, Admin_CarRental.class);
                startActivity(intentCarRental);
            }
        });

        truckRentalCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CurrentUser.currentUserAccountType = "Customer";
                Intent intentTruckRental = new Intent(CustomerHomeScreen.this, Admin_TruckRental.class);
                startActivity(intentTruckRental);
            }
        });

        movingAssistanceCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CurrentUser.currentUserAccountType = "Customer";
                Intent intentMovingAssistance = new Intent(CustomerHomeScreen.this, Admin_MovingAssistance.class);
                startActivity(intentMovingAssistance);
            }
        });

        signOutCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                mAuth.signOut();
                finish();
                Intent intentLogin = new Intent(CustomerHomeScreen.this, MainActivity.class);
                startActivity(intentLogin);
            }
        });

    }
}