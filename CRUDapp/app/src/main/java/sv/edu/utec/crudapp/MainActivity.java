package sv.edu.utec.crudapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drwLayout;
    Toolbar tlBarra;
    NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tlBarra= findViewById(R.id.toolbar);
        drwLayout=findViewById(R.id.drawerLat);
//24042023
        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(drwLayout,tlBarra);
       // navView=findViewById(R.id.)
    }
}