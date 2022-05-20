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
      codSubcategorie: [null, [Validators.required]],
      titlu: [null, Validators.required],
      nrExemplare: [null, Validators.required]
    });
  }

  addBook() {
    const params: any = {
      codSubcategorie: this.addBookForm?.get('codSubcategorie')?.value,
      titlu: this.addBookForm?.get('titlu')?.value,
      nrExemplare: this.addBookForm?.get('nrExemplare')?.value,
    };
    this.defaultService
      .cartePost(this.addBookForm)
      .subscribe({
        next: (data) => {
          this.onAddBookSuccess(this.addBookForm);
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
