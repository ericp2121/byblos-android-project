package my.firstapp.byblos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Employee_login extends AppCompatActivity implements View.OnClickListener{
    Button hours, services, signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

        services = findViewById(R.id.empServices);
        hours = findViewById(R.id.empHours);
        signOut = findViewById(R.id.signOutBtn);

        services.setOnClickListener(this);
        hours.setOnClickListener(this);
        signOut.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.empServices:
                Intent empServicesIntent = new Intent(this, Admin_services_menu.class);
                startActivity(empServicesIntent);
                break;
            case R.id.empHours:
                Intent empHoursIntent = new Intent(this, CalendarActivity.class);
                startActivity(empHoursIntent);
                break;

            case R.id.signOutBtn:
                Intent main = new Intent(Employee_login.this, MainActivity.class);
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                mAuth.signOut();
                finish();
                startActivity(main);
                break;

        }

    }
}