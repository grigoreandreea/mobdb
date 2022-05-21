import { Component, OnInit } from '@angular/core';
import {CITITORITEM, DefaultService} from "../../swagger-generated";
import {MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, Validators} from "@angular/forms";
import {transformCamelCaseKeysToUnderscore} from "../../swagger-generated/api/helpers";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-add-cititor',
  templateUrl: './add-cititor.component.html',
  styleUrls: ['./add-cititor.component.scss']
})
export class AddCititorComponent implements OnInit {

  public addCititorForm: any;

  constructor(
    private defaultService: DefaultService,
    public dialogRef: MatDialogRef<AddCititorComponent>,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.addCititorForm = this.formBuilder.group({
      serieLegitimatie: [null, Validators.required],
      nume: [null, Validators.required],
      prenume: [null, Validators.required],
      dataN: [null, Validators.required],
      gen: [null, Validators.required],
      strNr: [null, Validators.required],
      localitate: [null, Validators.required],
      email: [null, Validators.required]
    });
  }

  addCititor() {
    const params: any = {
      codAutor: this.addCititorForm?.get('codCititor')?.value,
      serieLegitimatie: this.addCititorForm?.get('serieLegitimatie')?.value,
      nume: this.addCititorForm?.get('nume')?.value,
      prenume: this.addCititorForm?.get('prenume')?.value,
      dataN: this.addCititorForm?.get('dataN')?.value,
      srtNr: this.addCititorForm?.get('srtNr')?.value,
      localitate: this.addCititorForm?.get('localitate')?.value,
      email: this.addCititorForm?.get('email')?.value
    };
    const parsedParams = transformCamelCaseKeysToUnderscore(params);
    this.defaultService
      .cititorPost(parsedParams)
      .subscribe({
        next: (data) => {
          this.onAddCititorSuccess(params);
        },
        error: (error) => {
          this.onAddCititorFail(error);
        }
      });
  }

  public onAddCititorSuccess(data: CITITORITEM) {
    this.closeBtnClick(data);
  }
  public onAddCititorFail(error: HttpErrorResponse) {
    this.closeBtnClick();
  }
  public closeBtnClick(data: CITITORITEM | null = null) {
    this.dialogRef.close(data);
  }

}
