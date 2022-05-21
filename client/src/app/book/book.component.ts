import { Component, OnInit } from '@angular/core';
import { MatDialog } from "@angular/material/dialog";
import { EditBookComponent } from "./edit-book/edit-book.component";
import { CARTEITEM, DefaultService } from "../swagger-generated";
import { AddBookComponent } from "./add-book/add-book.component";

const ELEMENT_DATA: CARTEITEM[] = [
  { cod_carte: 1, titlu: 'Poezii', cod_subcategorie: 1, nr_exemplare: 4 },
  { cod_carte: 2, titlu: 'La Medeleni', cod_subcategorie: 2, nr_exemplare: 1 },
];

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {
  displayedColumns: string[] = ['position', 'title', 'subcategory', 'nr_exemplare', 'actions'];
  dataSource = ELEMENT_DATA;

  constructor(
    private modalService: MatDialog,
    private defaultService: DefaultService
  ) { }

  ngOnInit(): void {
    this.defaultService.carteGet().subscribe((response) => {
      this.dataSource = response.map(e => {
        const book: CARTEITEM = e;
        return book;
      });
    });
  }

  public addBook() {
    const modalRef = this.modalService.open(AddBookComponent);
    modalRef.afterClosed().subscribe((response) => {
      console.log('add response: ', response);
      if (response) {
        this.dataSource = [response, ...this.dataSource]
      }
    });
  }

  public editBook(book: CARTEITEM) {
    const modalRef = this.modalService.open(EditBookComponent);
    modalRef.componentInstance.selectedBookDetails = book;
    modalRef.afterClosed().subscribe((response) => {
      console.log('edit response: ', response);
      if (response) {
        this.dataSource = this.dataSource.map(e => e.cod_carte === response.cod_carte ? response : e);
      }
    });
  }

  public deleteBook(book: CARTEITEM) {
    this.defaultService.carteIdDelete('' + book.cod_carte)
      .subscribe(() => {
        this.dataSource = this.dataSource.filter(e => e.cod_carte !== book.cod_carte);
      });
  }

}
