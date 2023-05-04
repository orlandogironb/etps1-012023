package sv.edu.utec.crudapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import sv.edu.utec.crudapp.datos.BaseHelper;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drwLayout;
    Toolbar tlBarra;
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tlBarra= findViewById(R.id.toolbar);
        drwLayout=findViewById(R.id.drawerLayout);
        navView=findViewById(R.id.navigator);
//24042023
        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drwLayout,tlBarra,R.string.open,R.string.close);
        drwLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white,null));
       // navView=findViewById(R.id.)
      /*adicion de creacion base de datos 03052023 antes de grabacion */
        BaseHelper basehelper = new BaseHelper(this);
        SQLiteDatabase db =basehelper.getWritableDatabase();
        if(db!=null){
            Toast.makeText(this, "Base de datos creada", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Error en crear la Base de datos", Toast.LENGTH_LONG).show();
        }

        /*adicion de creacion base de datos 03052023 fin agregado*/
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.mensajes://ya
                        drwLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(getApplicationContext(),"Mensaje",Toast.LENGTH_SHORT).show();
                        fragmentosR(new MensajesFragment());
                        break;
                    case R.id.comentarios://ya
                        drwLayout.closeDrawer(GravityCompat.START);
                        fragmentosR(new ComentariosFragment());
                        Toast.makeText(getApplicationContext(),"Comentarios",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.enviar://ya
                        fragmentosR(new EnviarFragment());
                        drwLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(getApplicationContext(),"Enviar",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.compartir://ya
                        fragmentosR(new CompartirFragment());
                        drwLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(getApplicationContext(),"Compartir",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.explorar://
                        fragmentosR(new ExplorarFragment());
                        drwLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(getApplicationContext(),"Encontrar",Toast.LENGTH_SHORT).show();
                        break;
                }


                return true;
            }
        });
    }
    private void fragmentosR(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frmLayoutContenedor,fragment);
        fragmentTransaction.commit();

    }
}