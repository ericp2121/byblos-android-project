package my.firstapp.byblos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CalendarActivity extends AppCompatActivity {

    private static final String TAG = "CalendarActivity";

    private CalendarView mCalendarView;
    private CalendarView mCalendarView2;
    private Button btnSelectDates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mCalendarView2 = (CalendarView) findViewById(R.id.calendarView2);
        btnSelectDates = (Button) findViewById(R.id.btnSelectDates);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int month, int day, int year) {
                String date = ((month+1) + "/" + day + "/" + year);
                Log.d(TAG,"mm/dd/yyy: " + date);

                //Intent intent = new Intent(CalendarActivity.this, Calendar.class);
                //intent.putExtra("date", date);
                CurrentEmployee.currentWorkingDaysStart = date;
                //finish();
                //startActivity(intent);
            }
        });

        mCalendarView2.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int month, int day, int year) {
                String date = ((month+1) + "/" + day + "/" + year);
                Log.d(TAG,"mm/dd/yyy: " + date);

                //Intent intent = new Intent(CalendarActivity.this, Calendar.class);
                //intent.putExtra("date2", date);
                CurrentEmployee.currentWorkingDaysEnd = date;
                //finish();
                //startActivity(intent);
            }
        });

        btnSelectDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });
    }
}
