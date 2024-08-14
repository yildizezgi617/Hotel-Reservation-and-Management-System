import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CitySliderComponent } from './city-slider.component';

describe('CitySliderComponent', () => {
  let component: CitySliderComponent;
  let fixture: ComponentFixture<CitySliderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CitySliderComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CitySliderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
