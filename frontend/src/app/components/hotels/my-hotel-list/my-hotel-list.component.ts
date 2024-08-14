import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { HotelService } from '../../../services/hotel/hotel.service';
import { AuthService } from '../../../services/auth/auth.service';
import { LayoutComponent } from '../../layout/layout.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-hotel-list',
  standalone: true,
  imports: [
    CommonModule,
    LayoutComponent],
  templateUrl: './my-hotel-list.component.html',
  styleUrl: './my-hotel-list.component.scss'
})
export class MyHotelListComponent implements OnInit {
  hotels: any[] = [];
  userId: number | null = null;

  constructor(private hotelService: HotelService, private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.userId = this.authService.getUserIdFromToken();
    if (this.userId !== null) {
      this.hotelService.getAllHotels().subscribe(
        (data) => {
          this.hotels = data.filter((hotel: any) => hotel.userId === this.userId);
        },
        (error) => {
          console.error('Hata:', error);
        }
      );
    } else {
      console.error('Kullanıcı ID bulunamadı.');
    }
  }

  addHotelAddress(hotelId: number): void {
    this.router.navigate(['/hotelmanagment/addhoteladdress', { hotelId }]);
  }
  addHotelImages(hotelId: number): void {
    this.router.navigate(['/hotelmanagment/addhotelimages', { hotelId }]);
  }
  addRoom(hotelId: number): void {
    this.router.navigate(['/hotelmanagment/addroom', { hotelId }]);
  }
  addHotelDetails(hotelId: number): void {
    this.router.navigate(['/hotelmanagment/hoteldetails', { hotelId }]);
  }

  viewReservations(hotelId: number): void {
    this.router.navigate(['/hotelreservationlist'], { queryParams: { hotelId } });
  }

  updateHotel(hotelId: number): void {
    this.router.navigate(['/updatehotel'], { queryParams: { hotelId } });
  }
}
