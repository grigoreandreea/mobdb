import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CititorComponent } from './cititor.component';

describe('CititorComponent', () => {
  let component: CititorComponent;
  let fixture: ComponentFixture<CititorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CititorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CititorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
