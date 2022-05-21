import { Component, OnInit } from '@angular/core';
import {BIBLIOTECARITEM, DefaultService} from "../swagger-generated";
import { MatDialog } from "@angular/material/dialog";
import { AddBibliotecarComponent } from "./add-bibliotecar/add-bibliotecar.component";
import { EditBibliotecarComponent } from "./edit-bibliotecar/edit-bibliotecar.component";
import * as moment from 'moment';

const ELEMENT_DATA: BIBLIOTECARITEM[] = [];

@Component({
  selector: 'app-bibliotecar',
  templateUrl: './bibliotecar.component.html',
  styleUrls: ['./bibliotecar.component.scss']
})
export class BibliotecarComponent implements OnInit {
  displayedColumns: string[] = ['position', 'nume', 'prenume', 'date', 'actions'];
  dataSource = ELEMENT_DATA;

  constructor(
    private modalService: MatDialog,
    private defaultService: DefaultService
  ) { }

  ngOnInit(): void {
    this.defaultService.bibliotecarGet().subscribe((response) => {
      this.dataSource = response.map(e => {
        const bibliotecar: BIBLIOTECARITEM = e;
        return bibliotecar;
      });
    })
  }

  public addBibliotecar() {
    const modalRef = this.modalService.open(AddBibliotecarComponent);
    modalRef.afterClosed().subscribe((response) => {
      console.log('add response: ', response);
      if (response) {
        this.dataSource = [response, ...this.dataSource]
      }
    });
  }

  public editBibliotecar(bibliotecar: BIBLIOTECARITEM) {
    const modalRef = this.modalService.open(EditBibliotecarComponent);
    modalRef.componentInstance.selectedBibliotecarDetails = bibliotecar;
    modalRef.afterClosed().subscribe((response) => {
      console.log('edit response: ', response);
      if (response) {
        this.dataSource = this.dataSource.map(e => e.cod_bibliotecar === response.cod_bibliotecar ? response : e)
      }
    });
  }

  public deleteBibliotecar(bibliotecar: BIBLIOTECARITEM) {
    this.defaultService.bibliotecarIdDelete('' + bibliotecar.cod_bibliotecar)
      .subscribe(() => {
        this.dataSource = this.dataSource.filter(e => e.cod_bibliotecar !== bibliotecar.cod_bibliotecar);
      });
  }

}
