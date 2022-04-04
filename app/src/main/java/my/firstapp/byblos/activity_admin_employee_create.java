package my.firstapp.byblos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_admin_employee_create extends AppCompatActivity {

    public boolean isInfoEntered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_employee_create);

        Button createButton = (Button) findViewById(R.id.btnUpdateInfo);

        TextView output = (TextView) findViewById(R.id.textReply);

        createButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText addressEdit = (EditText) findViewById(R.id.addressEnter);
                EditText phoneEdit = (EditText) findViewById(R.id.editTextPhone);

                String address = addressEdit.getText().toString();
                String phone = phoneEdit.getText().toString();



                boolean nullCheckAddress = emptyCheck(address);
                boolean addressCheck = addressCheck(address);
                boolean nullCheckPhone = emptyCheck(phone);
                boolean phoneCheck = phoneCheck(phone);

                if (nullCheckAddress && nullCheckPhone && phoneCheck && addressCheck){
                    output.setText("Valid phone number and address entered");
                }
                else if (nullCheckAddress && addressCheck) {
                    output.setText("Valid address. Please valid phone number");
                }
                else if (nullCheckPhone && phoneCheck) {
                    output.setText("Valid phone number. Please enter valid address");
                }
                else {
                    output.setText("Invalid phone number and address entered");
                }

                Employee employee = new Employee();

                employee.phoneNumber = phone;
                CurrentEmployee.currentPhoneNumber = phone;
                CurrentEmployee.currentAddress = address;

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference mdatabase = database.getInstance().getReference();
                mdatabase.child("employees").child(address).setValue(employee);
                isInfoEntered = true;

            }
        });

        Button hoursButton = (Button) findViewById(R.id.btnHours);

        hoursButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (!isInfoEntered) {
                    output.setText("Please enter employee information before proceeding.");
                }

                else {
                    Intent intent = new Intent(activity_admin_employee_create.this, Calendar.class);
                    startActivity(intent);
                }

            }
        });

    }


    //checking if email is valid

    public boolean emptyCheck(String word) {
        return word.length()>0;
    }

    /*
    public boolean emailCheck(String email) {

        if (email.contains(".com") && email.contains("@")) {
            if (email.charAt(0) != '@') {
                return true;
            }
        }
        return false;
    }
    */
    public boolean phoneCheck(String phone) {
        char[] phoneNumbers = phone.toCharArray();
        boolean checker = true;
        int count =0;

        //check if phone number is valid with dashes (10 characters) without dashes (8 characters)
        if (phone.length() == 10) {
            for (int i = 0; i < phoneNumbers.length; i++) {
                if (Character.isDigit(phoneNumbers[i])) {
                    count++;
                }
            }
        }

        if (count != 10) {
            checker = false;
        }
        return checker;
    }

    public boolean addressCheck(String address) {
        boolean checker = true;
        char[] addressList = address.toCharArray();
        if (address.length()!=6) {
            return false;
        }
        for (int i=0; i<addressList.length; i++) {
            if (i%2==0 && !Character.isLetter(addressList[i])) {
                checker = false;
            }
            if (i%2==1 && !Character.isDigit(addressList[i])) {
                checker = false;
            }
        }
        return checker;
    }





    //confirmation if password is entered correctly both times when creating new account

}