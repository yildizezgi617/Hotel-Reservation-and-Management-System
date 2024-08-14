import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { LayoutComponent } from '../../layout/layout.component';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationService } from '../../../services/reservation/reservation.service';

@Component({
  selector: 'app-update-reservation',
  standalone: true,
  imports: [CommonModule,
    ReactiveFormsModule,
    LayoutComponent
  ],
  templateUrl: './update-reservation.component.html',
  styleUrl: './update-reservation.component.scss'
})
export class UpdateReservationComponent implements OnInit {
  reservationForm: FormGroup;
  reservationId: number | null = null;
  message: string | null = null;
  errorMessage: string | null = null;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private reservationService: ReservationService
  ) {
    this.reservationForm = this.fb.group({
      id: ['', [Validators.required]],
      reservationStatus: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.reservationId = +params['reservationId'];
      if (this.reservationId) {
        this.reservationForm.patchValue({ id: this.reservationId });
      } else {
        console.error('Reservation ID not found in query parameters');
        this.router.navigate(['/hotelmanagment/myhotellist']);
      }
    });
  }

  onSubmit(): void {
    if (this.reservationForm.valid) {
      this.reservationService.updateReservationStatus(this.reservationForm.value).subscribe(
        response => {
          this.message = 'Rezervasyon durumu başarıyla güncellendi.';
          setTimeout(() => {
            this.router.navigate(['/hotelmanagment/myhotellist']);
          }, 2000);
        },
        error => {
          this.errorMessage = 'Rezervasyon durumu güncellenirken bir hata oluştu.';
          console.error('Error updating reservation status:', error);
        }
      );
    }
  }
}
