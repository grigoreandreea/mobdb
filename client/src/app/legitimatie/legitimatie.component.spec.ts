import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LegitimatieComponent } from './legitimatie.component';

describe('LegitimatieComponent', () => {
  let component: LegitimatieComponent;
  let fixture: ComponentFixture<LegitimatieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LegitimatieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LegitimatieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
