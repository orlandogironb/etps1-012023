package sv.edu.utec.crudapp.adapatadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sv.edu.utec.crudapp.R;
import sv.edu.utec.crudapp.entidades.EntProvedores;

 public class LstProvedoresAdapter extends RecyclerView.Adapter<LstProvedoresAdapter.ProvedoresViewHolder> {

    ArrayList<EntProvedores> listaprove;


    public LstProvedoresAdapter(ArrayList<EntProvedores>listaprove ) {

        this.listaprove=listaprove;
    }

    public LstProvedoresAdapter() {
    }

    @NonNull
    @Override
    public LstProvedoresAdapter.ProvedoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      //  return null;
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_provedores,null,false);
        return new ProvedoresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LstProvedoresAdapter.ProvedoresViewHolder holder, int position) {
        holder.viewNombre.setText(listaprove.get(position).getNOMPROV());
        holder.viewTelefono.setText(listaprove.get(position).getTELPROV());
        holder.viewCorreo.setText(listaprove.get(position).getCORPROV());
    }

    @Override
    public int getItemCount() {
        return listaprove.size();
    }

    public class ProvedoresViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombre,viewTelefono,viewCorreo;
        public ProvedoresViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre=itemView.findViewById(R.id.tvNomProve);
            viewTelefono=itemView.findViewById(R.id.tvTelProve);
            viewCorreo=itemView.findViewById(R.id.tvCorreo);
        }
    }
}
