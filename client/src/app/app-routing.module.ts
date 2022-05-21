import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import {BookComponent} from "./book/book.component";
import {AutorComponent} from "./autor/autor.component";
import {CititorComponent} from "./cititor/cititor.component";
import {SelectDatabaseComponent} from "./select-database/select-database.component";
import {ImprumutComponent} from "./imprumut/imprumut.component";
import {BibliotecarComponent} from "./bibliotecar/bibliotecar.component";

const routes: Routes = [
  {
    path: 'books', component: BookComponent
  },
  {
    path: 'autori', component: AutorComponent
  },
  {
    path: 'cititori', component: CititorComponent
  },
  {
    path: 'imprumuturi', component: ImprumutComponent
  },
  {
    path: 'bibliotecari', component: BibliotecarComponent
  },
  {
    path: 'select-database', component: SelectDatabaseComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
