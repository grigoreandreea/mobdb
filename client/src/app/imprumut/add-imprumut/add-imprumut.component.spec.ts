import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddImprumutComponent } from './add-imprumut.component';

describe('AddImprumutComponent', () => {
  let component: AddImprumutComponent;
  let fixture: ComponentFixture<AddImprumutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddImprumutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddImprumutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
