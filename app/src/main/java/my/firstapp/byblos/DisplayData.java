package my.firstapp.byblos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DisplayData extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        TextView name = (TextView) findViewById(R.id.nameDisplay);
        TextView carType = (TextView) findViewById(R.id.serviceTypeDisplay);
        TextView dates = (TextView) findViewById(R.id.costDisplay);
        TextView cost = (TextView) findViewById(R.id.estimatedCostDisplay);

        Button approve = (Button) findViewById(R.id.approveRequestBtn);
        Button reject = (Button) findViewById(R.id.rejectRequestBtn);

        if (ServiceSelected.selected.equals("CarRental")) {
            name.setText(CarRental.customerFirstName + " " + CarRental.customerLastName);
            carType.setText(CarRental.carType);
            dates.setText(CarRental.pickUpDate + " to " + CarRental.dropOffDate);
            cost.setText(CarRental.estimatedPrice);

            approve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CarRental.setIsApproved("T");
                }
            });

            reject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CarRental.setIsApproved("R");
                }
            });

            CarRental update = new CarRental(CarRental.customerFirstName, CarRental.customerLastName,
                    CarRental.customerBirthDate, CarRental.customerLicenseType, CarRental.carType,
                    CarRental.pickUpDate, CarRental.dropOffDate, CarRental.pickUpTime, CarRental.dropOffTime,
                    CarRental.estimatedPrice, CarRental.isApproved);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference mdatabase = database.getReference();
            DatabaseReference ref = mdatabase.child("CarRentalInfo").child(CarRental.customerFirstName + "_" + CarRental.customerLastName);
            ref.setValue(update);
        }

        else if (ServiceSelected.selected.equals("TruckRental")) {
            name.setText(TruckRental.customerFirstName + " " + TruckRental.customerLastName);
            carType.setText(TruckRental.areaDrivenIn);
            dates.setText(TruckRental.pickUpDate + " to " + TruckRental.dropOffDate);
            cost.setText(TruckRental.estimatedPrice);

            approve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TruckRental.setIsApproved("T");
                }
            });

            reject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TruckRental.setIsApproved("R");
                }
            });

            TruckRental update = new TruckRental(TruckRental.customerFirstName, TruckRental.customerLastName,
                    TruckRental.customerBirthDate, TruckRental.driverLicenseType, TruckRental.pickUpDate,
                    TruckRental.dropOffDate, TruckRental.pickUpTime, TruckRental.dropOffTime,
                    TruckRental.estimatedPrice, TruckRental.rangeDriven, TruckRental.areaDrivenIn,
                    TruckRental.isApproved);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference mdatabase = database.getReference();
            DatabaseReference ref = mdatabase.child("TruckRentalInfo").child(TruckRental.customerFirstName +
                    "_" + TruckRental.customerLastName);
            ref.setValue(update);
        }

        else if (ServiceSelected.selected.equals("MovingAssistance")) {
            name.setText(MovingAssistance.customerFirstName + " " + MovingAssistance.customerLastName);
            carType.setText(MovingAssistance.customerEmailId);
            dates.setText(MovingAssistance.startingAddress + " to " + MovingAssistance.endingAddress);
            cost.setText(MovingAssistance.estimatedPrice);

            approve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MovingAssistance.setIsApproved("T");
                }
            });

            reject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MovingAssistance.setIsApproved("R");
                }
            });

            MovingAssistance update = new MovingAssistance(MovingAssistance.customerFirstName, MovingAssistance.customerLastName,
                    MovingAssistance.customerBirthDate, MovingAssistance.customerAddress, MovingAssistance.customerEmailId,
                    MovingAssistance.startingAddress, MovingAssistance.endingAddress, MovingAssistance.numberOfMoversRequested,
                    MovingAssistance.estimatedPrice, MovingAssistance.numberOfBoxes, MovingAssistance.isApproved);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference mdatabase = database.getReference();
            DatabaseReference ref = mdatabase.child("MovingAssistanceInfo").child(MovingAssistance.customerFirstName +
                    "_" + MovingAssistance.customerLastName);
            ref.setValue(update);
        }


        //finish();

    }
}