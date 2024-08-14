import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HotelService } from '../../../services/hotel/hotel.service';
import { ActivatedRoute, Router } from '@angular/router';
import { LayoutComponent } from '../../layout/layout.component';
import { CityService } from '../../../services/city-district/city.service';
import { DistrictService } from '../../../services/city-district/district.service';

@Component({
  selector: 'app-hotel-address',
  standalone: true,
  imports: [
    LayoutComponent,
    ReactiveFormsModule,
    CommonModule
  ],
  templateUrl: './hotel-address.component.html',
  styleUrl: './hotel-address.component.scss'
})
export class HotelAddressComponent implements OnInit {
  hotelAddressForm: FormGroup;
  hotelId: number | null = null;
  message: string | null = null;  // Mesaj değişkeni
  cities: any[] = [];
  districts: any[] = [];
  errorMessage: string | null = null;  // Mesaj değişkeni

  constructor(
    private fb: FormBuilder,
    private hotelService: HotelService,
    private route: ActivatedRoute,
    private router: Router,
    private cityService: CityService,
    private districtService: DistrictService,
  ) {
    this.hotelAddressForm = this.fb.group({
      hotelId: ['', Validators.required],
      cityId: ['', Validators.required],
      districtId: ['', Validators.required],
      addressText: ['', [Validators.required, Validators.minLength(10)]]
    });
  }

  ngOnInit(): void {
    this.hotelId = Number(this.route.snapshot.paramMap.get('hotelId'));
    if (this.hotelId) {
      this.hotelAddressForm.patchValue({ hotelId: this.hotelId });
    } else {
      console.error('Hotel ID bulunamadı.');
      this.router.navigate(['/myhotellist']);
    }
    //Şehirleri Getirdik
    this.cityService.getAllCities().subscribe(
      data => {
        this.cities = data;
      },
      error => {
        console.error('Şehirler yüklenirken bir hata oluştu', error);
      }
    );

    //Şehir id'sine bağlı ilçeleri getirdik
    this.hotelAddressForm.get('cityId')?.valueChanges.subscribe(cityId => {
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
    if (this.hotelAddressForm.valid) {
      this.hotelService.addHotelAddress(this.hotelAddressForm.value).subscribe(
        response => {
          this.message = 'Adres Başarıyla Eklendi.';
          console.log('Adres başarıyla eklendi', response);
          setTimeout(() => {
            this.message = null;  // Mesajı belirli bir süre sonra temizle
            this.router.navigate(['/myhotellist']);
          }, 3000);
        },
        error => {
          console.error('Adres ekleme hatası:', error);
          this.errorMessage = ('Adres Eklenirken Bir Hata Oluştu ')
        }
      );
    }
  }
}