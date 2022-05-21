import { Component, OnInit } from '@angular/core';
import {AUTORITEM, DefaultService} from "../../swagger-generated";
import {MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, Validators} from "@angular/forms";
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
      cod_autor: [null, [Validators.required]],
      data_n: [null, Validators.required]
    });
  }

  addAutor() {
    const params: any = {
      cod_autor: this.addAutorForm?.get('cod_autor')?.value,
      nume: this.addAutorForm?.get('nume')?.value,
      prenume: this.addAutorForm?.get('prenume')?.value,
      data_n: this.addAutorForm?.get('data_n')?.value,
    };
    this.defaultService
      .autorPost(params)
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
