package com.example.android.modeloparcial;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.modeloparcial.MainActivity.Modelo;

/**
 * Created by android on 28/09/17.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvNombre;
    public TextView tvApellido;
    public TextView tvTelefono;
    public Button btnCompartir;
    public Button btnLlamar;
    public Activity activity;


    public MyViewHolder(View itemView,  Activity activity) {
        super(itemView);
        this.tvNombre = (TextView) itemView.findViewById(R.id.txtNombre);
        this.tvApellido = (TextView) itemView.findViewById(R.id.txtApellido);
        this.tvTelefono = (TextView) itemView.findViewById(R.id.txtTelefono);
        this.btnCompartir = (Button) itemView.findViewById(R.id.btnCompartir);
        this.btnLlamar = (Button) itemView.findViewById(R.id.btnLlamar);
        this.activity = activity;

        this.btnCompartir.setOnClickListener(this);
        this.btnLlamar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btnCompartir){

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, "Contacto: " + Modelo.getListaContactos().get(getAdapterPosition()).getNombre() + " - " + Modelo.getListaContactos().get(getAdapterPosition()).getApellido() + " - " + Modelo.getListaContactos().get(getAdapterPosition()).getTelefono());
            intent.setType("text/plain");
            activity.startActivity(intent);
        }

        if(view.getId() == R.id.btnLlamar){

            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+Modelo.getListaContactos().get(getAdapterPosition()).getTelefono()));
            activity.startActivity(intent);
        }
    }
}
