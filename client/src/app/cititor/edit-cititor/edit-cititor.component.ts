import {Component, Input, OnInit} from '@angular/core';
import {CITITORITEM, DefaultService} from "../../swagger-generated";
import {MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, Validators} from "@angular/forms";
import {transformCamelCaseKeysToUnderscore} from "../../swagger-generated/api/helpers";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-edit-cititor',
  templateUrl: './edit-cititor.component.html',
  styleUrls: ['./edit-cititor.component.scss']
})
export class EditCititorComponent implements OnInit {

  @Input() selectedCititorDetails: CITITORITEM = {
    codCititor: 0,
    serieLegitimatie: '',
    nume: '',
    prenume: '',
    gen: '',
    // dataN: '0000-00-00 00:00:00',
    strNr: '',
    localitate: '',
    email: ''
  };
  public editCititorForm: any;

  constructor(
    private defaultService: DefaultService,
    public dialogRef: MatDialogRef<EditCititorComponent>,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.editCititorForm = this.formBuilder.group({
      serieLegitimatie: [null, Validators.required],
      nume: [null, Validators.required],
      prenume: [null, Validators.required],
      dataN: [null, Validators.required],
      gen: [null, Validators.required],
      strNr: [null, Validators.required],
      localitate: [null, Validators.required],
      email: [null, Validators.required]
    });

    if (this.selectedCititorDetails) {
      this.editCititorForm?.patchValue({
        serieLegitimatie: this.selectedCititorDetails.serieLegitimatie,
        nume: this.selectedCititorDetails.nume,
        prenume: this.selectedCititorDetails.prenume,
        gen: this.selectedCititorDetails.gen,
        dataN: this.selectedCititorDetails.dataN,
        srtNr: this.selectedCititorDetails.strNr,
        localitate: this.selectedCititorDetails.localitate,
        email: this.selectedCititorDetails.email
      });
    }
  }

  editCititor() {
    const params: any = {
      serieLegitimatie: this.editCititorForm?.get('serieLegitimatie')?.value,
      nume: this.editCititorForm?.get('nume')?.value,
      prenume: this.editCititorForm?.get('prenume')?.value,
      gen: this.editCititorForm?.get('gen')?.value,
      dataN: this.editCititorForm?.get('dataN')?.value,
      srtNr: this.editCititorForm?.get('srtNr')?.value,
      localitate: this.editCititorForm?.get('localitate')?.value,
      email: this.editCititorForm?.get('email')?.value
    };
    const parsedParams = transformCamelCaseKeysToUnderscore(params);
    this.defaultService
      .cititorIdPut('' + this.selectedCititorDetails?.codCititor, parsedParams)
      .subscribe({
        next: (data) => {
          this.onEditCititorSuccess(params);
        },
        error: (error) => {
          this.onEditCititorFail(error);
        }
      });
  }

  public onEditCititorSuccess(data: CITITORITEM) {
    this.closeBtnClick(data);
  }
  public onEditCititorFail(error: HttpErrorResponse) {
    this.closeBtnClick();
  }
  public closeBtnClick(data: CITITORITEM | null = null) {
    this.dialogRef.close(data);
  }

}
