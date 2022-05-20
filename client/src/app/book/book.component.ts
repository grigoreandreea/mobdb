import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {EditBookComponent} from "./edit-book/edit-book.component";
import {CARTEITEM, DefaultService} from "../swagger-generated";
import {AddBookComponent} from "./add-book/add-book.component";

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
      console.log(response);
    });
  }

  public addBook() {
    const modalRef = this.modalService.open(AddBookComponent);
    modalRef.afterClosed().subscribe((response) => {
      console.log('add response: ', response);
    });
  }

  public editBook(book: CARTEITEM) {
    const modalRef = this.modalService.open(EditBookComponent);
    modalRef.componentInstance.selectedBookDetails = book;
    modalRef.afterClosed().subscribe((response) => {
      console.log('edit response: ', response);
      if (response[0]) {
        this.dataSource = this.dataSource.filter((bookItem) => {
          if (bookItem.codCarte === response[1].codCarte) {
            bookItem = response[1];
          }
          return bookItem;
        });
      }
    });
  }

  public deleteBook(book: CARTEITEM | null) {
    this.defaultService.carteIdDelete('' + book?.codCarte);
  }

}
