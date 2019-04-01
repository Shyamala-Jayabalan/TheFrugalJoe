package edu.usf.thefrugaljoe;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class ListViewActivity extends AppCompatActivity {

    GridView grdvwSearchResults;
    String[] items;
    String[] price;
    String[] description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Resources res = getResources();
        grdvwSearchResults = (GridView) findViewById(R.id.grdvwSearchResults);
        items = res.getStringArray(R.array.items);
        price = res.getStringArray(R.array.price);
        description = res.getStringArray(R.array.description);


        //grdvwSearchResults.setAdapter(new ArrayAdapter<String>(this,R.layout.my_search_results, items));

        ItemAdapter itemAdapter = new ItemAdapter(this, items, price, description);
        grdvwSearchResults.setAdapter(itemAdapter);

        grdvwSearchResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("edu.usf.helloworld",position);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.academy.com/shop/pdp/nike-mens-initiator-running-shoes"));
                startActivity(browserIntent);

                //startActivity(showDetailActivity);

            }
        });

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        }
 //       );
    }

}
