import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BackyardClickedComponent } from './backyard-clicked.component';

describe('BackyardClickedComponent', () => {
  let component: BackyardClickedComponent;
  let fixture: ComponentFixture<BackyardClickedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BackyardClickedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BackyardClickedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
