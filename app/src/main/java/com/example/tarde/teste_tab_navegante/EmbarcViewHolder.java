package com.example.tarde.teste_tab_navegante;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class EmbarcViewHolder extends RecyclerView.ViewHolder {

    View view;

    public EmbarcViewHolder(View itemView) {
        super(itemView);
        view = itemView;
    }

    public void setDetails(Context ctx, String embarcNome, String embarcEmpresa, String embarcTipo, String embarcImagem){

        TextView embarc_nome = (TextView) view.findViewById(R.id.embarc_text);
        TextView embarc_empresa = (TextView) view.findViewById(R.id.empresa_text);
        TextView embarc_tipo = (TextView) view.findViewById(R.id.tipo_text);
        ImageView embarc_imagem = (ImageView) view.findViewById(R.id.profile_image);

        embarc_nome.setText(embarcNome);
        embarc_empresa.setText(embarcEmpresa);
        embarc_tipo.setText(embarcTipo);
        Glide.with(ctx).load(embarcImagem).into(embarc_imagem);
    }
}
