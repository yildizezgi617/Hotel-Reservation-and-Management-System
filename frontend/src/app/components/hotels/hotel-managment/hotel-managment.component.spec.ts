import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelManagmentComponent } from './hotel-managment.component';

describe('HotelManagmentComponent', () => {
  let component: HotelManagmentComponent;
  let fixture: ComponentFixture<HotelManagmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HotelManagmentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HotelManagmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
