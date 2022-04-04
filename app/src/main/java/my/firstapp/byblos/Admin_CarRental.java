package my.firstapp.byblos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Admin_CarRental extends AppCompatActivity {
    //Eric's logic part
    double total;
    long dayDiff, diff;
    String pickDate, dropDate,carType;
    final double toyotaRate = 65;
    final double hondaRate = 85;
    final double buickRate = 115;
    Button totalCost;
    //Eric's logic part

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_car_rental);

        Button submitFormButton = (Button) findViewById(R.id.enterAll);

        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();

        Intent intent = new Intent(Admin_CarRental.this, Msg_DataSaved.class);

        //Eric's logic part for price

        TextView output = (TextView) findViewById(R.id.carPrice);
        totalCost = findViewById(R.id.btnCost);

        EditText first = (EditText) findViewById(R.id.firstNameEditor);
        EditText last = (EditText) findViewById(R.id.lastNameEditor);
        EditText birth = (EditText) findViewById(R.id.birthEditor);
        Spinner licenses = (Spinner) findViewById(R.id.licenses);
//        EditText pick = (EditText) findViewById(R.id.pickUpDateEditor);
        EditText pickTime = (EditText) findViewById(R.id.pickUpTimeEditor);
//        EditText drop = (EditText) findViewById(R.id.dropDateEditor);
        EditText dropTime = (EditText) findViewById(R.id.dropTimeEditor);
//        Spinner car = (Spinner) findViewById(R.id.carOptions);
        Spinner car = (Spinner) findViewById(R.id.carOptions);
        EditText pick = (EditText) findViewById(R.id.pickUpDateEditor);
        EditText drop = (EditText) findViewById(R.id.dropDateEditor);

        totalCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String carType = car.getSelectedItem().toString();
                CarRental.setCarType(carType);

                if (pick.getText() == null) {
                    output.setText("One (or more) of the fields are blank, please enter information.");
                    return;
                }
                String pickDate = pick.getText().toString();
                CarRental.setPickUpDate(pickDate);

                if (drop.getText() == null) {
                    output.setText("One (or more) of the fields are blank, please enter information.");
                    return;
                }
                String dropDate = drop.getText().toString();
                CarRental.setDropOffDate(dropDate);

//                TextView output = (TextView) findViewById(R.id.carPrice);


                try {
                    total = getPrice(pickDate,dropDate,carType);
                    output.setText("Your total is "+total);
                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }
        });

        //Eric's logic part for price



        submitFormButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String firstName = first.getText().toString();
                CarRental.setCustomerFirstName(firstName);


                String lastName = last.getText().toString();
                CarRental.setCustomerLastName(lastName);


                String birthDate = birth.getText().toString();
                CarRental.setCustomerBirthDate(birthDate);


                String licenseType = licenses.getSelectedItem().toString();
                CarRental.setCustomerLicenseType(licenseType);


                String carType = car.getSelectedItem().toString();
                CarRental.setCarType(carType);


                String pickUpDate = pick.getText().toString();
                CarRental.setPickUpDate(pickUpDate);


                String pickUpTime = pickTime.getText().toString();
                CarRental.setPickUpTime(pickUpTime);


                String dropOffDate = drop.getText().toString();
                CarRental.setDropOffDate(dropOffDate);


                String dropOffTime = dropTime.getText().toString();
                CarRental.setDropOffTime(dropOffTime);

                try {
                    total = getPrice(pickUpDate,dropOffDate,carType);
                    output.setText("Your total is "+total);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String totalString = Double.toString(total);
                CarRental.setEstimatedPrice(totalString);


                //Intent intent = new Intent(MainActivity_CreateAccount.this, MainActivity.class);
                //Intent intent2 = new Intent(MainActivity_CreateAccount.this, MainActivity2.class);

                //FirebaseDatabase database = FirebaseDatabase.getInstance();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference firstNameReference = database.getReference("CarRentalInfo/" + firstName + " " + lastName + "/firstName");
//                DatabaseReference lastNameReference = database.getReference("CarRentalInfo/" + firstName + " " + lastName + "/lastName");
//                DatabaseReference birthDateReference = database.getReference("CarRentalInfo/" + firstName + " " + lastName + "/dob");
//                DatabaseReference licenseReference = database.getReference("CarRentalInfo/" + firstName + " " + lastName + "/licenseType");
//                DatabaseReference carReference = database.getReference("CarRentalInfo/" + firstName + " " + lastName + "/carType");
//                DatabaseReference pickDateReference = database.getReference("CarRentalInfo/" + firstName + " " + lastName + "/pickUpDate");
//                DatabaseReference pickTimeReference = database.getReference("CarRentalInfo/" + firstName + " " + lastName + "/pickUpTime");
//                DatabaseReference dropDateReference = database.getReference("CarRentalInfo/" + firstName + " " + lastName + "/dropOffDate");
//                DatabaseReference dropTimeReference = database.getReference("CarRentalInfo/" + firstName + " " + lastName + "/dropOffTime");
//
//                firstNameReference.setValue(firstName);
//                lastNameReference.setValue(lastName);
//                birthDateReference.setValue(birthDate);
//                licenseReference.setValue(licenseType);
//                carReference.setValue(carType);
//                pickDateReference.setValue(pickUpDate);
//                pickTimeReference.setValue(pickUpTime);
//                dropDateReference.setValue(dropOffDate);
//                dropTimeReference.setValue(dropOffTime);

                if (CurrentUser.currentUserAccountType.equals("Customer")) {
                    CarRental.isApproved = "F";
                }
                else {
                    CarRental.isApproved = "T";
                }

                String databaseReference = firstName + "_" + lastName;
                CarRental carRental = new CarRental(CarRental.customerFirstName, CarRental.customerLastName,
                        CarRental.customerBirthDate, CarRental.customerLicenseType, CarRental.carType,
                        CarRental.pickUpDate, CarRental.dropOffDate, CarRental.pickUpTime, CarRental.dropOffTime,
                        CarRental.estimatedPrice, CarRental.isApproved);

                DatabaseReference mdatabase = database.getReference();
                mdatabase.child("CarRentalInfo").child(databaseReference).setValue(carRental);



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
    public Double getPrice(String dateA, String dateB, String carSelect)
            throws ParseException {
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
                Date firstDate = sdf.parse(dateA);
                Date secondDate = sdf.parse(dateB);

                diff = Math.abs(secondDate.getTime() - firstDate.getTime());
                dayDiff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

                if (carSelect.equals("Toyota Corolla 2020")) {
                    total = dayDiff*toyotaRate;
                }
                else if (carSelect.equals("Honda CR-V 2020")) {
                    total = dayDiff*hondaRate;
                }
                else if (carSelect.equals("Buick Enclave 2020")) {
                    total = dayDiff*buickRate;
                }

                return total;
    }
    //Eric's logic part


}