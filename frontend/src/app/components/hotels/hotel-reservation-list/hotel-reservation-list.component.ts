import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HotelService } from '../../../services/hotel/hotel.service';
import { LayoutComponent } from '../../layout/layout.component';
import { CommonEngine } from '@angular/ssr';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-hotel-reservation-list',
  standalone: true,
  imports: [LayoutComponent,
    CommonModule
  ],
  templateUrl: './hotel-reservation-list.component.html',
  styleUrl: './hotel-reservation-list.component.scss'
})
export class HotelReservationListComponent implements OnInit {
  reservations: any[] = [];
  hotelId: number | null = null;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private hotelService: HotelService
  ) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.hotelId = +params['hotelId'];
      if (this.hotelId) {
        this.fetchReservations(this.hotelId);
      } else {
        console.error('Hotel ID not found in query parameters');
      }
    });
  }

  fetchReservations(hotelId: number): void {
    this.hotelService.getReservationsByHotelId(hotelId).subscribe(
      (data: any[]) => {
        this.reservations = data;
      },
      (error) => {
        console.error('Error fetching reservations:', error);
      }
    );
  }

  updateReservationStatus(reservationId: number): void {
    this.router.navigate(['/updatereservation'], { queryParams: { reservationId } });
  }
}
