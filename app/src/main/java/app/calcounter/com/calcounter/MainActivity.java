package app.calcounter.com.calcounter;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.DatabaseHandler;
import model.Food;

public class MainActivity extends AppCompatActivity {

    private EditText foodName, foodCals;
    private Button submitButton;
    private DatabaseHandler dba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.name);

        dba = new DatabaseHandler(MainActivity.this);

        foodName = (EditText) findViewById(R.id.foodEditText);
        foodCals = (EditText) findViewById(R.id.caloriesEdit);
        submitButton = (Button) findViewById(R.id.submitBut);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                saveDataToDB();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void saveDataToDB() {

        Food food = new Food();
        String name = foodName.getText().toString().trim();
        String calsString = foodCals.getText().toString().trim();

        int cals = Integer.parseInt(calsString);

        if(name.equals("") || calsString.equals(""))
        {
            Toast.makeText(getApplicationContext(), "No empty fields allowed", Toast.LENGTH_LONG).show();

        }else
        {
            food.setFoodName(name);
            food.setCalories(cals);
            dba.addFood(food);
            dba.close();
        }

        // clear form
        foodName.setText("");
        foodCals.setText("");

        startActivity(new Intent((MainActivity.this), DisplayFoodsActivity.class));
    }
}
