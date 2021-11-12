package com.example.iniciosesionfirebase;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
public class PerfilUsuario extends AppCompatActivity {
    TextView txt_id, txt_name, txt_email,txt_num;
    ImageView imv_photo;
    Button btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        Intent intent = getIntent();
        HashMap<String, String> info_user = (HashMap<String, String>)intent.getSerializableExtra("info_user");
        txt_id = findViewById(R.id.txt_userId);
        txt_name = findViewById(R.id.txt_nombre);
        txt_email = findViewById(R.id.txt_correo);
        imv_photo = findViewById(R.id.imv_foto);
        txt_num= findViewById(R.id.txt_num);
        txt_id.setText(info_user.get("user_id"));
        txt_name.setText(info_user.get("user_name"));
        txt_email.setText(info_user.get("user_email"));
        String photo = info_user.get("user_photo");
        txt_num.setText(info_user.get("user_num"));
        Picasso.with(getApplicationContext()).load(photo).into(imv_photo);
    }
    public void cerrarSesion(View view){
        FirebaseAuth.getInstance().signOut();
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("msg", "cerrarSesion");
        startActivity(intent);
    }
}