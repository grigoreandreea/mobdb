import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCititorComponent } from './add-cititor.component';

describe('AddCititorComponent', () => {
  let component: AddCititorComponent;
  let fixture: ComponentFixture<AddCititorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCititorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCititorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
