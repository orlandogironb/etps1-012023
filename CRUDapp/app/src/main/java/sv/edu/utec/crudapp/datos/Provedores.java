package sv.edu.utec.crudapp.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import sv.edu.utec.crudapp.MensajesFragment;

public class Provedores extends BaseHelper {
    Context contex;
    public Provedores(Context context) {
        super(context);
    }
    //Context context;



    /*
     "CODPROV INTEGER PRIMARY KEY AUTOINCREMENT ,"+
             "NOMPROV TEXT NOT NULL ,"+
             "TELPROV TEXT NOT NULL ,"+
             "CORPROV TEXT NOT NULL"
    */
    public long insertProvedor(String NOMPROV,String TELPROV, String CORPROV){

        long codigo=0;
        try {

          BaseHelper baseHelp = new BaseHelper(contex);
          SQLiteDatabase bd = baseHelp.getWritableDatabase();

          ContentValues valoresProv = new ContentValues();
          valoresProv.put("NOMPROV", NOMPROV);
          valoresProv.put("TELPROV", TELPROV);
          valoresProv.put("CORPROV", CORPROV);

            codigo= bd.insert(NOMBRE_TABLAPR, null, valoresProv);
          return codigo;
      }
      catch (Exception ex){
          ex.toString();
          return codigo=0;
      }

    }
}
