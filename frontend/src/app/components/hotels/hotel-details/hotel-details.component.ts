import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HotelService } from '../../../services/hotel/hotel.service';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from '../../layout/layout.component';

@Component({
  selector: 'app-hotel-details',
  standalone: true,
  imports: [CommonModule,
  ],
  templateUrl: './hotel-details.component.html',
  styleUrl: './hotel-details.component.scss'
})
export class HotelDetailsComponent implements OnInit {
  hotelId: number | null = null;
  hotel: any;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private hotelService: HotelService
  ) { }

  ngOnInit(): void {
    this.hotelId = Number(this.route.snapshot.paramMap.get('hotelId'));
    if (this.hotelId) {
      this.hotelService.getAllHotels().subscribe(
        data => {
          this.hotel = data.find((hotel: any) => hotel.id === this.hotelId);
          if (!this.hotel) {
            console.error('Hotel bulunamadı.');
            this.router.navigate(['/hotelmanagment']);
          }
        },
        error => {
          console.error('Hata:', error);
        }
      );
    } else {
      console.error('Hotel ID bulunamadı.');
      this.router.navigate(['/hotelmanagment']);
    }
  }

  updateRoom(roomId: number, hotelId: number): void {
    this.router.navigate(['/roomupdate'], { queryParams: { roomId, hotelId } });
  }

  viewFeedbacks(hotelId: number): void {
    this.router.navigate(['/feedbacklist'], { queryParams: { hotelId } });
  }
}