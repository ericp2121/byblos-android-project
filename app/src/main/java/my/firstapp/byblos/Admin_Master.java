package my.firstapp.byblos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Admin_Master extends AppCompatActivity implements View.OnClickListener {
    Button switchCarRent,switchTruckRent,switchMovingAssist;
//    Button switchAccDelete,switchAccEdit;
    Button switchAccCreate, switchEmpCreate, switchAdminService;
    Button switchMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_master);

        switchCarRent = findViewById(R.id.carRentalBtn);
        switchTruckRent = findViewById(R.id.truckRentalBtn);
        switchMovingAssist = findViewById(R.id.movingBtn);
//        switchAccDelete = findViewById(R.id.accDeleteBtn);
//        switchAccEdit = findViewById(R.id.accEditBtn);
        switchAccCreate = findViewById(R.id.accCreateBtn);
        switchAdminService = findViewById(R.id.adminSerMenu);
        switchEmpCreate = findViewById(R.id.empCreatBtn);

        switchMainMenu = findViewById(R.id.backMenuBtn);

        switchCarRent.setOnClickListener(this);
        switchTruckRent.setOnClickListener(this);
        switchMovingAssist.setOnClickListener(this);
//        switchAccDelete.setOnClickListener(this);
//        switchAccEdit.setOnClickListener(this);
        switchAccCreate.setOnClickListener(this);
        switchEmpCreate.setOnClickListener(this);
        switchAdminService.setOnClickListener(this);
        switchMainMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.carRentalBtn:
                Intent carRentIntent = new Intent(this, Admin_CarRental.class);
                startActivity(carRentIntent);
                break;
            case R.id.truckRentalBtn:
                Intent truckRentIntent = new Intent(this, Admin_TruckRental.class);
                startActivity(truckRentIntent);
                break;
            case R.id.movingBtn:
                Intent moveAssistIntent = new Intent(this, Admin_MovingAssistance.class);
                startActivity(moveAssistIntent);
                break;

//            case R.id.accDeleteBtn:
//                Intent accDeleteIntent = new Intent(this, Admin_AccountDelete.class);
//                startActivity(accDeleteIntent);
//                break;
//            case R.id.accEditBtn:
//                Intent accEditIntent = new Intent(this, Admin_AccountEdit.class);
//                startActivity(accEditIntent);
//                break;
            case R.id.accCreateBtn:
                Intent accCreateIntent = new Intent(this, Admin_createAccount.class);
                startActivity(accCreateIntent);
                break;
            case R.id.empCreatBtn:
                Intent employeeCreateActivity = new Intent(this, activity_admin_employee_create.class);
                startActivity(employeeCreateActivity);
                break;
            case R.id.backMenuBtn:
                Intent backMenu = new Intent(this, MainActivity.class);
                startActivity(backMenu);
                break;
            case R.id.adminSerMenu:
                Intent adminSerMenuActivity = new Intent(this, Admin_services_menu.class);
                startActivity(adminSerMenuActivity);
                break;

        }

    }
}