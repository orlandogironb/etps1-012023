package sv.edu.utec.controleslayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Spinner spPais;
EditText etNombres,etApellidos,etInfo;
RadioButton rbFem,rbMas,rbOtr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombres=findViewById(R.id.edtNombres);
        etApellidos=findViewById(R.id.edtApellidos);
        etInfo=findViewById(R.id.editTextTextMultiLine);
        spPais=findViewById(R.id.spnPais);
        /* forma 1
        spPais.setSelection(0, false);
        String[]opciones={"Seleccione un Pais","Guatemala","El Salvador","Honduras","Nicaragua","Costa Rica","Panama"};
       ArrayAdapter<String> adaptador=
                new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,opciones);
        spPais.setAdapter(adaptador);
        */

        ArrayAdapter<String>

    }



    public void Almacenar(View v){
        String datos="";
        String seleccion = spPais.getSelectedItem().toString();

        if(seleccion.equals("Seleccione un Pais")){
            datos="No selecciono ningun Pais";
            etInfo.append(datos);
        }
        else if(seleccion.equals("Guatemala")){
                datos="Guatemala";
            etInfo.append(datos);
            }
        else if(seleccion.equals("El Salvador")){
            datos="El Salvador";
            etInfo.append(datos);
        }
        else if(seleccion.equals("Honduras")){
            datos="Honduras";
            etInfo.append(datos);
        }
        //etInfo.append("datos");
//08/02/2023
        }
    }

