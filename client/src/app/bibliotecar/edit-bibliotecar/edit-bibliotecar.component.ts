import {Component, Input, OnInit} from '@angular/core';
import {BIBLIOTECARITEM, DefaultService} from "../../swagger-generated";
import {MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, Validators} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-edit-bibliotecar',
  templateUrl: './edit-bibliotecar.component.html',
  styleUrls: ['./edit-bibliotecar.component.scss']
})
export class EditBibliotecarComponent implements OnInit {
  @Input() selectedBibliotecarDetails: BIBLIOTECARITEM = {
    cod_bibliotecar: 0,
    nume: '',
    prenume: '',
  };
  public editBibliotecarForm: any;

  constructor(
    private defaultService: DefaultService,
    public dialogRef: MatDialogRef<EditBibliotecarComponent>,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.editBibliotecarForm = this.formBuilder.group({
      nume: [null, [Validators.required]],
      prenume: [null, Validators.required],
      gen: [null, Validators.required],
      data_n: [null, Validators.required],
      str_nr: [null, Validators.required],
      localitate: [null, Validators.required],
    });

    if (this.selectedBibliotecarDetails) {
      this.editBibliotecarForm?.patchValue({
        nume: this.selectedBibliotecarDetails.nume,
        prenume: this.selectedBibliotecarDetails.prenume,
        gen: this.selectedBibliotecarDetails.gen,
        data_n: this.selectedBibliotecarDetails.data_n,
        str_nr: this.selectedBibliotecarDetails.str_nr,
        localitate: this.selectedBibliotecarDetails.localitate
      });
    }
  }

  editBibliotecar() {
    const params: any = {
      nume: this.editBibliotecarForm?.get('nume')?.value,
      prenume: this.editBibliotecarForm?.get('prenume')?.value,
      gen: this.editBibliotecarForm?.get('gen')?.value,
      data_n: this.editBibliotecarForm?.get('data_n')?.value,
      str_nr: this.editBibliotecarForm?.get('str_nr')?.value,
      localitate: this.editBibliotecarForm?.get('localitate')?.value,
    };
    this.defaultService
      .bibliotecarIdPut('' + this.selectedBibliotecarDetails?.cod_bibliotecar, params)
      .subscribe({
        next: (data) => {
          this.onEditBibliotecarSuccess(params);
        },
        error: (error) => {
          this.onEditBibliotecarFail(error);
        }
      });
  }

  public onEditBibliotecarSuccess(data: BIBLIOTECARITEM) {
    this.closeBtnClick(data);
  }
  public onEditBibliotecarFail(error: HttpErrorResponse) {
    this.closeBtnClick();
  }
  public closeBtnClick(data: BIBLIOTECARITEM | null = null) {
    this.dialogRef.close(data);
  }

}
