import { Component, OnInit } from '@angular/core';
import { LayoutComponent } from '../../layout/layout.component';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../../services/auth/auth.service';
import { UserService } from '../../../services/user/user.service';
import { CityService } from '../../../services/city-district/city.service';
import { DistrictService } from '../../../services/city-district/district.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-address-update',
  standalone: true,
  imports: [LayoutComponent,
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './address-update.component.html',
  styleUrl: './address-update.component.scss'
})
export class AddressUpdateComponent implements OnInit {
  addressForm: FormGroup;
  userId: number | null = null;
  addressId: number | null = null;
  cities: any[] = [];
  districts: any[] = [];
  message: string | null = null;
  errorMessage: string | null = null;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private userAddressService: UserService,
    private cityService: CityService,
    private districtService: DistrictService,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.addressForm = this.fb.group({
      addressText: ['', [Validators.required]],
      cityId: ['', [Validators.required]],
      districtId: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
    //this.userId = this.authService.getUserIdFromToken();
    this.route.queryParams.subscribe(params => {
      this.addressId = +params['id'];
      if (this.addressId) {
        this.addressForm.patchValue({ id: this.addressId });
      } else {
        console.error('Address ID not found in query parameters');
        this.router.navigate(['/profile']);
      }
    });

    this.cityService.getAllCities().subscribe(
      data => {
        this.cities = data;
      },
      error => {
        console.error('Şehirler yüklenirken bir hata oluştu', error);
      }
    );

    this.addressForm.get('cityId')?.valueChanges.subscribe(cityId => {
      this.districtService.getDistrictsByCity(cityId).subscribe(
        data => {
          this.districts = data;
        },
        error => {
          console.error('İlçeler yüklenirken bir hata oluştu', error);
        }
      );
    });
  }

  onSubmit(): void {
    if (this.addressForm.valid) {
      const districtId = this.addressForm.get('districtId')?.value;
      console.log('District ID:', districtId);

      const updateUserAddressRequest = {
        id: this.addressId,
        addressText: this.addressForm.get('addressText')?.value,
        district: districtId
      };

      this.userAddressService.updateUserAddress(updateUserAddressRequest).subscribe(
        response => {
          this.message = 'Adres başarıyla güncellendi';  // Mesajı güncelle
          console.log('Adres başarıyla güncellendi:', response);
          setTimeout(() => {
            this.message = null;  // Mesajı belirli bir süre sonra temizle
            this.router.navigate(['/profile']);
          }, 2000);  // Mesaj 3 saniye sonra kaybolur ve yönlendirilir
        },
        error => {
          this.errorMessage = 'Adres Güncellenemedi';
          console.error('Adres güncellenirken hata:', error);
        }
      );
    }
  }
}