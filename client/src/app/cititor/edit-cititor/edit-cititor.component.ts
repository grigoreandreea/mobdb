import {Component, Input, OnInit} from '@angular/core';
import {CITITORITEM, DefaultService} from "../../swagger-generated";
import {MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, Validators} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-edit-cititor',
  templateUrl: './edit-cititor.component.html',
  styleUrls: ['./edit-cititor.component.scss']
})
export class EditCititorComponent implements OnInit {

  @Input() selectedCititorDetails: CITITORITEM = {
    cod_cititor: 0,
    serie_legitimatie: '',
    nume: '',
    prenume: '',
    gen: '',
    // data_n: '0000-00-00 00:00:00',
    str_nr: '',
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
      serie_legitimatie: [null, Validators.required],
      nume: [null, Validators.required],
      prenume: [null, Validators.required],
      data_n: [null, Validators.required],
      gen: [null, Validators.required],
      str_nr: [null, Validators.required],
      localitate: [null, Validators.required],
      email: [null, Validators.required]
    });

    if (this.selectedCititorDetails) {
      this.editCititorForm?.patchValue({
        serie_legitimatie: this.selectedCititorDetails.serie_legitimatie,
        nume: this.selectedCititorDetails.nume,
        prenume: this.selectedCititorDetails.prenume,
        gen: this.selectedCititorDetails.gen,
        data_n: this.selectedCititorDetails.data_n,
        str_nr: this.selectedCititorDetails.str_nr,
        localitate: this.selectedCititorDetails.localitate,
        email: this.selectedCititorDetails.email
      });
    }
  }

  editCititor() {
    const params: any = {
      serie_legitimatie: this.editCititorForm?.get('serie_legitimatie')?.value,
      nume: this.editCititorForm?.get('nume')?.value,
      prenume: this.editCititorForm?.get('prenume')?.value,
      gen: this.editCititorForm?.get('gen')?.value,
      data_n: this.editCititorForm?.get('data_n')?.value,
      str_nr: this.editCititorForm?.get('str_nr')?.value,
      localitate: this.editCititorForm?.get('localitate')?.value,
      email: this.editCititorForm?.get('email')?.value
    };
    this.defaultService
      .cititorIdPut('' + this.selectedCititorDetails?.cod_cititor, params)
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
