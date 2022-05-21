import {Component, Input, OnInit} from '@angular/core';
import {IMPRUMUTAITEM, DefaultService, DATE} from "../../swagger-generated";
import {FormBuilder, Validators} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";
import {MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-edit-imprumut',
  templateUrl: './edit-imprumut.component.html',
  styleUrls: ['./edit-imprumut.component.scss']
})
export class EditImprumutComponent implements OnInit {

  @Input() selectedImprumutDetails: IMPRUMUTAITEM = {
    cod_carte: 0,
    cod_cititor: 0,
    data_imprumut: new Date(),
    termen_limita: new Date(),
    data_restituire: new Date(),
  };
  public editImprumutForm: any;

  constructor(
    private defaultService: DefaultService,
    public dialogRef: MatDialogRef<EditImprumutComponent>,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.editImprumutForm = this.formBuilder.group({
      cod_carte: [null, [Validators.required]],
      cod_cititor: [null, [Validators.required]],
      data_imprumut: [null, [Validators.required]],
      termen_limita: [null, [Validators.required]],
      data_restituire: [null, [Validators.required]],
    });

    if (this.selectedImprumutDetails) {
      this.editImprumutForm?.patchValue({
        cod_carte: this.selectedImprumutDetails.cod_carte,
        cod_cititor: this.selectedImprumutDetails.cod_cititor,
        data_imprumut: this.selectedImprumutDetails.data_imprumut,
        termen_limita: this.selectedImprumutDetails.termen_limita,
        data_restituire: this.selectedImprumutDetails.data_restituire,
      });
    }
  }

  editImprumut() {
    const params: any = {
      cod_carte: this.editImprumutForm?.get('cod_carte')?.value,
      cod_cititor: this.editImprumutForm?.get('cod_cititor')?.value,
      data_imprumut: this.editImprumutForm?.get('data_imprumut')?.value,
      termen_limita: this.editImprumutForm?.get('termen_limita')?.value,
      data_restituire: this.editImprumutForm?.get('data_restituire')?.value,
    };
    this.defaultService
      .imprumutaIdPut('' + this.selectedImprumutDetails?.cod_carte, params)
      .subscribe({
        next: (data) => {
          this.onEditImprumutSuccess(params);
        },
        error: (error) => {
          this.onEditImprumutFail(error);
        }
      });
  }

  public onEditImprumutSuccess(data: IMPRUMUTAITEM) {
    this.closeBtnClick(data);
  }
  public onEditImprumutFail(error: HttpErrorResponse) {
    this.closeBtnClick();
  }
  public closeBtnClick(data: IMPRUMUTAITEM | null = null) {
    this.dialogRef.close(data);
  }

}
