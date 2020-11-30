import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pessoa } from '../Modelo/Pessoa';

@Injectable({
  providedIn: 'root'
})
export class ServicosService {

  constructor(private http:HttpClient) { }

  Url='http://localhost:8080/pessoas';

  getPessoas(){
    return this.http.get<Pessoa[]>(this.Url);
  }
  createPessoa(pessoa:Pessoa){
    return this.http.post<Pessoa>(this.Url,pessoa);
  }
  getPessoaId(id:Number){
    return this.http.get<Pessoa>(this.Url+"/"+id);
  }
  updatePessoa(pessoa:Pessoa){
    return this.http.put<Pessoa>(this.Url+"/"+pessoa.id,pessoa);
  }
  deletePessoa(pessoa:Pessoa){
    return this.http.delete<Pessoa>(this.Url+"/"+pessoa.id);
  }
}
