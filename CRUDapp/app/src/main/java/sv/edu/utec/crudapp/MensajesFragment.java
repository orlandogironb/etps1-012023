package sv.edu.utec.crudapp;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.utec.crudapp.datos.BaseHelper;
import sv.edu.utec.crudapp.datos.Provedores;


public class MensajesFragment extends Fragment {

EditText txtNomProv,txtTelProv,txtCorrProv;
Button btnGuardar;
Context context;
    public MensajesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatActivity appCompatActivity =new AppCompatActivity();
        txtNomProv=appCompatActivity.findViewById(R.id.edtNOMPROV);
        txtTelProv=appCompatActivity.findViewById(R.id.edtTELPROV);
        txtCorrProv=appCompatActivity.findViewById(R.id.edtCORPROV);
        btnGuardar=appCompatActivity.findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Provedores baseProv = new Provedores(MensajesFragment.this);
                long codiSave=baseProv.insertProvedor(txtNomProv.getText().toString(),txtTelProv.getText().toString(),txtCorrProv.getText().toString());
                if(codiSave>0){
                    Toast.makeText(context, "Registro insertado", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(context, "Error en insertar", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mensajes, container, false);
    }
}