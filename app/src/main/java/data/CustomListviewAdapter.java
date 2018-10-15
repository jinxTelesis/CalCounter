package data;

import android.app.Activity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


import model.Food;

public class CustomListviewAdapter extends ArrayAdapter<Food>{




    private int layoutResource;
    private Activity activity;
    private ArrayList<Food> foodList = new ArrayList<>();

    public CustomListviewAdapter(Activity act, int resource, ArrayList<Food> data) {
        super(act, resource, data);
        layoutResource = resource;
        activity = act;
        this.foodList = data;
        notifyDataSetChanged();


    }



    @Override
    public int getCount() {
        return foodList.size();
    }

    @Nullable
    @Override
    public Food getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public int getPosition(@Nullable Food item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ViewHolder holder = null;

        if (row == null || (row.getTag() == null)) {
            LayoutInflater inflater = LayoutInflater.from(activity);
            row = inflater.inflate(layoutResource, null);

            holder = new ViewHolder();
            holder.foodName = (TextView) row.findViewById(R.id.name);
            holder.foodDate = (TextView) row.findViewById(R.id.dataText);
            holder.foodCalories = (TextView) row.findViewById(R.id.calories);

            row.setTag(holder);
        } else
        {
            holder = (ViewHolder) row.getTag();
            holder.foodName.setText(holder.food.getFoodName());
            holder.foodDate.setText(holder.food.getRecordDate());
            holder.foodCalories.setText(String.valueOf(holder.food.getCalories()));

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }






        return super.getView(position, convertView, parent);

        // where inflator goes
    }



    public class ViewHolder{ // where we are
        Food food;
        TextView foodName;
        TextView foodCalories;
        TextView foodDate;
    }

}
