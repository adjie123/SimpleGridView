package com.gridview.app.simplegridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.etsy.android.grid.StaggeredGridView;

public class MainActivity extends AppCompatActivity {

    private String[] images = new String[]{
            "http://cdn0-a.production.liputan6.static6.com/medias/1024731/big/046072400_1445225647-resty.jpg",
            "https://pbs.twimg.com/media/CQ9JKfHUAAAYVg-.jpg",
            "http://2.bp.blogspot.com/-Mug53XtYcdE/UctDATMRkfI/AAAAAAAAAnc/YLsiHKuA_zE/s1600/Ladies+Viking+(10).jpg",
            "http://4.bp.blogspot.com/-vOKyrSiiYpY/VgbyVXNLbYI/AAAAAAAAEMc/nU4IdlesaPU/s1600/Ledies%2BViking%2BPersib%2B%252827%2529.jpg",
            "http://2.bp.blogspot.com/-9V_vI1zR3Os/VhpoU0e-SCI/AAAAAAAAEaw/sit4EMbYDlU/s320/Bobotoh%2BPersib%2Bladies%2Bviking%2B%252830%2529.jpg",
            "http://scontent.cdninstagram.com/t51.2885-15/s480x480/e15/11326438_925746197463430_295779986_n.jpg?ig_cache_key=MTAwMzAxMzc4MTQwNjMzMzA2NQ%3D%3D.2",
            "https://scontent.cdninstagram.com/hphotos-xaf1/t51.2885-15/e15/11379006_1600621076882930_961611658_n.jpg",
            "https://kanknkunk.files.wordpress.com/2015/10/b399d-bobotoh2bcantik2b2528122529.jpg",
            "http://media.galamedianews.com/original/160714161608-bobotoh-cantik-ini-janji-cium-seluruh-pemain-jika-persib-taklukan-persija.jpg"
    };
    private GridView gvItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Persib Girls");
        gvItem = (GridView)findViewById(R.id.gv_item);
        ItemGridAdapter itemGridAdapter = new ItemGridAdapter(MainActivity.this, images);
        gvItem.setAdapter(itemGridAdapter);

        gvItem.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id){
                DetailImageActivity.toDetailImageActivity(MainActivity.this, images[position]);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_staggered){
            StaggeredGridActivity.toStaggeredGridActivity(MainActivity.this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
