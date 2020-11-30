import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pessoa } from 'src/app/Modelo/Pessoa';
import { ServicosService } from '../../Service/servicos.service'

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  pessoa:Pessoa = new Pessoa();
  constructor(private router:Router,private service:ServicosService) { }

  ngOnInit(): void {
    this.Editar();
  }

  Editar(){
    let id=localStorage.getItem("id");
    this.service.getPessoaId(+id)
    .subscribe(data=>{
      this.pessoa=data;
    })
  }
  Atualizar(pessoa:Pessoa){
    this.service.updatePessoa(pessoa)
    .subscribe(data=>{
      this.pessoa=data;
      alert("Atualizado com sucesso");
      this.router.navigate(["listar"]);
    })
  }
}
