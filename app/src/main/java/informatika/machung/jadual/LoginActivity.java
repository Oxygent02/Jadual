package informatika.machung.jadual;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import informatika.machung.jadual.dosenActivity.MainActivity_Dosen;
import informatika.machung.jadual.mahasiswaActivity.MainActivity_Mahasiswa;

public class LoginActivity extends AppCompatActivity {

    EditText editUsername,editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername = findViewById(R.id.edt_username);
        editPassword = findViewById(R.id.edt_password);
    }

    public void click_login(View view) {

        //CHECK REQUIRED
        if (editUsername.getText().toString().trim().isEmpty()){
            editUsername.setError("Isi NIM/NIP anda");
        }
        else if (editPassword.getText().toString().trim().isEmpty()){
            editPassword.setError("Isi Kata Kunci anda");
        }
        else {
            String checkUser = editUsername.getText().toString();
            if (checkUser.equals("mahasiswa") ){
                Intent intent = new Intent(LoginActivity.this, MainActivity_Mahasiswa.class);
                startActivity(intent);
            }
            else if (checkUser.equals("dosen")  ){
                Intent intent = new Intent(LoginActivity.this, MainActivity_Dosen.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(this,"Maaf anda belum terdaftar",Toast.LENGTH_SHORT).show();
            }


        }
    }

}

