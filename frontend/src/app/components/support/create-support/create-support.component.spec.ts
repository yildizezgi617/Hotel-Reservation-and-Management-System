import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSupportComponent } from './create-support.component';

describe('CreateSupportComponent', () => {
  let component: CreateSupportComponent;
  let fixture: ComponentFixture<CreateSupportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateSupportComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateSupportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
