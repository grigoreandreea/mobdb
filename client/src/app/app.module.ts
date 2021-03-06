import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {ApiModule} from "./swagger-generated";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BookComponent } from './book/book.component';
import { NavbarComponent } from './navbar/navbar.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatSliderModule} from "@angular/material/slider";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MatTableModule} from "@angular/material/table";
import { EditBookComponent } from './book/edit-book/edit-book.component';
import {MAT_DIALOG_DEFAULT_OPTIONS, MatDialogModule} from "@angular/material/dialog";
import { AddBookComponent } from './book/add-book/add-book.component';
import {MatInputModule} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";
import { AutorComponent } from './autor/autor.component';
import { AddAutorComponent } from './autor/add-autor/add-autor.component';
import { EditAutorComponent } from './autor/edit-autor/edit-autor.component';
import { CititorComponent } from './cititor/cititor.component';
import { AddCititorComponent } from './cititor/add-cititor/add-cititor.component';
import { EditCititorComponent } from './cititor/edit-cititor/edit-cititor.component';
import { SelectDatabaseComponent } from './select-database/select-database.component';
import {ImprumutComponent} from "./imprumut/imprumut.component";
import {EditImprumutComponent} from "./imprumut/edit-imprumut/edit-imprumut.component";
import {AddImprumutComponent} from "./imprumut/add-imprumut/add-imprumut.component";
import {BibliotecarComponent} from "./bibliotecar/bibliotecar.component";
import {AddBibliotecarComponent} from "./bibliotecar/add-bibliotecar/add-bibliotecar.component";
import {EditBibliotecarComponent} from "./bibliotecar/edit-bibliotecar/edit-bibliotecar.component";
import { LegitimatieComponent } from './legitimatie/legitimatie.component';
import { AddLegitimatieComponent } from './legitimatie/add-legitimatie/add-legitimatie.component';

@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    EditBookComponent,
    AddBookComponent,
    ImprumutComponent,
    EditImprumutComponent,
    AddImprumutComponent,
    NavbarComponent,
    AutorComponent,
    AddAutorComponent,
    EditAutorComponent,
    BibliotecarComponent,
    AddBibliotecarComponent,
    EditBibliotecarComponent,
    CititorComponent,
    AddCititorComponent,
    EditCititorComponent,
    SelectDatabaseComponent,
    LegitimatieComponent,
    AddLegitimatieComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MatSliderModule,
    MatToolbarModule,
    MatDialogModule,
    ApiModule,
    // make sure to import the HttpClientModule in the AppModule only,
    // see https://github.com/angular/angular/issues/20575
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    MatTableModule,
    MatInputModule,
  ],
  providers: [
    {provide: MAT_DIALOG_DEFAULT_OPTIONS, useValue: {hasBackdrop: false}}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
