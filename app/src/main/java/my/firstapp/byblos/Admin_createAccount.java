package my.firstapp.byblos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.SecurityPermission;
import java.util.ArrayList;

public class Admin_createAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_create_account);

        Spinner findServices = (Spinner) findViewById(R.id.seeServicesNotApproved);
        Spinner findServicesTrucks = (Spinner) findViewById(R.id.seeTrucksNotApproved);
        Spinner findServicesMoving = (Spinner) findViewById(R.id.seeMovingNotApproved);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mdatabase = database.getReference();
        DatabaseReference ref = mdatabase.child("CarRentalInfo");
        DatabaseReference ref2 = mdatabase.child("TruckRentalInfo");
        DatabaseReference ref3 = mdatabase.child("MovingAssistanceInfo");

        //User userLoggingIn = new User();

        ArrayList<CarRental> carRentalArray = new ArrayList<CarRental>();
        ArrayList<TruckRental> truckRentalArray = new ArrayList<TruckRental>();
        ArrayList<MovingAssistance> movingAssistanceArray = new ArrayList<MovingAssistance>();

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
//                String[] servicesToDisplay = null;
                int i = 0;
                ArrayList<String> arrayList = new ArrayList<>();

                for ( DataSnapshot child : children ) {

                    CarRental carRental = child.getValue(CarRental.class);
//                    carRentalArray.add(carRental);
                    i++;
                    if(carRental.getIsApproved().equals("F")) {
                        carRentalArray.add(carRental);
                        String displayString = carRental.getCarType() + " " + carRental.getEstimatedPrice();
//                        servicesToDisplay[i] = displayString;
//                        i++;
                        arrayList.add(displayString);
                    }

                }

                int sizeOfArray = arrayList.size();

//                String stringForSpinner[sizeOfArray] = new String();
                String[] stringForSpinner = new String[sizeOfArray];
                for (int j = 0; j < stringForSpinner.length; j++) {
                    stringForSpinner[j] = arrayList.get(j);
                }

                ArrayAdapter<String> adapter = new ArrayAdapter(Admin_createAccount.this, android.R.layout.simple_spinner_item, stringForSpinner);

//                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Admin_createAccount.this,
//                        android.R.layout.simple_spinner_item, stringForSpinner);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                findServices.setAdapter(adapter);
                findServices.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        ServiceSelected.selected = "CarRental";

                        Intent intent = new Intent(Admin_createAccount.this, DisplayData.class);
                        CarRental.setCustomerFirstName(carRentalArray.get(position).getCustomerFirstName());
                        CarRental.setCustomerLastName(carRentalArray.get(position).getCustomerLastName());
                        CarRental.setCarType(carRentalArray.get(position).getCarType());
                        CarRental.setPickUpDate(carRentalArray.get(position).getPickUpDate());
                        CarRental.setDropOffDate(carRentalArray.get(position).getDropOffDate());
                        CarRental.setEstimatedPrice(carRentalArray.get(position).getEstimatedPrice());
                        CarRental.setIsApproved(carRentalArray.get(position).getIsApproved());
                        CarRental.setDropOffTime(carRentalArray.get(position).getDropOffTime());
                        CarRental.setPickUpTime(carRentalArray.get(position).getPickUpTime());
                        CarRental.setCustomerLicenseType(carRentalArray.get(position).getCustomerLicenseType());
                        CarRental.setCustomerBirthDate(carRentalArray.get(position).getCustomerBirthDate());
//                        startActivity(intent);
                        //finish();
                        //startActivity(intent);

                        Button showDataBtn = (Button) findViewById(R.id.showRequestData);
                        showDataBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(intent);
                            }
                        });

                    }
                    @Override
                    public void onNothingSelected(AdapterView <?> parent) {
                    }
                });


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

//                ref2.addValueEventListener(postListenerTrucks);

                ValueEventListener postListenerTrucks = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get Post object and use the values to update the UI
                        Iterable<DataSnapshot> childrenTruck = dataSnapshot.getChildren();
//                String[] servicesToDisplay = null;
                        int i = 0;
                        ArrayList<String> arrayList = new ArrayList<>();

                        for ( DataSnapshot child : childrenTruck ) {

                            TruckRental truckRental = child.getValue(TruckRental.class);
//                    carRentalArray.add(carRental);
                            i++;
                            if((truckRental != null)&&(truckRental.getIsApproved().equals("F"))) {
                                truckRentalArray.add(truckRental);
                                String displayString = truckRental.getAreaDrivenIn() + " " + truckRental.getEstimatedPrice();
//                        servicesToDisplay[i] = displayString;
//                        i++;
                                arrayList.add(displayString);
                            }

                        }

                        int sizeOfArray = arrayList.size();

//                String stringForSpinner[sizeOfArray] = new String();
                        String[] stringForSpinner = new String[sizeOfArray];
                        for (int j = 0; j < stringForSpinner.length; j++) {
                            stringForSpinner[j] = arrayList.get(j);
                        }

                        ArrayAdapter<String> adapter2 = new ArrayAdapter(Admin_createAccount.this, android.R.layout.simple_spinner_item, stringForSpinner);

//                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Admin_createAccount.this,
//                        android.R.layout.simple_spinner_item, stringForSpinner);
                        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        findServicesTrucks.setAdapter(adapter2);
                        findServicesTrucks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                ServiceSelected.selected = "TruckRental";

                                Intent intent = new Intent(Admin_createAccount.this, DisplayData.class);
                                TruckRental.setCustomerFirstName(truckRentalArray.get(position).getCustomerFirstName());
                                TruckRental.setCustomerLastName(truckRentalArray.get(position).getCustomerLastName());
                                TruckRental.setCustomerBirthDate(truckRentalArray.get(position).getCustomerBirthDate());
                                TruckRental.setDriverLicenseType(truckRentalArray.get(position).getDriverLicenseType());
                                TruckRental.setPickUpDate(truckRentalArray.get(position).getPickUpDate());
                                TruckRental.setDropOffDate(truckRentalArray.get(position).getDropOffDate());
                                TruckRental.setEstimatedPrice(truckRentalArray.get(position).getEstimatedPrice());
                                TruckRental.setIsApproved(truckRentalArray.get(position).getIsApproved());
                                TruckRental.setDropOffTime(truckRentalArray.get(position).getDropOffTime());
                                TruckRental.setPickUpTime(truckRentalArray.get(position).getPickUpTime());
                                TruckRental.setRangeDriven(truckRentalArray.get(position).getRangeDriven());
                                TruckRental.setAreaDrivenIn(truckRentalArray.get(position).getAreaDrivenIn());
//                                startActivity(intent);
                                //finish();
                                //startActivity(intent);

                                Button showDataBtn = (Button) findViewById(R.id.showRequestData);
                                showDataBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        startActivity(intent);
                                    }
                                });

                            }
                            @Override
                            public void onNothingSelected(AdapterView <?> parent) {
                            }
                        });


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

                        ValueEventListener postListenerMoving = new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                // Get Post object and use the values to update the UI
                                Iterable<DataSnapshot> childrenTruck = dataSnapshot.getChildren();
//                String[] servicesToDisplay = null;
                                int i = 0;
                                ArrayList<String> arrayList = new ArrayList<>();

                                for ( DataSnapshot child : childrenTruck ) {

                                    MovingAssistance movingAssistance = child.getValue(MovingAssistance.class);
//                    carRentalArray.add(carRental);
                                    i++;
                                    if(movingAssistance.getIsApproved().equals("F")) {
                                        movingAssistanceArray.add(movingAssistance);
                                        String displayString = movingAssistance.getStartingAddress() + " " + movingAssistance.getEstimatedPrice();
//                        servicesToDisplay[i] = displayString;
//                        i++;
                                        arrayList.add(displayString);
                                    }

                                }

                                int sizeOfArray = arrayList.size();

//                String stringForSpinner[sizeOfArray] = new String();
                                String[] stringForSpinner = new String[sizeOfArray];
                                for (int j = 0; j < stringForSpinner.length; j++) {
                                    stringForSpinner[j] = arrayList.get(j);
                                }

                                ArrayAdapter<String> adapter3 = new ArrayAdapter(Admin_createAccount.this, android.R.layout.simple_spinner_item, stringForSpinner);

//                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Admin_createAccount.this,
//                        android.R.layout.simple_spinner_item, stringForSpinner);
                                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                findServicesMoving.setAdapter(adapter3);
                                findServicesMoving.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                        ServiceSelected.selected = "MovingAssistance";

                                        Intent intent = new Intent(Admin_createAccount.this, DisplayData.class);
                                        MovingAssistance.setCustomerFirstName(movingAssistanceArray.get(position).getCustomerFirstName());
                                        MovingAssistance.setCustomerLastName(movingAssistanceArray.get(position).getCustomerLastName());
                                        MovingAssistance.setCustomerBirthDate(movingAssistanceArray.get(position).getCustomerBirthDate());
                                        MovingAssistance.setCustomerAddress(movingAssistanceArray.get(position).getCustomerAddress());
                                        MovingAssistance.setCustomerEmailId(movingAssistanceArray.get(position).getCustomerEmailId());
                                        MovingAssistance.setStartingAddress(movingAssistanceArray.get(position).getStartingAddress());
                                        MovingAssistance.setEndingAddress(movingAssistanceArray.get(position).getEndingAddress());
                                        MovingAssistance.setNumberOfMoversRequested(movingAssistanceArray.get(position).getNumberOfMoversRequested());
                                        MovingAssistance.setEstimatedPrice(movingAssistanceArray.get(position).getEstimatedPrice());
                                        MovingAssistance.setNumberOfBoxes(movingAssistanceArray.get(position).getNumberOfBoxes());
                                        MovingAssistance.setIsApproved(movingAssistanceArray.get(position).getIsApproved());
//                                        startActivity(intent);
//                                        MovingAssistance.setAreaDrivenIn(movingAssistanceArray.get(position).getAreaDrivenIn());
                                        //finish();
                                        //startActivity(intent);

                                        Button showDataBtn = (Button) findViewById(R.id.showRequestData);
                                        showDataBtn.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                startActivity(intent);
                                            }
                                        });

                                    }
                                    @Override
                                    public void onNothingSelected(AdapterView <?> parent) {
                                    }
                                });


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
                        ref2.addValueEventListener(postListenerMoving);


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Getting Post failed, log a message
                        //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    }
                };
                ref3.addValueEventListener(postListenerTrucks);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }

        };
        ref.addValueEventListener(postListener);


//        ref2.addValueEventListener(postListenerTrucks);

    }
}