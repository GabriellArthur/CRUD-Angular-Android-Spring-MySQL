package com.gabriellarthur.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.gabriellarthur.myapplication.Model.Pessoa;
import com.gabriellarthur.myapplication.Utils.Apis;
import com.gabriellarthur.myapplication.Utils.PessoaService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    PessoaService pessoaService;
    List<Pessoa> listaPessoas = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView=(ListView)findViewById(R.id.listView);
        listarPessoas();

        FloatingActionButton fab = findViewById(R.id.fabe);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,PessoaActivity.class);
                startActivity(intent);
            }
        });

    }

    public void listarPessoas(){
        pessoaService= Apis.getPessoaService();
        Call<List<Pessoa>>call=pessoaService.getPessoas();
        call.enqueue(new Callback<List<Pessoa>>() {
            @Override
            public void onResponse(Call<List<Pessoa>> call, Response<List<Pessoa>> response) {//exito
                if(response.isSuccessful()){
                    listaPessoas=response.body();
                    listView.setAdapter(new PessoaAdapter(MainActivity.this,R.layout.activity_main,listaPessoas));
                }
            }

            @Override
            public void onFailure(Call<List<Pessoa>> call, Throwable t) {//error
                Log.e("Error",t.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}