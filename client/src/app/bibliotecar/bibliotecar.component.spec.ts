import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BibliotecarComponent } from './bibliotecar.component';

describe('BibliotecarComponent', () => {
  let component: BibliotecarComponent;
  let fixture: ComponentFixture<BibliotecarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BibliotecarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BibliotecarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
