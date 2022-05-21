import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImprumutComponent } from './imprumut.component';

describe('ImprumutComponent', () => {
  let component: ImprumutComponent;
  let fixture: ComponentFixture<ImprumutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImprumutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImprumutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
