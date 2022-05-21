import { Component, OnInit } from '@angular/core';
import {IMPRUMUTAITEM, DefaultService} from "../../swagger-generated";
import {MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, Validators} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-add-imprumut',
  templateUrl: './add-imprumut.component.html',
  styleUrls: ['./add-imprumut.component.scss']
})
export class AddImprumutComponent implements OnInit {

  public addImprumutForm: any;

  constructor(
    private defaultService: DefaultService,
    public dialogRef: MatDialogRef<AddImprumutComponent>,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.addImprumutForm = this.formBuilder.group({
      cod_carte: [null, [Validators.required]],
      cod_cititor: [null, [Validators.required]],
      data_imprumut: [null, [Validators.required]],
      termen_limita: [null, [Validators.required]],
      data_restituire: [null, [Validators.required]],
    });
  }

  addImprumut() {
    const params: any = {
      cod_carte: this.addImprumutForm?.get('cod_carte')?.value,
      cod_cititor: this.addImprumutForm?.get('cod_cititor')?.value,
      data_imprumut: this.addImprumutForm?.get('data_imprumut')?.value,
      termen_limita: this.addImprumutForm?.get('termen_limita')?.value,
      data_restituire: this.addImprumutForm?.get('data_restituire')?.value,
    };
    this.defaultService
      .imprumutaPost(params)
      .subscribe({
        next: (data) => {
          this.onAddImprumutSuccess(params);
        },
        error: (error) => {
          this.onAddImprumutFail(error);
        }
      });
  }

  public onAddImprumutSuccess(data: IMPRUMUTAITEM) {
    this.closeBtnClick(data);
  }
  public onAddImprumutFail(error: HttpErrorResponse) {
    this.closeBtnClick();
  }
  public closeBtnClick(data: IMPRUMUTAITEM | null = null) {
    this.dialogRef.close(data);
  }

}
