package com.example.myrecyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonaViewHolder> {

    List<Persona> personas;
    Context context;

    RVAdapter(List<Persona> personas, Context context){
        this.personas = personas;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.persona,parent,false);

        PersonaViewHolder pvh = new PersonaViewHolder(view);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        holder.nombrePersona.setText(personas.get(position).nombre);
        holder.edadPersona.setText(personas.get(position).edad);

        Drawable original = context
                .getResources()
                .getDrawable(personas.get(position).foto
                        ,null);

        Bitmap originalBitmap = ((BitmapDrawable) original).getBitmap();

        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(context.getResources()
                        , originalBitmap);

        roundedDrawable.setCornerRadius(originalBitmap.getHeight());

        holder.fotoPersona.setImageDrawable(roundedDrawable);
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView nombrePersona;
        TextView edadPersona;
        ImageView fotoPersona;

        PersonaViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            nombrePersona = (TextView)itemView.findViewById(R.id.nombrePersona);
            edadPersona = (TextView)itemView.findViewById(R.id.edadPersona);
            fotoPersona = (ImageView) itemView.findViewById(R.id.fotoPersona);
        }
    }
}
