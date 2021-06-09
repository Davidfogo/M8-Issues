package com.example.projectem9.Recycler;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectem9.Fragments.IncidenciaSola;
import com.example.projectem9.Objetos.Incidencia;
import com.example.projectem9.R;

import java.io.Serializable;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private List<Incidencia> mData;
    private LayoutInflater mInflater;
    private Context context;

    private int count = 0;
    private Incidencia incidencia;

    public ListAdapter(List<Incidencia> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.item_list,null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder,final int position){
        holder.bindData(mData.get(position));

        //holder.idIncidencia.setText(mData.get(position).getId());
       // holder.nombreIncidencia.setText(mData.get(position).getTitol());
        String prioritat = mData.get(position).getPrioritat();

        if (prioritat.equals("1")) {
            prioritat = "Baixa";
        } else if (prioritat.equals("2")) {
            prioritat = "Mitjana";
        } else if (prioritat.equals("3")) {
            prioritat = "Alta";
        }
        holder.prioritatIncidencia.setText(prioritat);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui lo que hacemos es pasarle el fragmento al que queremos dirigirnos al hacer clic
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                IncidenciaSola incidenciaSola = new IncidenciaSola();

                Incidencia incidencia = mData.get(position);


                 /*Aqui lo que hacemos es crear un bundle para guardar datos como si fuera un paquete
                y le pasamos la variable peli que hemos nombrado arriba y que almacene esa informacion
                con el nombre "peli" */
                Bundle bundle = new Bundle();
                bundle.putSerializable("incidencia", (Serializable) incidencia);


                //aqui lo que pasamos es el contenido del bundle al fragment que queremos enviar los datos
                incidenciaSola.setArguments(bundle);

                FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayoutPantallas, incidenciaSola );
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
    }


    public void setItems(List<Incidencia> items){mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView statusIncidencia;
        TextView nombreIncidencia,prioritatIncidencia,idIncidencia;

        ViewHolder(View itemView){
            super(itemView);
            statusIncidencia = itemView.findViewById(R.id.iconImageView);
            nombreIncidencia = itemView.findViewById(R.id.nombreIncidencia);
            prioritatIncidencia = itemView.findViewById(R.id.prioritatIncidencia);
            statusIncidencia = itemView.findViewById(R.id.iconImageView);
            idIncidencia = itemView.findViewById(R.id.idIncidencia);
        }

        void bindData(final Incidencia item){
            //iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            nombreIncidencia.setText((item.getTitol()));
            prioritatIncidencia.setText(String.valueOf(item.getPrioritatIncidencia()));
            idIncidencia.setText((item.getId()));
            statusIncidencia.setColorFilter(Color.parseColor("#ff0000"));

            statusIncidencia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (count == 0) {

                        //AMARILLO
                        statusIncidencia.setColorFilter(Color.parseColor("#FFA200"));
                        count++;
                    }else if(count == 1){
                        //VERDE
                        statusIncidencia.setColorFilter(Color.parseColor("#1AFF00"));
                        count++;
                    }else if(count == 2){
                        //ROJO
                        statusIncidencia.setColorFilter(Color.parseColor("#ff0000"));
                        count = 0;
                    }
                }
            });

        }
    }
}
