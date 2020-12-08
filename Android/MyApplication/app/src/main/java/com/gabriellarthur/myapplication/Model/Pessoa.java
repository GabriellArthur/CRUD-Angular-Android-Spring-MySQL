package com.gabriellarthur.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pessoa {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("nome")
    @Expose
    private String nome;

    @SerializedName("apelido")
    @Expose
    private String apelido;

    public Pessoa(){
    }

    public Pessoa(int id,String nome,String apelido){
        setId(id);
        setApelido(apelido);
        setNome(nome);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
}
