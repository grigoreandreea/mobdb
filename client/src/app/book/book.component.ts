import { Component, OnInit } from '@angular/core';

export enum SUBCATEGORY {
  LIRIC = 'Liric',
  EPIC = 'Epic'
}

export interface Book {
  title: string;
  position: number;
  subcategory: SUBCATEGORY;
  nrExemplare: number;
}

const ELEMENT_DATA: Book[] = [
  {position: 1, title: 'Poezii', subcategory: SUBCATEGORY.LIRIC, nrExemplare: 4},
  {position: 2, title: 'La Medeleni', subcategory: SUBCATEGORY.EPIC, nrExemplare: 1},
];

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {
  displayedColumns: string[] = ['position', 'title', 'subcategory', 'nrExemplare'];
  dataSource = ELEMENT_DATA;

  constructor() { }

  ngOnInit(): void {

  }

}
