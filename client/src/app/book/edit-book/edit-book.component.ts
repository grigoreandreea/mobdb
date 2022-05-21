import {Component, Input, OnInit} from '@angular/core';
import {CARTEITEM, DefaultService} from "../../swagger-generated";
import {FormBuilder, Validators} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";
import {MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.scss']
})
export class EditBookComponent implements OnInit {

  @Input() selectedBookDetails: CARTEITEM = {
    cod_carte: 0,
    cod_subcategorie: 0,
    nr_exemplare: 0,
    titlu: ''
  };
  public editBookForm: any;

  constructor(
    private defaultService: DefaultService,
    public dialogRef: MatDialogRef<EditBookComponent>,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.editBookForm = this.formBuilder.group({
      cod_subcategorie: [null, [Validators.required]],
      titlu: [null, Validators.required],
      nr_exemplare: [null, Validators.required]
    });

    if (this.selectedBookDetails) {
      this.editBookForm?.patchValue({
        cod_subcategorie: this.selectedBookDetails.cod_subcategorie,
        titlu: this.selectedBookDetails.titlu,
        nr_exemplare: this.selectedBookDetails.nr_exemplare,
      });
    }
  }

  editBook() {
    const params: any = {
      cod_subcategorie: this.editBookForm?.get('cod_subcategorie')?.value,
      titlu: this.editBookForm?.get('titlu')?.value,
      nr_exemplare: this.editBookForm?.get('nr_exemplare')?.value,
    };
    this.defaultService
      .carteIdPut('' + this.selectedBookDetails?.cod_carte, params)
      .subscribe({
        next: (data) => {
          this.onEditBookSuccess(params);
        },
        error: (error) => {
          this.onEditBookFail(error);
        }
      });
  }

  public onEditBookSuccess(data: CARTEITEM) {
    this.closeBtnClick(data);
  }
  public onEditBookFail(error: HttpErrorResponse) {
    this.closeBtnClick();
  }
  public closeBtnClick(data: CARTEITEM | null = null) {
    this.dialogRef.close(data);
  }

}
