import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatereReservationComponent } from './createre-reservation.component';

describe('CreatereReservationComponent', () => {
  let component: CreatereReservationComponent;
  let fixture: ComponentFixture<CreatereReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreatereReservationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreatereReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
