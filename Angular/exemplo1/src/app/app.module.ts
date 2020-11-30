import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListarComponent } from './CRUD/listar/listar.component';
import { AddComponent } from './CRUD/add/add.component';
import { EditComponent } from './CRUD/edit/edit.component';
import { FormsModule } from '@angular/forms';
import { ServicosService } from '../app/Service/servicos.service';
import { HttpClientModule } from '@angular/common/http';
@NgModule({
  declarations: [
    AppComponent,
    ListarComponent,
    AddComponent,
    EditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ServicosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
