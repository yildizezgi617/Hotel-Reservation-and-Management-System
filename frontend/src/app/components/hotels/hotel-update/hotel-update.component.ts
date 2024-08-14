import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { LayoutComponent } from '../../layout/layout.component';
import { ActivatedRoute, Router } from '@angular/router';
import { HotelService } from '../../../services/hotel/hotel.service';

@Component({
  selector: 'app-hotel-update',
  standalone: true,
  imports: [CommonModule,
    ReactiveFormsModule,
    LayoutComponent
  ],
  templateUrl: './hotel-update.component.html',
  styleUrl: './hotel-update.component.scss'
})
export class HotelUpdateComponent implements OnInit {
  hotelForm: FormGroup;
  hotelId: number | null = null;
  message: string | null = null;
  errorMessage: string | null = null;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private hotelService: HotelService
  ) {
    this.hotelForm = this.fb.group({
      id: ['', [Validators.required]],
      name: ['', [Validators.required]],
      phoneNumber: ['', [Validators.required, Validators.pattern('\\d+')]],
      hotelStar: ['', [Validators.required, Validators.min(1), Validators.max(5)]]
    });
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.hotelId = +params['hotelId'];
      if (this.hotelId) {
        this.hotelForm.patchValue({ id: this.hotelId });
      } else {
        console.error('Hotel ID not found in query parameters');
        this.router.navigate(['/hotelmanagment']);
      }
    });
  }

  onSubmit(): void {
    if (this.hotelForm.valid) {
      this.hotelService.updateHotel(this.hotelForm.value).subscribe(
        response => {
          this.message = 'Hotel başarıyla güncellendi.';
          setTimeout(() => {
            this.message = null;
            this.router.navigate(['/hotelmanagment']);
          }, 2000);
        },
        error => {
          this.errorMessage = 'Hotel güncellenirken hata oluştu.';
          setTimeout(() => {
            this.errorMessage = null;
          }, 2000);
        }
      );
    }
  }
}
