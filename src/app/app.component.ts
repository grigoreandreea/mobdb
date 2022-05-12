import {Component, OnInit} from '@angular/core';
import {DefaultService} from "./swagger-generated";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'client';


  constructor(private defaultService: DefaultService) { }

  ngOnInit() {
    this.defaultService.autorGet().subscribe(e => console.log(e));
  }

}
