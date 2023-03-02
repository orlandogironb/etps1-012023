package sv.edu.utec.foodapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import sv.edu.utec.foodapp.R;

public class Principal extends AppCompatActivity {
TextView edtUserMsj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Bundle bundle=getIntent().getExtras();
        edtUserMsj=findViewById(R.id.tvUsuario);
        String inform="Hola ,"+bundle.getString("usuario");
        edtUserMsj.setText(inform);
    }
}