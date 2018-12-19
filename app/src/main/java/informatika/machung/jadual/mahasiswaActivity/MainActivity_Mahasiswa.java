package informatika.machung.jadual.mahasiswaActivity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import informatika.machung.jadual.R;
import informatika.machung.jadual.Data.ListDosen.DosenModel;
import informatika.machung.jadual.util.ItemClickSupport;
import informatika.machung.jadual.Data.ListDosen.ListDosenAdapter;
import informatika.machung.jadual.Data.ListDosen.DataDosen;

public class MainActivity_Mahasiswa extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    private RecyclerView rvDosen;
    private ArrayList<DosenModel> arrDosenModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mahasiswa);

        mDrawerLayout = findViewById(R.id.drawer_layout_mahasiswa);
        setupActionbar();
        setupNavDrawer();
        initializeDosenList();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //--------------------------LIST----------------------------------

    //initialize the list
    private void initializeDosenList(){
        rvDosen = (RecyclerView)findViewById(R.id.rv_list_dosen);
        rvDosen.setHasFixedSize(true);

        arrDosenModel = new ArrayList<>();
        arrDosenModel.addAll(DataDosen.getListData());

        showRecyclerList();
    }

    //set Recyclerview data
    private void showRecyclerList(){
        rvDosen.setLayoutManager(new LinearLayoutManager(this));
        ListDosenAdapter listDosenAdapter = new ListDosenAdapter(this);
        listDosenAdapter.setListDosenModel(arrDosenModel);
        rvDosen.setAdapter(listDosenAdapter);

        ItemClickSupport.addTo(rvDosen).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                clickSelectedDosen(arrDosenModel.get(position));
            }
        });
    }

    // Click per item
    private void clickSelectedDosen(DosenModel dosenModel){
        Intent openDesc = new Intent(MainActivity_Mahasiswa.this , JadwalDosenActivity_Mahasiswa.class);
        openDesc.putExtra(JadwalDosenActivity_Mahasiswa.NAME, dosenModel.getName());
        startActivity(openDesc);
    }

    //--------------------------END.LIST----------------------------------

    private void setupNavDrawer(){
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });
    }

    private void setupActionbar() {
        // Set button for open drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
    }
}
