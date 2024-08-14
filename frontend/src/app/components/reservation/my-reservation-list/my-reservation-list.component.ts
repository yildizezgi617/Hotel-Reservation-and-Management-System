import { Component, OnInit } from '@angular/core';
import { ReservationService } from '../../../services/reservation/reservation.service';
import { AuthService } from '../../../services/auth/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from '../../layout/layout.component';

@Component({
  selector: 'app-my-reservation-list',
  standalone: true,
  imports: [CommonModule,
    LayoutComponent
  ],
  templateUrl: './my-reservation-list.component.html',
  styleUrl: './my-reservation-list.component.scss'
})
export class MyReservationListComponent implements OnInit {
  reservations: any[] = [];
  guestInformations: { [key: number]: any[] } = {}; // reservationId'ye göre guest information verilerini tutar
  userId: number | null = null;

  constructor(
    private router: Router,
    private reservationService: ReservationService,
    private authService: AuthService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.userId = this.authService.getUserIdFromToken();
    if (this.userId !== null) {
      this.fetchReservations(this.userId);
    } else {
      console.error('User ID not found in token');
    }
  }

  fetchReservations(userId: number): void {
    this.reservationService.getReservationsByUserId(userId).subscribe(
      (data: any[]) => {
        this.reservations = data;
      },
      (error) => {
        console.error('Error fetching reservations:', error);
      }
    );
  }

  fetchGuestInformations(reservationId: number): void {
    if (!this.guestInformations[reservationId]) { // Sadece veriler daha önce çekilmediyse API çağrısı yap
      this.reservationService.getGuestsByReservationId(reservationId).subscribe(
        (data: any[]) => {
          this.guestInformations[reservationId] = data;
        },
        (error) => {
          console.error('Error fetching guest informations:', error);
        }
      );
    }
  }
  addFeedback(reservationId: number): void {
    this.router.navigate(['/addfeedback'], { queryParams: { reservationId } });
  }
}
