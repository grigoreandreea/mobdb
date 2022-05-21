import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {EditImprumutComponent} from "./edit-imprumut/edit-imprumut.component";
import {IMPRUMUTAITEM, DefaultService} from "../swagger-generated";
import {AddImprumutComponent} from "./add-imprumut/add-imprumut.component";
import * as moment from 'moment';

@Component({
  selector: 'app-imprumut',
  templateUrl: './imprumut.component.html',
  styleUrls: ['./imprumut.component.scss']
})
export class ImprumutComponent implements OnInit {
  displayedColumns: string[] = ['cod_carte', 'cod_cititor', 'data_imprumut', 'termen_limita', 'data_restituire', 'actions'];
  dataSource: Array<IMPRUMUTAITEM> = [];

  constructor(
    private modalService: MatDialog,
    private defaultService: DefaultService
  ) { }

  ngOnInit(): void {
    this.defaultService.imprumutaGet().subscribe((response) => {
      this.dataSource = response.map(element => {
        return {
          ...element,
          parsedDataImprumut: element.data_imprumut && moment(element.data_imprumut).format('DD MMM YYY'),
          parsedTermenLimita: element.termen_limita && moment(element.termen_limita).format('DD MMM YYYY'),
          parsedDataRestituire: element.data_restituire && moment(element.data_restituire).format('DD MMM YYYY'),
        }
      });
      console.log('Datasource: ', this.dataSource);
    });
  }

  public addImprumut() {
    const modalRef = this.modalService.open(AddImprumutComponent);
    modalRef.afterClosed().subscribe((response) => {
      if (response) {
        const parsedResponse = {
          ...response,
          parsedDataImprumut: response.data_imprumut && moment(response.data_imprumut).format('DD MMM YYY'),
          parsedTermenLimita: response.termen_limita && moment(response.termen_limita).format('DD MMM YYYY'),
          parsedDataRestituire: response.data_restituire && moment(response.data_restituire).format('DD MMM YYYY'),
        }
        this.dataSource = [parsedResponse, ...this.dataSource];
      }
    });
  }

  public editImprumut(imprumut: IMPRUMUTAITEM) {
    const modalRef = this.modalService.open(EditImprumutComponent);
    modalRef.componentInstance.selectedImprumutDetails = imprumut;
    modalRef.afterClosed().subscribe((response) => {
      if (response) {
        const parsedResponse = {
          ...response,
          parsedDataImprumut: response.data_imprumut && moment(response.data_imprumut).format('DD MMM YYY'),
          parsedTermenLimita: response.termen_limita && moment(response.termen_limita).format('DD MMM YYYY'),
          parsedDataRestituire: response.data_restituire && moment(response.data_restituire).format('DD MMM YYYY'),
        }
        this.dataSource = this.dataSource.map(e => (
          e.cod_carte === response.cod_carte && e.cod_cititor === response.cod_cititor
            ? parsedResponse
            : e
        ));
      }
    });
  }

  public deleteImprumut(imprumut: IMPRUMUTAITEM) {
    this.defaultService.imprumutaIdDelete('' + imprumut.cod_carte)
      .subscribe(() => {
        this.dataSource = this.dataSource.filter(e => e.cod_carte !== imprumut.cod_carte && e.cod_cititor !== imprumut.cod_cititor);
      });
  }

}
