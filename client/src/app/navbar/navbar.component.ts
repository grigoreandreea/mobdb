import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor(
    private router: Router,
  ) { }

  ngOnInit() {}

  public goToSelectDatabase() {
    this.router.navigate(['/select-database']);
  }

  public goToBooks() {
    this.router.navigate(['/books']);
  }

  public goToAutori() {
    this.router.navigate(['/autori']);
  }

  public goToCititori() {
    this.router.navigate(['/cititori']);
  }

  public goToLegitimatii() {
    this.router.navigate(['/legitimatii']);
  }
}
