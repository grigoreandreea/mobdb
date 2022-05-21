import { Component, OnInit } from '@angular/core';
import {CARTEITEM, DefaultService} from "../../swagger-generated";
import {MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, Validators} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.scss']
})
export class AddBookComponent implements OnInit {

  public addBookForm: any;

  constructor(
    private defaultService: DefaultService,
    public dialogRef: MatDialogRef<AddBookComponent>,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.addBookForm = this.formBuilder.group({
      cod_carte: [null, [Validators.required]],
      cod_subcategorie: [null, [Validators.required]],
      titlu: [null, Validators.required],
      nr_exemplare: [null, Validators.required]
    });
  }

  addBook() {
    const params: any = {
      cod_carte: this.addBookForm?.get('cod_carte')?.value,
      cod_subcategorie: this.addBookForm?.get('cod_subcategorie')?.value,
      titlu: this.addBookForm?.get('titlu')?.value,
      nr_exemplare: this.addBookForm?.get('nr_exemplare')?.value,
    };
    this.defaultService
      .cartePost(params)
      .subscribe({
        next: (data) => {
          this.onAddBookSuccess(params);
        },
        error: (error) => {
          this.onAddBookFail(error);
        }
      });
  }

  public onAddBookSuccess(data: CARTEITEM) {
    this.closeBtnClick(data);
  }
  public onAddBookFail(error: HttpErrorResponse) {
    this.closeBtnClick();
  }
  public closeBtnClick(data: CARTEITEM | null = null) {
    this.dialogRef.close(data);
  }

}
