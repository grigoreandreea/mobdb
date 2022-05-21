import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLegitimatieComponent } from './add-legitimatie.component';

describe('AddLegitimatieComponent', () => {
  let component: AddLegitimatieComponent;
  let fixture: ComponentFixture<AddLegitimatieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddLegitimatieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddLegitimatieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
