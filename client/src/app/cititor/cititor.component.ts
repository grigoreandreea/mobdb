import { Component, OnInit } from '@angular/core';
import {CITITORITEM, DefaultService} from "../swagger-generated";
import {MatDialog} from "@angular/material/dialog";
import {AddCititorComponent} from "./add-cititor/add-cititor.component";
import {EditCititorComponent} from "./edit-cititor/edit-cititor.component";

const ELEMENT_DATA: CITITORITEM[] = [
  // {cod_cititor: 1, serie_legitimatie: 'Poezii', nume: 'Eminescu', prenume: 'Mihai', gen: 'm', data_n: '2002-12-12 00:00:00', str_nr: 'undeva 43', localitate: 'Bacau', email: 'popescu@user.com'},
  // {cod_cititor: 2, serie_legitimatie: 'La Medeleni', nume: 'Eminescu', prenume: 'Mihai', gen: 'm', data_n: '2002-12-12 00:00:00', str_nr: 'undeva 43', localitate: 'Bacau', email: 'popescu@user.com'},
];

@Component({
  selector: 'app-cititor',
  templateUrl: './cititor.component.html',
  styleUrls: ['./cititor.component.scss']
})
export class CititorComponent implements OnInit {

  displayedColumns: string[] = ['position', 'serie_legitimatie', 'nume', 'prenume', 'gen', 'date', 'str_nr', 'localitate', 'email', 'actions'];
  dataSource = ELEMENT_DATA;

  constructor(
    private modalService: MatDialog,
    private defaultService: DefaultService
  ) { }

  ngOnInit(): void {
    this.defaultService.cititorGet().subscribe((response) => {
      this.dataSource = response.map(e => {
        const cititor: CITITORITEM = e;
        return cititor;
      });    });
  }

  public addCititor() {
    const modalRef = this.modalService.open(AddCititorComponent);
    modalRef.afterClosed().subscribe((response) => {
      if (response ) {
        this.dataSource = [response, ...this.dataSource]
      }
    });
  }

  public editCititor(cititor: CITITORITEM) {
    const modalRef = this.modalService.open(EditCititorComponent);
    modalRef.componentInstance.selectedCititorDetails = cititor;
    modalRef.afterClosed().subscribe((response) => {
      if (response) {
        this.dataSource = this.dataSource.map(e => e.cod_cititor === response.cod_cititor ? response : e)
      }
    });
  }

  public deleteCititor(cititor: CITITORITEM) {
    this.defaultService.cititorIdDelete('' + cititor.cod_cititor)
      .subscribe(() => {
        this.dataSource = this.dataSource.filter(e => e.cod_cititor !== cititor.cod_cititor);
      });
  }
}
