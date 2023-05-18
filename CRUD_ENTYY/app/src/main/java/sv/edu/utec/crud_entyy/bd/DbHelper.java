package sv.edu.utec.crud_entyy.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DBVersion=1;
    private static final String DBNombre="tienda.db";

    public static final String TBLNombrePRV="t_proveedor";

    public DbHelper(@Nullable Context context) {
        super(context, DBNombre, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TBLNombrePRV+"("
                        +"IDPROV INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        "NOMBPROV TEXT NOT NULL,"+
                        "TELPROV TEXT NOT NULL,"+
                        "MAILPROV TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+TBLNombrePRV);
        onCreate(db);
    }
}
