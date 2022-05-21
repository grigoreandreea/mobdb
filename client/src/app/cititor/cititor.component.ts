import { Component, OnInit } from '@angular/core';
import {CITITORITEM, DefaultService} from "../swagger-generated";
import {MatDialog} from "@angular/material/dialog";
import {transformCamelCaseKeysToUnderscore, transformUnderscoreKeysToCamelCase} from "../swagger-generated/api/helpers";
import {AddCititorComponent} from "./add-cititor/add-cititor.component";
import {EditCititorComponent} from "./edit-cititor/edit-cititor.component";

const ELEMENT_DATA: CITITORITEM[] = [
  // {codCititor: 1, serieLegitimatie: 'Poezii', nume: 'Eminescu', prenume: 'Mihai', gen: 'm', dataN: '2002-12-12 00:00:00', strNr: 'undeva 43', localitate: 'Bacau', email: 'popescu@user.com'},
  // {codCititor: 2, serieLegitimatie: 'La Medeleni', nume: 'Eminescu', prenume: 'Mihai', gen: 'm', dataN: '2002-12-12 00:00:00', strNr: 'undeva 43', localitate: 'Bacau', email: 'popescu@user.com'},
];

@Component({
  selector: 'app-cititor',
  templateUrl: './cititor.component.html',
  styleUrls: ['./cititor.component.scss']
})
export class CititorComponent implements OnInit {

  displayedColumns: string[] = ['position', 'serieLegitimatie', 'nume', 'prenume', 'gen', 'date', 'strNr', 'localitate', 'email', 'actions'];
  dataSource = ELEMENT_DATA;

  constructor(
    private modalService: MatDialog,
    private defaultService: DefaultService
  ) { }

  ngOnInit(): void {
    this.defaultService.cititorGet().subscribe((response) => {
      this.dataSource = response.map(e => transformUnderscoreKeysToCamelCase(e));
    });
  }

  public addCititor() {
    const modalRef = this.modalService.open(AddCititorComponent);
    modalRef.afterClosed().subscribe((response) => {
      console.log('add response: ', response);
      if (response ) {
        this.dataSource = [response, ...this.dataSource]
      }
    });
  }

  public editCititor(cititor: CITITORITEM) {
    const modalRef = this.modalService.open(EditCititorComponent);
    modalRef.componentInstance.selectedCititorDetails = cititor;
    modalRef.afterClosed().subscribe((response) => {
      console.log('edit response: ', response);
      if (response) {
        this.dataSource = this.dataSource.map(e => e.codCititor === response.codCititor ? response : e)
      }
    });
  }

  public deleteCititor(cititor: CITITORITEM) {
    const parsedCititor = transformCamelCaseKeysToUnderscore(cititor);
    this.defaultService.cititorIdDelete('' + parsedCititor.cod_cititor)
      .subscribe(() => {
        this.dataSource = this.dataSource.filter(e => e.codCititor !== cititor.codCititor);
      });
  }
}
