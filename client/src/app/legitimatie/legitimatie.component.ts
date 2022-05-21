import { Component, OnInit } from '@angular/core';
import { LEGITIMATIEITEM, DefaultService } from "../swagger-generated";
import { MatDialog } from "@angular/material/dialog";
import { AddLegitimatieComponent } from "./add-legitimatie/add-legitimatie.component";
import * as moment from 'moment';

const ELEMENT_DATA: LEGITIMATIEITEM[] = [
];
@Component({
  selector: 'app-legitimatie',
  templateUrl: './legitimatie.component.html',
  styleUrls: ['./legitimatie.component.scss']
})
export class LegitimatieComponent implements OnInit {
  displayedColumns: string[] = ['serie_legitimatie','data_expirare', 'actions'];
  dataSource = ELEMENT_DATA;

  constructor(
    private modalService: MatDialog,
    private defaultService: DefaultService
  ) { }

  ngOnInit(): void {
    this.defaultService.legitimatieGet().subscribe((response) => {
      this.dataSource = response.map(e => {
        const legitimatie: LEGITIMATIEITEM = e;
        return legitimatie;
      });
    })
  }

  public addLegitimatie() {
    const modalRef = this.modalService.open(AddLegitimatieComponent);
    modalRef.afterClosed().subscribe((response) => {
      console.log('add response: ', response);
      if (response) {
        this.dataSource = [response, ...this.dataSource]
      }
    });
  }

  public deleteLegitimatie(legitimatie: LEGITIMATIEITEM) {
    this.defaultService.legitimatieIdDelete('' + legitimatie.serie_legitimatie)
      .subscribe(() => {
        this.dataSource = this.dataSource.filter(e => e.serie_legitimatie !== legitimatie.serie_legitimatie);
      });
  }

}
