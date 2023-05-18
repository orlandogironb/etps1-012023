package sv.edu.utec.crud_entyy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.utec.crud_entyy.bd.Proveedor;

public class NuevoProvActivity extends AppCompatActivity {
EditText edtNombre, edtTele,edtCorreo;
Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_prov);

        edtNombre=findViewById(R.id.edtNombProve);
        edtTele=findViewById(R.id.edtTelProve);
        edtCorreo=findViewById(R.id.edtMailProve);

        btnSave=findViewById(R.id.btnGuardar);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id=0;
                Proveedor tbProvedor = new Proveedor(getApplicationContext());
               id= tbProvedor.insertProve(edtNombre.getText().toString(),edtTele.getText().toString(),edtCorreo.getText().toString());
                if(id>0){
                    Toast.makeText(getApplicationContext(),"Registro Almacenado",Toast.LENGTH_LONG).show();
                    limpiar();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Registro no Almacenado",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void limpiar(){
        edtNombre.setText("");
        edtTele.setText("");
        edtCorreo.setText("");
    }
}