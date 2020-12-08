package com.gabriellarthur.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.gabriellarthur.myapplication.Model.Pessoa;

import java.util.List;

public class PessoaAdapter extends ArrayAdapter<Pessoa> {

    private Context context;
    private List<Pessoa> pessoas;

    public PessoaAdapter(@NonNull Context context, int resource, @NonNull List<Pessoa> objects) {
        super(context, resource, objects);
        this.context = context;
        this.pessoas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=layoutInflater.inflate(R.layout.content_main,parent,false);

        TextView txtidPessoa=(TextView)rowView.findViewById(R.id.ID);
        TextView txtNome=(TextView)rowView.findViewById(R.id.Nome);
        TextView txtApelido=(TextView)rowView.findViewById(R.id.Apelido);

        txtidPessoa.setText(String.format("ID:%s",pessoas.get(position).getId()));
        txtNome.setText(String.format("NOME:%s",pessoas.get(position).getNome()));
        txtApelido.setText(String.format("APELIDO:%s",pessoas.get(position).getApelido()));

        rowView.setOnClickListener((v)->{
            Intent intent = new Intent(context,PessoaActivity.class);
            context.startActivity(intent);
        });

        return rowView;

    }
}
