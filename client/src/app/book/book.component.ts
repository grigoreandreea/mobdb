import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {EditBookComponent} from "./edit-book/edit-book.component";
import {CARTEITEM, DefaultService} from "../swagger-generated";
import {AddBookComponent} from "./add-book/add-book.component";
import {transformCamelCaseKeysToUnderscore, transformUnderscoreKeysToCamelCase} from "../swagger-generated/api/helpers";

const ELEMENT_DATA: CARTEITEM[] = [
  {codCarte: 1, titlu: 'Poezii', codSubcategorie: 1, nrExemplare: 4},
  {codCarte: 2, titlu: 'La Medeleni', codSubcategorie: 2, nrExemplare: 1},
];

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {
  displayedColumns: string[] = ['position', 'title', 'subcategory', 'nrExemplare', 'actions'];
  dataSource = ELEMENT_DATA;

  constructor(
    private modalService: MatDialog,
    private defaultService: DefaultService
  ) { }

  ngOnInit(): void {
    this.defaultService.carteGet().subscribe((response) => {
      this.dataSource = response.map(e => transformUnderscoreKeysToCamelCase(e));
    });
  }

  public addBook() {
    const modalRef = this.modalService.open(AddBookComponent);
    modalRef.afterClosed().subscribe((response) => {
      console.log('add response: ', response);
      this.dataSource = [response, ...this.dataSource]
    });
  }

  public editBook(book: CARTEITEM) {
    const modalRef = this.modalService.open(EditBookComponent);
    modalRef.componentInstance.selectedBookDetails = book;
    modalRef.afterClosed().subscribe((response) => {
      console.log('edit response: ', response);
      this.dataSource = this.dataSource.map(e => e.codCarte === response.codCarte ? response : e)
    });
  }

  public deleteBook(book: CARTEITEM) {
    const parsedBook = transformCamelCaseKeysToUnderscore(book);
    this.defaultService.carteIdDelete('' + parsedBook.cod_carte)
      .subscribe(() => {
        this.dataSource = this.dataSource.filter(e => e.codCarte !== book.codCarte);
      });
  }

}
