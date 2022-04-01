import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindABackyardComponent } from './find-abackyard.component';

describe('FindABackyardComponent', () => {
  let component: FindABackyardComponent;
  let fixture: ComponentFixture<FindABackyardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindABackyardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FindABackyardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
