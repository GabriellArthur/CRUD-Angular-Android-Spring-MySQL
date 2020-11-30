import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pessoa } from 'src/app/Modelo/Pessoa';
import { ServicosService } from '../../Service/servicos.service'

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  pessoas: Pessoa[];
  constructor(private service:ServicosService, private router:Router) { }

  ngOnInit() {
    this.service.getPessoas()
    .subscribe(data=>{
      this.pessoas=data;
    })
  }
  Editar(pessoa:Pessoa){
    localStorage.setItem("id",pessoa.id.toString());
    this.router.navigate(["edit"]);
  }

  Delete(pessoa:Pessoa){
    this.service.deletePessoa(pessoa)
    .subscribe(data=>{
      this.pessoas=this.pessoas.filter(p=>p!==pessoa);
      alert("Usuario deletado!");
    })
  }
}
