import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodSortComponent } from './food-sort.component';

describe('FoodSortComponent', () => {
  let component: FoodSortComponent;
  let fixture: ComponentFixture<FoodSortComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoodSortComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodSortComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
