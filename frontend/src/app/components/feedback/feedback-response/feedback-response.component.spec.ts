import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedbackResponseComponent } from './feedback-response.component';

describe('FeedbackResponseComponent', () => {
  let component: FeedbackResponseComponent;
  let fixture: ComponentFixture<FeedbackResponseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FeedbackResponseComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FeedbackResponseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
