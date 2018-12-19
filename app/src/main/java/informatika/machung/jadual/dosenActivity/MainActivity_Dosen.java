package informatika.machung.jadual.dosenActivity;

import android.content.Context;
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
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import informatika.machung.jadual.Data.ListEvent.DataEvent;
import informatika.machung.jadual.Data.ListEvent.Event;
import informatika.machung.jadual.Data.ListEvent.ListEventAdapter;
import informatika.machung.jadual.R;
import informatika.machung.jadual.mahasiswaActivity.JadwalDosenActivity_Mahasiswa;
import informatika.machung.jadual.mahasiswaActivity.MainActivity_Mahasiswa;

public class MainActivity_Dosen extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());

    private RecyclerView rvEvent;
    private ArrayList<Event> arrEvent;

    public static String PASS_DATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dosen);
        initElement();

        SetuptNavDrawer();
        SetupActionbar();

        setupCalendar();
        initializeEventList();
    }

    private void setupCalendar(){

        compactCalendar = findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(false);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();
                PASS_DATE = dateClicked.toString();
                Toast.makeText(context, dateClicked.toString() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                getSupportActionBar().setTitle(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });
    }

    //--------------------------LIST----------------------------------

    //initialize the list
    private void initializeEventList(){
        rvEvent = findViewById(R.id.rv_list_event);
        rvEvent.setHasFixedSize(true);

        arrEvent = new ArrayList<>();
        arrEvent.addAll(DataEvent.getListData());

        showRecyclerList();
    }

    //set Recyclerview data
    private void showRecyclerList(){
        rvEvent.setLayoutManager(new LinearLayoutManager(this));
        ListEventAdapter listEventAdapter = new ListEventAdapter(this);
        listEventAdapter.setListEvent(arrEvent);
        rvEvent.setAdapter(listEventAdapter);
    }

    //--------------------------END.LIST----------------------------------


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initElement(){
        mDrawerLayout = findViewById(R.id.drawer_layout);

        //Default time is now
        Date c = Calendar.getInstance().getTime();
        c.setHours(0);
        c.setMinutes(0);
        c.setSeconds(0);
        PASS_DATE  = c.toString();

    }

    private void SetuptNavDrawer(){
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

    private void SetupActionbar() {
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
        String formattedDate = df.format(c);

        // Set bulan tahun as lable name
        getSupportActionBar().setTitle(formattedDate);

        // Set button for open drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
    }

    //Float Action Button
    public void click_input(View view) {
        Intent openDesc = new Intent(MainActivity_Dosen.this , InputJadwalActivity_Dosen.class);
        openDesc.putExtra(InputJadwalActivity_Dosen.DATE, PASS_DATE);
        startActivity(openDesc);
    }
}
