package com.gridview.app.simplegridview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.etsy.android.grid.StaggeredGridView;


public class StaggeredGridActivity extends AppCompatActivity {

    private StaggeredGridView staggeredGridView;
    private String[] items = new String[]{
            "https://s-media-cache-ak0.pinimg.com/originals/3a/ce/0d/3ace0d8f7fd7e3f8a519efd517e06ed2.jpg",
            "https://bodilog.files.wordpress.com/2012/08/persib-bandung-logo-2012.jpg",
            "http://www.persib.co.id/getmedia/6a940917-d9b9-4020-9fa8-ed9542df27aa/tim_persib_pusamania_jat.jpg.aspx?width=650&height=325&ext=.jpg",
            "http://cdn.klimg.com/bola.net/library/upload/20/2016/03/persib-bandung_7217efd.jpg",
            "http://www.pikiran-rakyat.com/sites/files/public/styles/medium/public/image/2016/07/atep.jpg?itok=VggXMWcL",
            "http://www.maungbandung.com/wp-content/uploads/2016/07/foto-persib-bandung-vs-persija.jpg",
            "http://bandung.pojoksatu.id/wp-content/uploads/2015/10/bobotoh-persib-bandung2.jpg",
            "http://images.performgroup.com/di/library/Goal_Indonesia/27/36/vladimir-vujovic-persib-bandung_hc7p1zb7gm8315ch5usampcmx.jpg?t=-1105127236&w=620&h=430",
            "http://cdn2.tstatic.net/tribunnews/foto/bank/images/bus-persib-n_20151018_151648.jpg",
            "http://www.maungbandung.com/wp-content/uploads/2015/10/bobotoh-persib.jpg",
            "https://4.bp.blogspot.com/-rMFqsX-omLk/VGGGCUsZ3wI/AAAAAAAAGf0/OYQuiy9ZO0k/s1600/Djadjang%2BNurdjaman%2BPersib.png"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_view);

        getSupportActionBar().setTitle("PERSIB ALL");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        staggeredGridView = (StaggeredGridView)findViewById(R.id.gv_staggered);
        ItemGridAdapter itemGridAdapter = new ItemGridAdapter(StaggeredGridActivity.this, items);
        staggeredGridView.setAdapter(itemGridAdapter);
        staggeredGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DetailImageActivity.toDetailImageActivity(StaggeredGridActivity.this, items[position]);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void toStaggeredGridActivity(Context context){
        context.startActivity(new Intent(context, StaggeredGridActivity.class));
    }

}
