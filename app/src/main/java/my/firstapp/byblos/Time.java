package my.firstapp.byblos;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Time extends AppCompatActivity {
    TimePicker picker;
    TimePicker picker2;
    //    Button btnGet;
//    Button btnGet2;
//    Button btnGet3;
    Button btnSaveTime;
    TextView tvw;
    TextView tvw2;
    TextView tvw3;
    private static final String TAG = "Time";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        tvw = (TextView) findViewById(R.id.textView1);
        tvw2 = (TextView) findViewById(R.id.textView2);
        tvw3 = (TextView) findViewById(R.id.textView3);
        picker = (TimePicker) findViewById(R.id.timePicker1);
        picker2 = (TimePicker) findViewById(R.id.timePicker2);
//        picker.setIs24HourView(true);
        //       btnGet=(Button)findViewById(R.id.button1);
//        btnGet2=(Button)findViewById(R.id.button2);
//        btnGet3=(Button)findViewById(R.id.button3);
        btnSaveTime = (Button) findViewById(R.id.btnSaveTime);

        picker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int min) {
                String am_pm;
                if (hour > 12) {
                    am_pm = "PM";
                    hour = hour - 12;
                } else {
                    am_pm = "AM";
                }

                String time;

                if (min < 9) {
                    time = (hour + ":0" + min + " " + am_pm);
                    ;
                } else {
                    time = (hour + ":" + min + " " + am_pm);
                    ;
                }

                Log.d(TAG, "hour/min: " + time);
                tvw2.setText(time);

                String finalTime = time;

                CurrentEmployee.currentWorkingHoursStart = time;

//                btnGet2.setOnClickListener(new View.OnClickListener() {
//                    public void onClick(View v) {
//                        CurrentEmployee.currentWorkingHoursStart = time;
//                        //Intent intent = new Intent(Time.this, Calendar.class);
//                        //intent.putExtra("time", finalTime);
//                        //startActivity(intent);
//                    }
//                });
            }
        });

        picker2.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int min) {
                String am_pm;
                if (hour > 12) {
                    am_pm = "PM";
                    hour = hour - 12;
                } else {
                    am_pm = "AM";
                }
                String time;

                if (min < 9) {
                    time = (hour + ":0" + min + " " + am_pm);
                    ;
                } else {
                    time = (hour + ":" + min + " " + am_pm);
                    ;
                }


                Log.d(TAG, "hour/min: " + time);
                tvw3.setText(time);

                String finalTime = time;

                CurrentEmployee.currentWorkingHoursEnd = time;


//                btnGet3.setOnClickListener(new View.OnClickListener() {
//                    public void onClick(View v) {
//                        CurrentEmployee.currentWorkingHoursEnd = time;
//                        //Intent intent = new Intent(Time.this, Calendar.class);
//                        //intent.putExtra("time2", finalTime);
//                        //startActivity(intent);
//                    }
//                });
            }
        });

        btnSaveTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });

    }
}

//        btnGet.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(Time.this, Calendar.class);
//                startActivity(intent);
//            }
//        });
//        btnGet.setOnClickListener(new View.OnClickListener() {
//            String str = "";
//            public void onClick(View v) {
//                int hour, minute;
//                String am_pm;
//                if (Build.VERSION.SDK_INT >= 23) {
//                    hour = picker.getHour();
//                    minute = picker.getMinute();
//                } else {
//                    hour = picker.getCurrentHour();
//                    minute = picker.getCurrentMinute();
//                }
//                if (hour > 12) {
//                    am_pm = "PM";
//                    hour = hour - 12;
//                } else {
//                    am_pm = "AM";
//                }
//                tvw.setText("Selected Date: " + hour + ":" + minute + " " + am_pm);
//
//                str = tvw.getText().toString();
//
//                Intent intent = new Intent(Time.this, Calendar.class);
//               // intent.putExtra("Time", str);
//                startActivity(intent);
//            }
//            public void Update () {
//                TextView textView = (TextView) ((Calendar)theTime).findViewById(R.id.time);
//                textView.setText(str);
//            }
//        });
//                Intent intent = new Intent(Time.this, Calendar.class);
//                intent.putExtra("time", time);
//                startActivity(intent);
//            }

//            @Override
//            public void onClick(View v) {
//
//            }
//        }OnTimeChangedListener picker {
//            @Override
//            public void onClick(View v) {
//                int hour, minute;
//                String am_pm;
//                if (Build.VERSION.SDK_INT >= 23 ){
//                    hour = picker.getHour();
//                    minute = picker.getMinute();
//                }
//                else{
//                    hour = picker.getCurrentHour();
//                    minute = picker.getCurrentMinute();
//                }
//                if(hour > 12) {
//                    am_pm = "PM";
//                    hour = hour - 12;
//                }
//                else
//                {
//                    am_pm="AM";
//                }
//                tvw.setText("Selected Date: "+ hour +":"+ minute+" "+am_pm);
//
//                String str = tvw.getText().toString();
//
//                Intent intent = new Intent(Time.this, Calendar.class);
//                intent.putExtra("Time", str);
//                startActivity(intent);
//            }

