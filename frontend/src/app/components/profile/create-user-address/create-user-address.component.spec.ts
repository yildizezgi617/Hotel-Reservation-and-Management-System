import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateUserAddressComponent } from './create-user-address.component';

describe('CreateUserAddressComponent', () => {
  let component: CreateUserAddressComponent;
  let fixture: ComponentFixture<CreateUserAddressComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateUserAddressComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateUserAddressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
