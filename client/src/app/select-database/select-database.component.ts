import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select-database',
  templateUrl: './select-database.component.html',
  styleUrls: ['./select-database.component.scss']
})
export class SelectDatabaseComponent implements OnInit {

  selectedDb = 'oltpmodbd';

  constructor() {
    this.selectedDb = localStorage.getItem('database-name') || '';
  }

  ngOnInit(): void {
  }

  selectDatabase(db) {
    localStorage.setItem('database-name', db);
    this.selectedDb = db;
    location.reload();
  }

}
