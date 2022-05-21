import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditImprumutComponent } from './edit-imprumut.component';

describe('EditImprumutComponent', () => {
  let component: EditImprumutComponent;
  let fixture: ComponentFixture<EditImprumutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditImprumutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditImprumutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
