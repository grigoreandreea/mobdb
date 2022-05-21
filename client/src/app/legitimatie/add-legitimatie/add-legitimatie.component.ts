import { Component, OnInit } from '@angular/core';
import {LEGITIMATIEITEM, DefaultService} from "../../swagger-generated";
import {MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, Validators} from "@angular/forms";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-add-legitimatie',
  templateUrl: './add-legitimatie.component.html',
  styleUrls: ['./add-legitimatie.component.scss']
})
export class AddLegitimatieComponent implements OnInit {

  public addLegitimatieForm: any;

  constructor(
    private defaultService: DefaultService,
    public dialogRef: MatDialogRef<AddLegitimatieComponent>,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.addLegitimatieForm = this.formBuilder.group({
      serie_legitimatie: [null, [Validators.required]],
      data_expirare: [null, Validators.required]
    });
  }

  addLegitimatie() {
    const params: any = {
      serie_legitimatie: this.addLegitimatieForm?.get('serie_legitimatie')?.value,
      data_expirare: this.addLegitimatieForm?.get('data_expirare')?.value,
    };
    this.defaultService
      .legitimatiePost(params)
      .subscribe({
        next: (data) => {
          this.onAddLegitimatieSuccess(params);
        },
        error: (error) => {
          this.onAddLegitimatieFail(error);
        }
      });
  }

  public onAddLegitimatieSuccess(data: LEGITIMATIEITEM) {
    this.closeBtnClick(data);
  }
  public onAddLegitimatieFail(error: HttpErrorResponse) {
    this.closeBtnClick();
  }
  public closeBtnClick(data: LEGITIMATIEITEM | null = null) {
    this.dialogRef.close(data);
  }
}
