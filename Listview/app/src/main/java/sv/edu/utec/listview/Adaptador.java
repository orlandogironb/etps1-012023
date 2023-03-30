package sv.edu.utec.listview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends BaseAdapter {
    Context contexto;
    int layout;
    List<String> pelicula;
    List<String> descrip;
    int[]imagenes;

    public Adaptador(Context contexto, int layout, List<String> pelicula, List<String> descrip, int[] imagenes) {
        this.contexto = contexto;
        this.layout = layout;
        this.pelicula = pelicula;
        this.descrip = descrip;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount() {
        return pelicula.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v =convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(contexto);
        v=layoutInflater.inflate(R.layout.elemento,null);

        TextView txtPeli = v.findViewById(R.id.textView);
        txtPeli.setText(pelicula.get(position));

        TextView txtDesc = v.findViewById(R.id.textView2);
        txtDesc.setText(descrip.get(position));

        ImageView img = v.findViewById(R.id.imageView);
        img.setImageResource(imagenes[position]);


        return v;
    }
}
