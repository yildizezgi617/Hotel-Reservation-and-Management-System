import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationService } from '../../../services/reservation/reservation.service';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from '../../layout/layout.component';

@Component({
  selector: 'app-reservation-details',
  standalone: true,
  imports: [CommonModule,
    LayoutComponent
  ],
  templateUrl: './reservation-details.component.html',
  styleUrl: './reservation-details.component.scss'
})
export class ReservationDetailsComponent implements OnInit {
  reservationDetails: any;
  guestInformations: any[] = [];
  reservationId: number | null = null;

  constructor(
    private route: ActivatedRoute,
    private reservationService: ReservationService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.reservationId = +params['reservationId'];

      if (this.reservationId) {
        this.fetchReservationDetails();
        this.fetchGuestInformations();
      } else {
        console.error('Rezervasyon ID parametrelerde bulunamadı');
      }
    });
  }

  fetchReservationDetails(): void {
    if (this.reservationId !== null) {
      this.reservationService.getReservationDetails(this.reservationId).subscribe(
        data => {
          this.reservationDetails = data;
        },
        error => {
          console.error('Rezervasyon detayları alınırken hata:', error);
        }
      );
    }
  }

  fetchGuestInformations(): void {
    if (this.reservationId !== null) {
      this.reservationService.getGuestsByReservationId(this.reservationId).subscribe(
        data => {
          this.guestInformations = data;
        },
        error => {
          console.error('Misafir bilgileri alınırken hata:', error);
        }
      );
    }
  }

  redirectToHome(): void {
    this.router.navigate(['/']);
  }
}