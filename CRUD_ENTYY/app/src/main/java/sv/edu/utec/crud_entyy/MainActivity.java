package sv.edu.utec.crud_entyy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import sv.edu.utec.crud_entyy.adaptador.ListaProveAdapter;
import sv.edu.utec.crud_entyy.bd.DbHelper;
import sv.edu.utec.crud_entyy.bd.Proveedor;
import sv.edu.utec.crud_entyy.entidades.EntProvedor;

public class MainActivity extends AppCompatActivity {
RecyclerView listaProvedores;
 ArrayList<EntProvedor>   lstArrayProveedor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaProvedores=findViewById(R.id.listadoProv);
        DbHelper dbHelper = new DbHelper(MainActivity.this);
        SQLiteDatabase db =dbHelper.getWritableDatabase();
        listaProvedores.setLayoutManager(new LinearLayoutManager(this));
        Proveedor dbProveedor = new Proveedor(MainActivity.this);
        lstArrayProveedor = new ArrayList<>();

        ListaProveAdapter adapter = new ListaProveAdapter(dbProveedor.mostrarProvedores());
        listaProvedores.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()){
          case R.id.mnuNuevo:
              nuevoProveedor();
              return true;
          default:
              return super.onOptionsItemSelected(item);
      }

    }

    private void nuevoProveedor(){
        Intent intent = new Intent(this,NuevoProvActivity.class);
        startActivity(intent);
    }
}