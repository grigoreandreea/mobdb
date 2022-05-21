import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCititorComponent } from './edit-cititor.component';

describe('EditCititorComponent', () => {
  let component: EditCititorComponent;
  let fixture: ComponentFixture<EditCititorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditCititorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditCititorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
