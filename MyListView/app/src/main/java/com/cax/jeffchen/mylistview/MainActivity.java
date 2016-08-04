package com.cax.jeffchen.mylistview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvSpots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvSpots = (ListView) findViewById(R.id.lvSpots);
        final List<Spot> spotList = getSpotList();
        lvSpots.setAdapter(new SpotAdapter(this, spotList));
        //點選項後連結
        lvSpots.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Spot spot = spotList.get(index);
                Toast.makeText(MainActivity.this, spot.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class SpotAdapter extends BaseAdapter {
        Context context;
        List<Spot> spotlist;

        public SpotAdapter(Context context, List<Spot> spotList) {
            this.context = context;
            this.spotlist = spotList;
        }

        @Override
        public int getCount() {
            return spotlist.size();
        }

        @Override
        public View getView(int index, View itemView, ViewGroup viewGroup) {
            Spot spot = spotlist.get(index);
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            if(itemView == null){
                itemView = layoutInflater.inflate(R.layout.spot_item, viewGroup, false);
            }
            ImageView ivSpot = (ImageView) itemView.findViewById(R.id.ivSpot);
            ivSpot.setImageResource(spot.getImageId());

            TextView tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvName.setText(spot.getName());

            TextView tvAddress = (TextView) itemView.findViewById(R.id.tvAddress);
            tvAddress.setText(spot.getAddress());

            return itemView;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

    }

    private List<Spot> getSpotList() {
        List<Spot> spotList = new ArrayList<>();
        spotList.add(new Spot(R.drawable.memorial, "中正紀念堂", "台北市中正紀念堂", "02-23455678"));
        spotList.add(new Spot(R.drawable.taipei101, "台北101", "台北市台北101", "02-23455677"));
        spotList.add(new Spot(R.drawable.pagodas, "龍虎塔", "高雄市龍虎塔", "08-23455679"));
        return spotList;
    }

}
