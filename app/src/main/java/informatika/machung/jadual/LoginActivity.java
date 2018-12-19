package informatika.machung.jadual;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import informatika.machung.jadual.dosenActivity.MainActivity_Dosen;
import informatika.machung.jadual.mahasiswa.MainActivity_Mahasiswa;
import informatika.machung.jadual.model.Person;

public class LoginActivity extends AppCompatActivity {

    EditText editUsername,editPassword;
    private DatabaseReference mDatabase;
    String username="";
    String password="";
    String auth="";
    Person person;

    SharedPreferences sharedPref = getSharedPreferences(
            "session", Context.MODE_PRIVATE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername = findViewById(R.id.edt_username);
        editPassword = findViewById(R.id.edt_password);

    }

    public void click_login(View view) {

//        CHECK REQUIRED
        if (editUsername.getText().toString().trim().isEmpty()){
            editUsername.setError("Isi NIM/NIP anda");
        }
        else if (editPassword.getText().toString().trim().isEmpty()){
            editPassword.setError("Isi Kata Kunci anda");
        }
        else {
            checkUn(editUsername.getText().toString(),editPassword.getText().toString());
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("username", editUsername.getText().toString());
            editor.commit();
        }

//            String checkUser = editUsername.getText().toString();
//            if (checkUser.equals("mahasiswa") ){
//                Intent intent = new Intent(LoginActivity.this, MainActivity_Mahasiswa.class);
//                startActivity(intent);
//            }
//            else if (checkUser.equals("dosen")  ){
//                Intent intent = new Intent(LoginActivity.this, MainActivity_Dosen.class);
//                startActivity(intent);
//            }
//            else{
//                Toast.makeText(this,"Maaf anda belum terdaftar",Toast.LENGTH_SHORT).show();
//            }


        }

    public void checkUn(String un, String pass){
        username = un;
        password = pass;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("id").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(username)) {
                    mDatabase.child("id").child(username).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Log.d("test",password);
                            Log.d("test",dataSnapshot.child("psw").getValue(String.class));
                            if(dataSnapshot.child("psw").getValue(String.class).equals(password)) {
                                auth = dataSnapshot.child("auth").getValue(String.class);
                                Log.d("test",auth);
                                if(auth.equals("mhs")){
                                    Intent intent = new Intent(LoginActivity.this, MainActivity_Mahasiswa.class);
                                    startActivity(intent);
                                } else {
                                    Intent intent = new Intent(LoginActivity.this, MainActivity_Dosen.class);
                                    startActivity(intent);
                                }
                            } else{
                                Toast.makeText(getApplicationContext(),"Password Anda Salah",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                } else Toast.makeText(getApplicationContext(),"Username Salah",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}

