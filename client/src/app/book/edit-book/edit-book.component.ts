import {Component, Input, OnInit} from '@angular/core';
import {CARTEITEM, DefaultService} from "../../swagger-generated";
import {FormBuilder, Validators} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";
import {MatDialogRef} from "@angular/material/dialog";
import {transformCamelCaseKeysToUnderscore} from "../../swagger-generated/api/helpers";

@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.scss']
})
export class EditBookComponent implements OnInit {

  @Input() selectedBookDetails: CARTEITEM = {
    codCarte: 0,
    codSubcategorie: 0,
    nrExemplare: 0,
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
      codSubcategorie: [null, [Validators.required]],
      titlu: [null, Validators.required],
      nrExemplare: [null, Validators.required]
    });

    if (this.selectedBookDetails) {
      this.editBookForm?.patchValue({
        codSubcategorie: this.selectedBookDetails.codSubcategorie,
        titlu: this.selectedBookDetails.titlu,
        nrExemplare: this.selectedBookDetails.nrExemplare,
      });
    }
  }

  editBook() {
    const params: any = {
      codCarte: this.selectedBookDetails.codCarte,
      codSubcategorie: this.editBookForm?.get('codSubcategorie')?.value,
      titlu: this.editBookForm?.get('titlu')?.value,
      nrExemplare: this.editBookForm?.get('nrExemplare')?.value,
    };
    const parsedParams = transformCamelCaseKeysToUnderscore(params);
    this.defaultService
      .carteIdPut('' + this.selectedBookDetails?.codCarte, parsedParams)
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
