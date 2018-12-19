package informatika.machung.jadual.mahasiswaActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import informatika.machung.jadual.R;
import informatika.machung.jadual.Data.ListDosen.Dosen;
import informatika.machung.jadual.util.ItemClickSupport;
import informatika.machung.jadual.Data.ListDosen.ListDosenAdapter;
import informatika.machung.jadual.Data.ListDosen.DataDosen;

public class MainActivity_Mahasiswa extends AppCompatActivity {

    private RecyclerView rvDosen;
    private ArrayList<Dosen> arrDosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mahasiswa);

        initializeDosenList();
    }

    //initialize the list
    private void initializeDosenList(){
        rvDosen = (RecyclerView)findViewById(R.id.rv_list_dosen);
        rvDosen.setHasFixedSize(true);

        arrDosen = new ArrayList<>();
        arrDosen.addAll(DataDosen.getListData());

        showRecyclerList();
    }

    //set Recyclerview data
    private void showRecyclerList(){
        rvDosen.setLayoutManager(new LinearLayoutManager(this));
        ListDosenAdapter listDosenAdapter = new ListDosenAdapter(this);
        listDosenAdapter.setListDosen(arrDosen);
        rvDosen.setAdapter(listDosenAdapter);

        ItemClickSupport.addTo(rvDosen).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                clickSelectedDosen(arrDosen.get(position));
            }
        });
    }

    // Click per item
    private void clickSelectedDosen(Dosen dosen){
        Intent openDesc = new Intent(MainActivity_Mahasiswa.this , JadwalDosenActivity_Mahasiswa.class);
        openDesc.putExtra(JadwalDosenActivity_Mahasiswa.NAME, dosen.getName());
        startActivity(openDesc);
    }
}
