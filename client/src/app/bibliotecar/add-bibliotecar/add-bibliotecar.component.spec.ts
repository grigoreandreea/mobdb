import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddBibliotecarComponent } from './add-bibliotecar.component';

describe('AddBibliotecarComponent', () => {
  let component: AddBibliotecarComponent;
  let fixture: ComponentFixture<AddBibliotecarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddBibliotecarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddBibliotecarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
