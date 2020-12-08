package com.gabriellarthur.myapplication.Utils;

public class Apis {

    public static final String URL_001="http://192.168.1.2:8090/pessoas/";

    public static PessoaService getPessoaService(){
        return Cliente.getCliente(URL_001).create(PessoaService.class);
    }
}
