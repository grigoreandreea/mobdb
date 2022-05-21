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
      serie_legitimatie: [this.makeid(10), [Validators.required]],
      data_expirare: [this.defaultService.DEFAULT_DATE, Validators.required]
    });
  }
  
  makeid(length) {
    var result           = '';
    var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    var charactersLength = characters.length;
    for ( var i = 0; i < length; i++ ) {
      result += characters.charAt(Math.floor(Math.random() * 
 charactersLength));
   }
   return result;
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
