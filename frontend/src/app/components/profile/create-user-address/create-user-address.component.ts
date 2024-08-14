import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { LayoutComponent } from '../../layout/layout.component';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../../services/auth/auth.service';
import { UserService } from '../../../services/user/user.service';
import { CityService } from '../../../services/city-district/city.service';
import { DistrictService } from '../../../services/city-district/district.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-user-address',
  standalone: true,
  imports: [LayoutComponent,
    CommonModule, ReactiveFormsModule
  ],
  templateUrl: './create-user-address.component.html',
  styleUrl: './create-user-address.component.scss'
})
export class CreateUserAddressComponent implements OnInit {
  addressForm: FormGroup;
  userId: number | null = null;
  cities: any[] = [];
  districts: any[] = [];
  message: string | null = null;
  errorMessage: string | null = null;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private userService: UserService,
    private cityService: CityService,
    private districtService: DistrictService,
    private router: Router
  ) {
    this.addressForm = this.fb.group({
      addressText: ['', [Validators.required]],
      cityId: ['', [Validators.required]],
      districtId: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
    this.userId = this.authService.getUserIdFromToken();

    if (!this.userId) {
      console.error('User ID not found in token');
      this.router.navigate(['/profile']);
      return;
    }

    this.cityService.getAllCities().subscribe(
      data => {
        this.cities = data;
      },
      error => {
        console.error('Error fetching cities', error);
      }
    );

    this.addressForm.get('cityId')?.valueChanges.subscribe(cityId => {
      this.districtService.getDistrictsByCity(cityId).subscribe(
        data => {
          this.districts = data;
        },
        error => {
          console.error('Error fetching districts', error);
        }
      );
    });
  }

  onSubmit(): void {
    if (this.addressForm.valid && this.userId) {
      const addressData = {
        userId: this.userId,
        ...this.addressForm.value
      };

      this.userService.addUserAddress(addressData).subscribe(
        response => {
          console.log('Address added successfully:', response);
          this.router.navigate(['/profile']);
        },
        error => {
          console.error('Error adding address:', error);
        }
      );
    }
  }
}