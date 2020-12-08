package com.gabriellarthur.myapplication.Utils;

import com.gabriellarthur.myapplication.Model.Pessoa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PessoaService {

    @GET("listar")
    Call<List<Pessoa>>getPessoas();

    @POST("add")
    Call<Pessoa>addPessoa(@Body Pessoa pessoa);

}
