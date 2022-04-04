package my.firstapp.byblos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Calendar extends AppCompatActivity {

    private static final String TAG = "Calendar";

    private TextView theDate;
    private TextView theDate2;
    private TextView theTime;
    private TextView theTime2;
    private Button btnGoCalendar;
    private Button btnGoTime;
    private Button btnSaveContent;

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        theDate = (TextView) findViewById(R.id.date);
        theDate2 = (TextView) findViewById(R.id.date2);
        theTime = (TextView) findViewById(R.id.time);
        theTime2 = (TextView) findViewById(R.id.time2);
        btnGoCalendar = (Button) findViewById(R.id.btnGoCalendar);
        btnGoTime = (Button) findViewById(R.id.btnGoTime);
        btnSaveContent = (Button) findViewById(R.id.btnSaveContent);

        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");
        //theDate.setText(date);
        //CurrentEmployee.currentWorkingDaysStart = date;
        //theDate.setText(CurrentEmployee.currentWorkingDaysStart);

        Intent incomingIntent4 = getIntent();
        String date2 = incomingIntent4.getStringExtra("date2");
        //theDate2.setText(date2);
        //CurrentEmployee.currentWorkingDaysEnd = date2;
        //theDate2.setText(CurrentEmployee.currentWorkingDaysEnd);

        Intent incomingIntent2 = getIntent();
        String time = incomingIntent2.getStringExtra("time");
        //theTime.setText(time);
        //CurrentEmployee.currentWorkingHoursStart = time;
        //theTime.setText(CurrentEmployee.currentWorkingHoursStart);

        Intent incomingIntent3 = getIntent();
        String time2 = incomingIntent2.getStringExtra("time2");
        //theTime2.setText(time2);
        //CurrentEmployee.currentWorkingHoursEnd = time2;
        //theTime2.setText(CurrentEmployee.currentWorkingHoursEnd);

        btnGoCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Calendar.this, CalendarActivity.class);
                startActivity(intent);

            }
        });

        btnGoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calendar.this, Time.class);
                startActivity(intent);
            }
        });

        btnSaveContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee = new Employee();
                employee.phoneNumber = CurrentEmployee.currentPhoneNumber;
                employee.workingDaysStart = CurrentEmployee.currentWorkingDaysStart;
                employee.workingDaysEnd = CurrentEmployee.currentWorkingDaysEnd;
                employee.workingHoursStart = CurrentEmployee.currentWorkingHoursStart;
                employee.workingHoursEnd = CurrentEmployee.currentWorkingHoursEnd;

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference mdatabase = database.getInstance().getReference();
                mdatabase.child("employees").child(CurrentEmployee.currentAddress).setValue(employee);

                Intent intent = new Intent(Calendar.this, Admin_Master.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        theDate.setText(CurrentEmployee.currentWorkingDaysStart);
        theDate2.setText(CurrentEmployee.currentWorkingDaysEnd);
        theTime.setText(CurrentEmployee.currentWorkingHoursStart);
        theTime2.setText(CurrentEmployee.currentWorkingHoursEnd);

    }
}