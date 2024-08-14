import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedbackListForUsersComponent } from './feedback-list-for-users.component';

describe('FeedbackListForUsersComponent', () => {
  let component: FeedbackListForUsersComponent;
  let fixture: ComponentFixture<FeedbackListForUsersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FeedbackListForUsersComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FeedbackListForUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
