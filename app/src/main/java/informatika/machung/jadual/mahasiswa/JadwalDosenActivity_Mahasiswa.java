package informatika.machung.jadual.mahasiswa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import informatika.machung.jadual.R;

public class JadwalDosenActivity_Mahasiswa extends AppCompatActivity {

    public static String NAME = "NAME";

    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());

    ImageView image;
    TextView name;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_mahasiswa);

        setupEnvirontment();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                Intent intent = new Intent(JadwalDosenActivity_Mahasiswa.this, MainActivity_Mahasiswa.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setupActionBar(String name){
        // Set nama dosen as lable name
        getSupportActionBar().setTitle(name);
        // Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupEnvirontment(){
        String name_content = getIntent().getStringExtra(NAME);

        setupActionBar(name_content);
        setupCalendar();

    }

    private void setupCalendar(){

        compactCalendar = findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(false);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();
                Toast.makeText(context, dateClicked.toString() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                getSupportActionBar().setTitle(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });
    }
}
