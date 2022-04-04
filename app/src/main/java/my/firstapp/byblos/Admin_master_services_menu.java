package my.firstapp.byblos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Admin_master_services_menu extends AppCompatActivity {

    ArrayList<String> services = new ArrayList<String>();
    Button add, remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_master_services_menu);
        services.add("Car rentals");
        services.add("Moving assistance");
        services.add("Truck rentals");

        Spinner serviceList = findViewById(R.id.deleteOptions);

        TextView errors = (TextView) findViewById(R.id.textError);

        add = findViewById(R.id.btnAdd);
        remove = findViewById(R.id.btnRemove);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, services);
        serviceList.setAdapter(adapter);

        if (services.size() == 0){
            remove.setEnabled(false);
        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText add = (EditText) findViewById(R.id.addService);
                String newService = add.getText().toString();

                if (!services.contains(newService) && newService.length() > 0) {
                    errors.setText("");
                    services.add(newService);

                    if (services.size() != 0) {
                        remove.setEnabled(true);
                    } else
                        remove.setEnabled(false);

                }
                else
                    errors.setText("Cannot add service! Invalid entry.");

            }
        });


        remove.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String text = serviceList.getSelectedItem().toString();

                if (services.contains(text) && text.length() > 0) {
                    errors.setText("");
                    services.remove(text);

                    if (services.size() != 0) {
                        remove.setEnabled(true);
                    } else
                        remove.setEnabled(false);
                }
                else
                    errors.setText("Cannot remove! List empty/Item not in list.");

            }
        });

    }
}