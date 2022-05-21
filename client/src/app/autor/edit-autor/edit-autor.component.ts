import {Component, Input, OnInit} from '@angular/core';
import {AUTORITEM, DefaultService} from "../../swagger-generated";
import {MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, Validators} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-edit-autor',
  templateUrl: './edit-autor.component.html',
  styleUrls: ['./edit-autor.component.scss']
})
export class EditAutorComponent implements OnInit {
  @Input() selectedAutorDetails: AUTORITEM = {
    cod_autor: 0,
    nume: '',
    prenume: '',
    // data_n: '0000-00-00 00:00:00'
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
      data_n: [null, Validators.required]
    });

    if (this.selectedAutorDetails) {
      this.editAutorForm?.patchValue({
        nume: this.selectedAutorDetails.nume,
        prenume: this.selectedAutorDetails.prenume,
        data_n: this.selectedAutorDetails.data_n
      });
    }
  }

  editAutor() {
    const params: any = {
      nume: this.editAutorForm?.get('nume')?.value,
      prenume: this.editAutorForm?.get('prenume')?.value,
      data_n: this.editAutorForm?.get('data_n')?.value,
    };
    this.defaultService
      .autorIdPut('' + this.selectedAutorDetails?.cod_autor, params)
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
