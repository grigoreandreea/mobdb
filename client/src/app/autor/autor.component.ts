import { Component, OnInit } from '@angular/core';
import { AUTORITEM, DefaultService } from "../swagger-generated";
import { MatDialog } from "@angular/material/dialog";
import { AddAutorComponent } from "./add-autor/add-autor.component";
import { EditAutorComponent } from "./edit-autor/edit-autor.component";
import * as moment from 'moment';

const ELEMENT_DATA: AUTORITEM[] = [
  // {cod_autor: 1, nume: 'Eminescu', prenume: 'Mihai', data_n: '2002-12-12 00:00:00'},
  // {cod_autor: 2, nume: 'Creanga', prenume: 'Ion', data_n: '2002-12-12 00:00:00'},
];
@Component({
  selector: 'app-autor',
  templateUrl: './autor.component.html',
  styleUrls: ['./autor.component.scss']
})
export class AutorComponent implements OnInit {
  displayedColumns: string[] = ['position', 'nume', 'prenume', 'date', 'actions'];
  dataSource = ELEMENT_DATA;

  constructor(
    private modalService: MatDialog,
    private defaultService: DefaultService
  ) { }

  ngOnInit(): void {
    this.defaultService.autorGet().subscribe((response) => {
      this.dataSource = response.map(e => {
        const autor: AUTORITEM = e;
        return autor;
      });
    })
  }

  public addAutor() {
    const modalRef = this.modalService.open(AddAutorComponent);
    modalRef.afterClosed().subscribe((response) => {
      console.log('add response: ', response);
      if (response) {
        this.dataSource = [response, ...this.dataSource]
      }
    });
  }

  public editAutor(autor: AUTORITEM) {
    const modalRef = this.modalService.open(EditAutorComponent);
    modalRef.componentInstance.selectedAutorDetails = autor;
    modalRef.afterClosed().subscribe((response) => {
      console.log('edit response: ', response);
      if (response) {
        this.dataSource = this.dataSource.map(e => e.cod_autor === response.cod_autor ? response : e)
      }
    });
  }

  public deleteAutor(autor: AUTORITEM) {
    this.defaultService.autorIdDelete('' + autor.cod_autor)
      .subscribe(() => {
        this.dataSource = this.dataSource.filter(e => e.cod_autor !== autor.cod_autor);
      });
  }

}
