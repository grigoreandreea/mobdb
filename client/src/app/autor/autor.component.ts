import { Component, OnInit } from '@angular/core';
import {AUTORITEM, DefaultService} from "../swagger-generated";
import {MatDialog} from "@angular/material/dialog";
import {transformCamelCaseKeysToUnderscore, transformUnderscoreKeysToCamelCase} from "../swagger-generated/api/helpers";
import {AddAutorComponent} from "./add-autor/add-autor.component";
import {EditAutorComponent} from "./edit-autor/edit-autor.component";
import * as moment from 'moment';

const ELEMENT_DATA: AUTORITEM[] = [
  // {codAutor: 1, nume: 'Eminescu', prenume: 'Mihai', dataN: '2002-12-12 00:00:00'},
  // {codAutor: 2, nume: 'Creanga', prenume: 'Ion', dataN: '2002-12-12 00:00:00'},
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
        const autor = transformUnderscoreKeysToCamelCase(e);
        return {
          ...autor,
          parsedDataN: moment(autor.dataN).format('DD MMM YYYY')
        }
      });
    });
  }

  public addAutor() {
    const modalRef = this.modalService.open(AddAutorComponent);
    modalRef.afterClosed().subscribe((response) => {
      console.log('add response: ', response);
      if (response ) {
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
        this.dataSource = this.dataSource.map(e => e.codAutor === response.codAutor ? response : e)
      }
    });
  }

  public deleteAutor(autor: AUTORITEM) {
    const parsedAutor = transformCamelCaseKeysToUnderscore(autor);
    this.defaultService.autorIdDelete('' + parsedAutor.cod_autor)
      .subscribe(() => {
        this.dataSource = this.dataSource.filter(e => e.codAutor !== autor.codAutor);
      });
  }

}
