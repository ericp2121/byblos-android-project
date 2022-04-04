package my.firstapp.byblos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class ratings extends AppCompatActivity {

    Button submit;
    //not implemented in application

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

        final RatingBar ratingsBar = (RatingBar) findViewById(R.id.ratingBar);
        TextView reply = (TextView) findViewById(R.id.textCheck);

        submit = findViewById(R.id.btnSubmit);
        EditText comments = (EditText) findViewById(R.id.addFeedback);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalStars = ratingsBar.getNumStars();
                String comment = comments.getText().toString();
                reply.setText("Thank you for your feedback!");

            }
        });


    }
}