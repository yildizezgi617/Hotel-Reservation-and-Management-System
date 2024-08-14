import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelImagesComponent } from './hotel-images.component';

describe('HotelImagesComponent', () => {
  let component: HotelImagesComponent;
  let fixture: ComponentFixture<HotelImagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HotelImagesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HotelImagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
