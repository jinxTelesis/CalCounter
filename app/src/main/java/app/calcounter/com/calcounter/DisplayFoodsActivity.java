package app.calcounter.com.calcounter;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import data.CustomListviewAdapter;
import data.DatabaseHandler;
import model.Food;

public class DisplayFoodsActivity extends AppCompatActivity {

    private DatabaseHandler dba;
    private ArrayList<Food> dbFoods = new ArrayList<>();
    private CustomListviewAdapter foodAdapter;
    private ListView listView;
    private Food myFood;
    private TextView totalCals, totalFoods;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_foods);

        listView = (ListView) findViewById(R.id.list);
        totalCals = (TextView) findViewById(R.id.totalAmountTextView);
        totalFoods = (TextView) findViewById(R.id.totalAmountTextViewFood);

        refreshData();


    }

    private void refreshData()
    {
        dbFoods.clear();

        dba = new DatabaseHandler(getApplicationContext());

        ArrayList<Food> foodFromDB = dba.getFood();

        int calsValue = dba.totalCalories();
        int totalItems = dba.getTotalItems();
        

    }

}
