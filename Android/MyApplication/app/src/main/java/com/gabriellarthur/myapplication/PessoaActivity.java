package com.gabriellarthur.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gabriellarthur.myapplication.Model.Pessoa;
import com.gabriellarthur.myapplication.Utils.Apis;
import com.gabriellarthur.myapplication.Utils.PessoaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PessoaActivity extends AppCompatActivity {
    PessoaService service;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Intent intent = new Intent(PessoaActivity.this,MainActivity.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pessoa_layout);

        TextView nomes =(TextView) findViewById(R.id.nomes);
        final EditText txtNomes=(EditText) findViewById(R.id.txtNomes);
        TextView apelidos =(TextView) findViewById(R.id.apelidos);
        final EditText txtApelidos=(EditText) findViewById(R.id.txtApelidos);

        Button btnSave=(Button)findViewById(R.id.btnSave);
        Button btnVoltar=(Button)findViewById(R.id.btnVoltvar);


        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Pessoa p = new Pessoa();
                p.setNome(txtNomes.getText().toString());
                p.setApelido(txtApelidos.getText().toString());
                addPessoa(p);
                startActivity(intent);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(intent);
            }
        });
    }

    public void addPessoa(Pessoa p){
        service = Apis.getPessoaService();
        Call<Pessoa>call=service.addPessoa(p);
        call.enqueue(new Callback<Pessoa>() {
            @Override
            public void onResponse(Call<Pessoa> call, Response<Pessoa> response) {
                if(response!=null){
                    Toast.makeText(PessoaActivity.this,"Adicionou com exito",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Pessoa> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
        Intent intent = new Intent(PessoaActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
