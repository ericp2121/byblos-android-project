package my.firstapp.byblos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Admin_TruckRental extends AppCompatActivity {
    //Eric code
    double total;
    long dayDiff, diff;
    String pickDate, dropDate, range;
    final double kmCost = 0.50;
    final double dayCost = 184.30;
    Button totalCost;
    //Eric code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_truck_rental);

//        TruckRental truckRental = new TruckRental();

        //Eric code

        TextView output = (TextView) findViewById(R.id.truckPrice);
        totalCost = findViewById(R.id.btnTruckCost);

        EditText rangeEdit = (EditText) findViewById(R.id.rangeEditor);
        EditText pick = (EditText) findViewById(R.id.pickUpDateEditor);
        EditText drop = (EditText) findViewById(R.id.dropDateEditor);
        EditText first = (EditText) findViewById(R.id.firstNameEditor);
        EditText last = (EditText) findViewById(R.id.lastNameEditor);
        EditText birth = (EditText) findViewById(R.id.birthEditor);
        EditText license = (EditText) findViewById(R.id.licenseTypeEditor);
//        EditText pickDate = (EditText) findViewById(R.id.pickUpDateEditor);
        EditText pickTime = (EditText) findViewById(R.id.pickUpTimeEditor);
//        EditText dropDate = (EditText) findViewById(R.id.dropDateEditor);
        EditText dropTime = (EditText) findViewById(R.id.dropTimeEditor);
        EditText range = (EditText) findViewById(R.id.rangeEditor);
        EditText area = (EditText) findViewById(R.id.areaEditor);

        totalCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String range = rangeEdit.getText().toString();


                String pickDate = pick.getText().toString();


                String dropDate = drop.getText().toString();


                try {
                    total = getTruckPrice(pickDate,dropDate,range);
                    output.setText("Your total is "+total);
                } catch (ParseException e) {
                    e.printStackTrace();
                }



            }
        });

        //Eric code
        Button submitFormButton = (Button) findViewById(R.id.enterAll);

        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();

        Intent intent = new Intent(Admin_TruckRental.this, Msg_DataSaved.class);

        submitFormButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String firstName = first.getText().toString();
                TruckRental.setCustomerFirstName(firstName);


                String lastName = last.getText().toString();
                TruckRental.setCustomerLastName(lastName);


                String birthDate = birth.getText().toString();
                TruckRental.setCustomerBirthDate(birthDate);


                String licenseType = license.getText().toString();
                TruckRental.setDriverLicenseType(licenseType);


                String pickUpDate = pick.getText().toString();
                TruckRental.setPickUpDate(pickUpDate);


                String pickUpTime = pickTime.getText().toString();
                TruckRental.setPickUpTime(pickUpTime);


                String dropOffDate = drop.getText().toString();
                TruckRental.setDropOffDate(dropOffDate);


                String dropOffTime = dropTime.getText().toString();
                TruckRental.setDropOffTime(dropOffTime);


                String rangeDriven = range.getText().toString();
                TruckRental.setRangeDriven(rangeDriven);


                String areaUsedIn = area.getText().toString();
                TruckRental.setAreaDrivenIn(areaUsedIn);

                try {
                    total = getTruckPrice(pickUpDate,dropOffDate,rangeDriven);
                    output.setText("Your total is "+total);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String totalString = Double.toString(total);
                TruckRental.setEstimatedPrice(totalString);

                //Intent intent = new Intent(MainActivity_CreateAccount.this, MainActivity.class);
                //Intent intent2 = new Intent(MainActivity_CreateAccount.this, MainActivity2.class);

                //FirebaseDatabase database = FirebaseDatabase.getInstance();

                //FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference firstNameReference = database.getReference("TruckRentalInfo/" + firstName + " " + lastName + "/firstName");
//                DatabaseReference lastNameReference = database.getReference("TruckRentalInfo/" + firstName + " " + lastName + "/lastName");
//                DatabaseReference birthDateReference = database.getReference("TruckRentalInfo/" + firstName + " " + lastName + "/dob");
//                DatabaseReference licenseReference = database.getReference("TruckRentalInfo/" + firstName + " " + lastName + "/licenseType");
//                DatabaseReference rangeReference = database.getReference("TruckRentalInfo/" + firstName + " " + lastName + "/rangeDriven");
//                DatabaseReference areaReference = database.getReference("TruckRentalInfo/" + firstName + " " + lastName + "/areaDrivenIn");
//                DatabaseReference pickDateReference = database.getReference("TruckRentalInfo/" + firstName + " " + lastName + "/pickUpDate");
//                DatabaseReference pickTimeReference = database.getReference("TruckRentalInfo/" + firstName + " " + lastName + "/pickUpTime");
//                DatabaseReference dropDateReference = database.getReference("TruckRentalInfo/" + firstName + " " + lastName + "/dropOffDate");
//                DatabaseReference dropTimeReference = database.getReference("TruckRentalInfo/" + firstName + " " + lastName + "/dropOffTime");
//
//                firstNameReference.setValue(firstName);
//                lastNameReference.setValue(lastName);
//                birthDateReference.setValue(birthDate);
//                licenseReference.setValue(licenseType);
//                rangeReference.setValue(rangeDriven);
//                areaReference.setValue(areaUsedIn);
//                pickDateReference.setValue(pickUpDate);
//                pickTimeReference.setValue(pickUpTime);
//                dropDateReference.setValue(dropOffDate);
//                dropTimeReference.setValue(dropOffTime);

                TruckRental.setIsApproved("T");

                if (CurrentUser.currentUserAccountType.equals("Customer")) {
                    TruckRental.setIsApproved("F");
//                    TruckRental.isApproved = "F";
                }
                else {
                    TruckRental.setIsApproved("T");
//                    TruckRental.isApproved = "T";
                }



                String databaseReference = firstName + "_" + lastName;
                TruckRental truckRental = new TruckRental(TruckRental.customerFirstName, TruckRental.customerLastName,
                        TruckRental.customerBirthDate, TruckRental.driverLicenseType, TruckRental.pickUpDate, TruckRental.dropOffDate,
                        TruckRental.pickUpTime, TruckRental.dropOffTime, TruckRental.estimatedPrice, TruckRental.rangeDriven,
                        TruckRental.areaDrivenIn, TruckRental.isApproved);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference mdatabase = database.getReference();
                mdatabase.child("TruckRentalInfo").child(databaseReference).setValue(truckRental);

                startActivity(intent);
                finish();

            }


        });
    }

    //Insert Code to pass data from Linked List.



    public void updateUI(FirebaseUser user) {
        //CurrentUser.currentUserId = user.getUid();
        return;
    }




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

    public boolean passwordCheck (String password1, String password2) {
        if (!password1.equals(password2)) {
            return false;
        }

        if (password1.length() < 6) {
            return false;
        }
        return true;
    }
    //Eric's logic part
    public Double getTruckPrice(String dateA, String dateB, String distance)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(dateA);
        Date secondDate = sdf.parse(dateB);

        diff = Math.abs(secondDate.getTime() - firstDate.getTime());
        dayDiff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        total = (dayDiff*dayCost)+(Double.parseDouble(distance)*kmCost);

        return total;
    }
    //Eric's logic part

}




