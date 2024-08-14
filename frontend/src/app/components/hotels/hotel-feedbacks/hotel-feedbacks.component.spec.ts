import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelFeedbacksComponent } from './hotel-feedbacks.component';

describe('HotelFeedbacksComponent', () => {
  let component: HotelFeedbacksComponent;
  let fixture: ComponentFixture<HotelFeedbacksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HotelFeedbacksComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HotelFeedbacksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
