package sv.edu.utec.crud_entyy.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sv.edu.utec.crud_entyy.R;
import sv.edu.utec.crud_entyy.entidades.EntProvedor;

public class ListaProveAdapter extends RecyclerView.Adapter<ListaProveAdapter.ProvedoresViewHolder> {

    ArrayList<EntProvedor>listaProvedor;
    public ListaProveAdapter(ArrayList<EntProvedor> listaProvedor){
        this.listaProvedor=listaProvedor;
    }
    @NonNull
    @Override
    public ProvedoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_provedores,null,false);
        return new ProvedoresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProvedoresViewHolder holder, int position) {
        holder.vNombre.setText(listaProvedor.get(position).getNombre());
        holder.vTelefono.setText(listaProvedor.get(position).getTelefono());
        holder.vCorreo.setText(listaProvedor.get(position).getMail());

    }

    @Override
    public int getItemCount() {
        return listaProvedor.size();
    }

    public class ProvedoresViewHolder extends RecyclerView.ViewHolder {
        TextView vNombre,vTelefono,vCorreo;
        public ProvedoresViewHolder(@NonNull View itemView) {
            super(itemView);
            vNombre =itemView.findViewById(R.id.tvNombre);
            vTelefono=itemView.findViewById(R.id.txvTelefono);
                    vCorreo=itemView.findViewById(R.id.txvMail);
        }
    }
}
