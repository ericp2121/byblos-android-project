package my.firstapp.byblos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Admin_services_menu extends AppCompatActivity {

    ArrayList<String> services = new ArrayList<String>();
    ArrayList<String> outputList = new ArrayList<String>();

    Button add, remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_services_menu);
        services.add("Car rentals");
        services.add("Moving assistance");
        services.add("Truck rentals");

        Spinner serviceList = findViewById(R.id.addOptions);

        TextView output = (TextView) findViewById(R.id.textOutput);
        TextView errors = (TextView) findViewById(R.id.textError);

        add = findViewById(R.id.btnAdd);
        remove = findViewById(R.id.btnRemove);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, services);
        serviceList.setAdapter(adapter);

        if (outputList.size() == 0){
            remove.setEnabled(false);
        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = serviceList.getSelectedItem().toString();
                if (!outputList.contains(text)) {
                        errors.setText("");
                        output.setText("");
                        outputList.add(text);

                        if (services.size() != 0) {
                            remove.setEnabled(true);
                        } else
                            remove.setEnabled(false);

                        for (int j = 0; j < outputList.size(); j++) {
                            output.append(outputList.get(j) + "\n");
                    }
                }
                else
                    errors.setText("Cannot add service! Already in the list.");

            }
        });


        remove.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String text = serviceList.getSelectedItem().toString();
                if (outputList.contains(text)) {
                    errors.setText("");
                    output.setText("");
                    outputList.remove(text);

                    if (services.size() != 0) {
                        remove.setEnabled(true);
                    } else
                        remove.setEnabled(false);

                    for (int j = 0; j < outputList.size(); j++) {
                        output.append(outputList.get(j) + "\n");
                    }
                }
                else
                    errors.setText("Cannot remove! List empty/Item not in list.");

            }
        });

    }







}