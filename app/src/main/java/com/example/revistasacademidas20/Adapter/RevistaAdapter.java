package com.example.revistasacademidas20.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.revistasacademidas20.Modelo.Revista;
import com.example.revistasacademidas20.R;

import java.util.List;

public class RevistaAdapter extends RecyclerView.Adapter<RevistaAdapter.RevistaViewHolder>{

    private Context ctx;
    private List<Revista> lstRevistas;

    public RevistaAdapter(Context mCtx,List<Revista> revistas){
        this.lstRevistas=revistas;
        ctx=mCtx;
    }

    @Override
    public RevistaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(ctx);
        View view= inflater.inflate(R.layout.item_revistas,null);
        return  new RevistaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RevistaViewHolder holder, int position) {
        Revista revista= lstRevistas.get(position);

        holder.textUno.setText(revista.getIssue_id());
        holder.textDos.setText(revista.getVolume());
        holder.textTres.setText(revista.getNumber());
        holder.textCuatro.setText(revista.getYear());
        holder.textCinco.setText(revista.getDate_published());
        holder.textSeis.setText(revista.getTitle());
        holder.textUrlDoi.setText(revista.getDoi());
        holder.textUrlImagen.setText(revista.getCover());

        Glide.with(ctx)
                .load(revista.getCover())
                .into(holder.imgenAvatar);

    }

    @Override
    public int getItemCount() {
        return lstRevistas.size();
    }

    class RevistaViewHolder extends RecyclerView.ViewHolder {

        TextView textUno,textDos, textTres, textCuatro, textCinco, textSeis, textUrlDoi,textUrlImagen;
        ImageView imgenAvatar ;

        public RevistaViewHolder(View itemView) {
            super(itemView);

            textUno= itemView.findViewById(R.id.txtUno);
            textDos= itemView.findViewById(R.id.txtDos);
            textTres= itemView.findViewById(R.id.txtTres);
            textCuatro= itemView.findViewById(R.id.txtCuatro);
            textCinco= itemView.findViewById(R.id.txtCinco);
            textSeis= itemView.findViewById(R.id.txtSeis);
            textUrlDoi = itemView.findViewById(R.id.txtUrlDoi);
            textUrlImagen = itemView.findViewById(R.id.txtUrlImagen);
            imgenAvatar = itemView.findViewById(R.id.imgAvatar);
        }
    }
}
