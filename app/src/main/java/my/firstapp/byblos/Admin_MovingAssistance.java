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

public class Admin_MovingAssistance extends AppCompatActivity {
    //Eric's logic part
    double total;
    String movers, boxes;
    final double boxRate = 13.50;
    final double moverRate = 56.75;
    Button totalMovingCost;
    //Eric's logic part

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_moving_assistance);

        //Eric's logic part
        TextView output = (TextView) findViewById(R.id.estimateOutput);
        totalMovingCost = findViewById(R.id.btnEstimateMove);

        EditText moversEntry = (EditText) findViewById(R.id.numMoversEditor);
        EditText boxesEntry = (EditText) findViewById(R.id.numBoxEditor);
        EditText first = (EditText) findViewById(R.id.firstNameEditor);
        EditText last = (EditText) findViewById(R.id.lastNameEditor);
        EditText birth = (EditText) findViewById(R.id.birthEditor);
        EditText addressEditText = (EditText) findViewById(R.id.addressEditor);
        EditText email = (EditText) findViewById(R.id.emailEditor);
        EditText starting = (EditText) findViewById(R.id.startEditor);
        EditText ending = (EditText) findViewById(R.id.endEditor);
        EditText numberMovers = (EditText) findViewById(R.id.numMoversEditor);
        EditText numberBoxes = (EditText) findViewById(R.id.numBoxEditor);


        totalMovingCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                movers = moversEntry.getText().toString();


                boxes = boxesEntry.getText().toString();

                total = getPrice(movers,boxes);

                output.setText("Your estimated total is "+total);

            }
        });

        //Eric's logic part



        Button submitFormButton = (Button) findViewById(R.id.enterAll);

        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();

        Intent intent = new Intent(Admin_MovingAssistance.this, Msg_DataSaved.class);

        submitFormButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String firstName = first.getText().toString();
                MovingAssistance.setCustomerFirstName(firstName);


                String lastName = last.getText().toString();
                MovingAssistance.setCustomerLastName(lastName);


                String birthDate = birth.getText().toString();
                MovingAssistance.setCustomerBirthDate(birthDate);


                String address = addressEditText.getText().toString();
                MovingAssistance.setCustomerAddress(address);


                String emailId = email.getText().toString();
                MovingAssistance.setCustomerEmailId(emailId);


                String startingAddress = starting.getText().toString();
                MovingAssistance.setStartingAddress(startingAddress);


                String endingAddress = ending.getText().toString();
                MovingAssistance.setEndingAddress(endingAddress);


                String numberOfMovers = numberMovers.getText().toString();
                MovingAssistance.setNumberOfMoversRequested(numberOfMovers);


                String numberOfBoxes = numberBoxes.getText().toString();
                MovingAssistance.setNumberOfBoxes(numberOfBoxes);

                total = getPrice(movers,boxes);
                String totalString = Double.toString(total);
                MovingAssistance.setEstimatedPrice(totalString);

                //Intent intent = new Intent(MainActivity_CreateAccount.this, MainActivity.class);
                //Intent intent2 = new Intent(MainActivity_CreateAccount.this, MainActivity2.class);

                //FirebaseDatabase database = FirebaseDatabase.getInstance();

//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference firstNameReference = database.getReference("MovingAssistanceInfo/" + firstName + " " + lastName + "/firstName");
//                DatabaseReference lastNameReference = database.getReference("MovingAssistanceInfo/" + firstName + " " + lastName + "/lastName");
//                DatabaseReference birthDateReference = database.getReference("MovingAssistanceInfo/" + firstName + " " + lastName + "/dob");
//                DatabaseReference addressReference = database.getReference("MovingAssistanceInfo/" + firstName + " " + lastName + "/address");
//                DatabaseReference emailReference = database.getReference("MovingAssistanceInfo/" + firstName + " " + lastName + "/emailId");
//                DatabaseReference startingAddressReference = database.getReference("MovingAssistanceInfo/" + firstName + " " + lastName + "/startingAddress");
//                DatabaseReference endingAddressReference = database.getReference("MovingAssistanceInfo/" + firstName + " " + lastName + "/endingAddress");
//                DatabaseReference numberMoversReference = database.getReference("MovingAssistanceInfo/" + firstName + " " + lastName + "/numberOfMovers");
//                DatabaseReference numberBoxesReference = database.getReference("MovingAssistanceInfo/" + firstName + " " + lastName + "/numberOfBoxes");
//
//                firstNameReference.setValue(firstName);
//                lastNameReference.setValue(lastName);
//                birthDateReference.setValue(birthDate);
//                addressReference.setValue(address);
//                emailReference.setValue(emailId);
//                startingAddressReference.setValue(startingAddress);
//                endingAddressReference.setValue(endingAddress);
//                numberMoversReference.setValue(numberOfMovers);
//                numberBoxesReference.setValue(numberOfBoxes);

                if (CurrentUser.currentUserAccountType.equals("Customer")) {
                    MovingAssistance.isApproved = "F";
                }
                else {
                    MovingAssistance.isApproved = "T";
                }

                MovingAssistance movingAssistance = new MovingAssistance(MovingAssistance.customerFirstName,
                        MovingAssistance.customerLastName, MovingAssistance.customerBirthDate,
                        MovingAssistance.customerAddress, MovingAssistance.customerEmailId,
                        MovingAssistance.startingAddress, MovingAssistance.endingAddress,
                        MovingAssistance.numberOfMoversRequested, MovingAssistance.estimatedPrice,
                        MovingAssistance.numberOfBoxes, MovingAssistance.isApproved);

                String databaseReference = firstName + "_" + lastName;

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference mdatabase = database.getReference();
                mdatabase.child("MovingAssistanceInfo").child(databaseReference).setValue(movingAssistance);


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
    public Double getPrice(String movers, String boxes) {

        total = (Double.parseDouble(movers)*moverRate)+(Double.parseDouble(boxes)*boxRate);

        return total;
    }


    //Eric's logic part


}