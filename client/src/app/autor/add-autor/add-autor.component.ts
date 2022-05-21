import { Component, OnInit } from '@angular/core';
import {AUTORITEM, DefaultService} from "../../swagger-generated";
import {MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, Validators} from "@angular/forms";
import {transformCamelCaseKeysToUnderscore} from "../../swagger-generated/api/helpers";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-add-autor',
  templateUrl: './add-autor.component.html',
  styleUrls: ['./add-autor.component.scss']
})
export class AddAutorComponent implements OnInit {

  public addAutorForm: any;

  constructor(
    private defaultService: DefaultService,
    public dialogRef: MatDialogRef<AddAutorComponent>,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.addAutorForm = this.formBuilder.group({
      codAutor: [null, [Validators.required]],
      nume: [null, [Validators.required]],
      prenume: [null, Validators.required],
      dataN: [null, Validators.required]
    });
  }

  addAutor() {
    const params: any = {
      codAutor: this.addAutorForm?.get('codAutor')?.value,
      nume: this.addAutorForm?.get('nume')?.value,
      prenume: this.addAutorForm?.get('prenume')?.value,
      dataN: this.addAutorForm?.get('dataN')?.value,
    };
    const parsedParams = transformCamelCaseKeysToUnderscore(params);
    this.defaultService
      .autorPost(parsedParams)
      .subscribe({
        next: (data) => {
          this.onAddAutorSuccess(params);
        },
        error: (error) => {
          this.onAddAutorFail(error);
        }
      });
  }

  public onAddAutorSuccess(data: AUTORITEM) {
    this.closeBtnClick(data);
  }
  public onAddAutorFail(error: HttpErrorResponse) {
    this.closeBtnClick();
  }
  public closeBtnClick(data: AUTORITEM | null = null) {
    this.dialogRef.close(data);
  }
}
