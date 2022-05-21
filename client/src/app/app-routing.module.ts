import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import {BookComponent} from "./book/book.component";
import {AutorComponent} from "./autor/autor.component";
import {CititorComponent} from "./cititor/cititor.component";

const routes: Routes = [
  {
    path: 'books', component: BookComponent
  },
  {
    path: 'autori', component: AutorComponent
  },
  {
    path: 'cititori', component: CititorComponent
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
