import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditBibliotecarComponent } from './edit-bibliotecar.component';

describe('EditBibliotecarComponent', () => {
  let component: EditBibliotecarComponent;
  let fixture: ComponentFixture<EditBibliotecarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditBibliotecarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditBibliotecarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
