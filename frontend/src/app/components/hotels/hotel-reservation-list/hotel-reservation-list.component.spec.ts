import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelReservationListComponent } from './hotel-reservation-list.component';

describe('HotelReservationListComponent', () => {
  let component: HotelReservationListComponent;
  let fixture: ComponentFixture<HotelReservationListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HotelReservationListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HotelReservationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
