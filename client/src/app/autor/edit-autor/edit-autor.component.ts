import {Component, Input, OnInit} from '@angular/core';
import {AUTORITEM, DefaultService} from "../../swagger-generated";
import {MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, Validators} from "@angular/forms";
import {transformCamelCaseKeysToUnderscore} from "../../swagger-generated/api/helpers";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-edit-autor',
  templateUrl: './edit-autor.component.html',
  styleUrls: ['./edit-autor.component.scss']
})
export class EditAutorComponent implements OnInit {
  @Input() selectedAutorDetails: AUTORITEM = {
    codAutor: 0,
    nume: '',
    prenume: '',
    // dataN: '0000-00-00 00:00:00'
  };
  public editAutorForm: any;

  constructor(
    private defaultService: DefaultService,
    public dialogRef: MatDialogRef<EditAutorComponent>,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.editAutorForm = this.formBuilder.group({
      nume: [null, Validators.required],
      prenume: [null, Validators.required],
      dataN: [null, Validators.required]
    });

    if (this.selectedAutorDetails) {
      this.editAutorForm?.patchValue({
        nume: this.selectedAutorDetails.nume,
        prenume: this.selectedAutorDetails.prenume,
        dataN: this.selectedAutorDetails.dataN
      });
    }
  }

  editAutor() {
    const params: any = {
      nume: this.editAutorForm?.get('nume')?.value,
      prenume: this.editAutorForm?.get('prenume')?.value,
      dataN: this.editAutorForm?.get('dataN')?.value,
    };
    const parsedParams = transformCamelCaseKeysToUnderscore(params);
    this.defaultService
      .autorIdPut('' + this.selectedAutorDetails?.codAutor, parsedParams)
      .subscribe({
        next: (data) => {
          this.onEditAutorSuccess(params);
        },
        error: (error) => {
          this.onEditAutorFail(error);
        }
      });
  }

  public onEditAutorSuccess(data: AUTORITEM) {
    this.closeBtnClick(data);
  }
  public onEditAutorFail(error: HttpErrorResponse) {
    this.closeBtnClick();
  }
  public closeBtnClick(data: AUTORITEM | null = null) {
    this.dialogRef.close(data);
  }

}
