import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelAddressComponent } from './hotel-address.component';

describe('HotelAddressComponent', () => {
  let component: HotelAddressComponent;
  let fixture: ComponentFixture<HotelAddressComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HotelAddressComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HotelAddressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
