import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationService } from '../../../services/reservation/reservation.service';
import { AuthService } from '../../../services/auth/auth.service';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from '../../layout/layout.component';

@Component({
  selector: 'app-createre-reservation',
  standalone: true,
  imports: [CommonModule, LayoutComponent],
  templateUrl: './createre-reservation.component.html',
  styleUrl: './createre-reservation.component.scss'
})
export class CreatereReservationComponent implements OnInit {
  roomId: number = 0;
  enteranceDay: string = '';
  releaseDay: string = '';
  userId: number | null = null;
  roomType: string = '';
  capacity: number = 0;
  location: string = '';


  constructor(
    private route: ActivatedRoute,
    private reservationService: ReservationService,
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.userId = this.authService.getUserIdFromToken();
    this.route.queryParams.subscribe(params => {
      this.roomId = +params['roomId'];
      this.enteranceDay = params['enteranceDay'];
      this.releaseDay = params['releaseDay'];
      this.roomType = params['roomType'];
      this.capacity = +params['capacity'];
      this.location = params['location'];
    });
  }

  createReservation(): void {
    const reservationRequest = {
      userId: this.userId,
      roomId: this.roomId,
      enteranceDay: this.enteranceDay,
      releaseDay: this.releaseDay
    };

    this.reservationService.createReservation(reservationRequest).subscribe(
      (response: any) => {
        const reservationId = response.id; // Rezervasyon ID'sini al
        this.router.navigate(['/confirmreservation'], {
          queryParams: {
            reservationId: reservationId,
            roomId: this.roomId,
            enteranceDay: this.enteranceDay,
            releaseDay: this.releaseDay
          }
        });
      },
      error => {
        console.error('Rezervasyon oluşturulurken hata:', error);
      }
    );
  }
}
