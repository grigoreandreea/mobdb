import { Component, OnInit } from '@angular/core';
import {BIBLIOTECARITEM, DefaultService} from "../../swagger-generated";
import {MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, Validators} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-add-bibliotecar',
  templateUrl: './add-bibliotecar.component.html',
  styleUrls: ['./add-bibliotecar.component.scss']
})
export class AddBibliotecarComponent implements OnInit {

  public addBibliotecarForm: any;

  constructor(
    private defaultService: DefaultService,
    public dialogRef: MatDialogRef<AddBibliotecarComponent>,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.addBibliotecarForm = this.formBuilder.group({
      cod_bibliotecar: [null, [Validators.required]],
      nume: [null, [Validators.required]],
      prenume: [null, Validators.required],
      gen: [null, Validators.required],
      data_n: [this.defaultService.DEFAULT_DATE, Validators.required],
      str_nr: [null, Validators.required],
      localitate: [null, Validators.required],
    });
  }

  addBibliotecar() {
    const params: any = {
      cod_bibliotecar: this.addBibliotecarForm?.get('cod_bibliotecar')?.value,
      nume: this.addBibliotecarForm?.get('nume')?.value,
      prenume: this.addBibliotecarForm?.get('prenume')?.value,
      gen: this.addBibliotecarForm?.get('gen')?.value,
      data_n: this.addBibliotecarForm?.get('data_n')?.value,
      str_nr: this.addBibliotecarForm?.get('str_nr')?.value,
      localitate: this.addBibliotecarForm?.get('localitate')?.value,
    };
    this.defaultService
      .bibliotecarPost(params)
      .subscribe({
        next: (data) => {
          this.onAddBibliotecarSuccess(params);
        },
        error: (error) => {
          this.onAddBibliotecarFail(error);
        }
      });
  }

  public onAddBibliotecarSuccess(data: BIBLIOTECARITEM) {
    this.closeBtnClick(data);
  }
  public onAddBibliotecarFail(error: HttpErrorResponse) {
    this.closeBtnClick();
  }
  public closeBtnClick(data: BIBLIOTECARITEM | null = null) {
    this.dialogRef.close(data);
  }
}
