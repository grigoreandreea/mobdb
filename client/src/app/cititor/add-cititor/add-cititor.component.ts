import { Component, OnInit } from '@angular/core';
import {CITITORITEM, DefaultService} from "../../swagger-generated";
import {MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, Validators} from "@angular/forms";
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
      cod_cititor: [null, Validators.required],
      serie_legitimatie: [null, Validators.required],
      nume: [null, Validators.required],
      prenume: [null, Validators.required],
      data_n: [null, Validators.required],
      gen: [null, Validators.required],
      str_nr: [null, Validators.required],
      localitate: [null, Validators.required],
      email: [null, Validators.required]
    });
  }

  addCititor() {
    const params: any = {
      cod_cititor: this.addCititorForm?.get('cod_cititor')?.value,
      serie_legitimatie: this.addCititorForm?.get('serie_legitimatie')?.value,
      nume: this.addCititorForm?.get('nume')?.value,
      prenume: this.addCititorForm?.get('prenume')?.value,
      gen: this.addCititorForm?.get('gen')?.value,
      data_n: this.addCititorForm?.get('data_n')?.value,
      str_nr: this.addCititorForm?.get('str_nr')?.value,
      localitate: this.addCititorForm?.get('localitate')?.value,
      email: this.addCititorForm?.get('email')?.value
    };
    this.defaultService
      .cititorPost(params)
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
