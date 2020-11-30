
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pessoa } from 'src/app/Modelo/Pessoa';
import { ServicosService } from 'src/app/Service/servicos.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  pessoa:Pessoa = new Pessoa();
  constructor(private router:Router, private service:ServicosService) { }

  ngOnInit(){
  }

  Salvar(pessoa:Pessoa){
    this.service.createPessoa(this.pessoa)
    .subscribe(data=>{
      alert("Salvou!");
      this.router.navigate(["listar"]);
    })
  }
}
