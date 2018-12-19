package informatika.machung.jadual.dosenActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import informatika.machung.jadual.R;

public class InputJadwalActivity_Dosen extends AppCompatActivity {

    EditText inputDate, inputStartTime, inputEndTime, inputEventName, inputMessage;

    public static String DATE = "DATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_jadwal__dosen);

        initializeInput();
    }

    private void initializeInput(){
        String date_chosen = getIntent().getStringExtra(DATE);

        inputDate = findViewById(R.id.edt_date_input);
        inputStartTime = findViewById(R.id.edt_start_time);
        inputEndTime = findViewById(R.id.edt_end_time);
        inputEventName = findViewById(R.id.edt_event_name);
        inputMessage = findViewById(R.id.edt_event_msg);

        inputDate.setEnabled(false);
        inputDate.setText(date_chosen);
    }
}
