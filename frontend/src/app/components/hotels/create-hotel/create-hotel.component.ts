import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HotelService } from '../../../services/hotel/hotel.service';
import { AuthService } from '../../../services/auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-hotel',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CommonModule
  ],
  templateUrl: './create-hotel.component.html',
  styleUrl: './create-hotel.component.scss'
})
export class CreateHotelComponent implements OnInit {
  hotelForm: FormGroup;
  userId: number | null = null;
  message: string | null = null;  // Mesaj değişkeni
  errorMessage: string | null = null;  // Mesaj değişkeni

  constructor(
    private fb: FormBuilder,
    private hotelService: HotelService,
    private authService: AuthService,
    private router: Router
  ) {
    this.hotelForm = this.fb.group({
      userId: ['', Validators.required],
      name: ['', Validators.required],
      description: ['', Validators.required],
      phoneNumber: ['', [Validators.required, Validators.pattern('\\d+')]],
      hotelStar: ['', [Validators.required, Validators.min(1), Validators.max(5)]]
    });
  }

  ngOnInit(): void {
    this.userId = this.authService.getUserIdFromToken();
    if (this.userId) {
      this.hotelForm.patchValue({ userId: this.userId });
    } else {
      this.router.navigate(['/login']);
    }
  }

  onSubmit(): void {
    if (this.hotelForm.valid) {
      this.hotelService.addHotel(this.hotelForm.value).subscribe(
        response => {
          this.message = 'Otel başarıyla oluşturuldu.';  // Mesajı güncelle
          setTimeout(() => {
            this.message = null;  // Mesajı belirli bir süre sonra temizle
            this.router.navigate(['/hotelmanagment/myhotellist']);
          }, 2000);  // Mesaj 3 saniye sonra kaybolur ve yönlendirilir
        },
        error => {
          console.error('Otel ekleme hatası:', error);
          this.errorMessage = 'Otel Eklenemedi';
          setTimeout(() => {
            this.errorMessage = null;
          }, 2000);  // 2000 milisaniye = 2 saniye // Hata mesajını güncelle
        }
      );
    }
  }
}
