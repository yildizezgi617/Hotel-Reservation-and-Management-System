import { CommonModule } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RoomService } from '../../../services/room/room.service';
import { LayoutComponent } from '../../layout/layout.component';
import { AuthService } from '../../../services/auth/auth.service';

@Component({
  selector: 'app-available-rooms',
  standalone: true,
  imports: [CommonModule,
    LayoutComponent
  ],
  templateUrl: './available-rooms.component.html',
  styleUrl: './available-rooms.component.scss'
})
export class AvailableRoomsComponent implements OnInit {
  availableRooms: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private roomService: RoomService,
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      const enteranceDay = params['enteranceDay'];
      const releaseDay = params['releaseDay'];
      const roomType = params['roomType'];
      const capacity = params['capacity'];
      const location = params['location'];

      this.roomService.findAvailableRooms(enteranceDay, releaseDay, roomType, capacity, location).subscribe(
        data => {
          this.availableRooms = data;
        },
        error => {
          console.error('Error:', error);
        }
      );
    });
  }

  createReservation(roomId: number): void {
    if (this.authService.isLoggedIn()) {
      this.router.navigate(['/createreservation'], {
        queryParams: {
          roomId: roomId,
          enteranceDay: this.route.snapshot.queryParams['enteranceDay'],
          releaseDay: this.route.snapshot.queryParams['releaseDay'],
          roomType: this.route.snapshot.queryParams['roomType'],
          capacity: this.route.snapshot.queryParams['capacity'],
          location: this.route.snapshot.queryParams['location'],
        }
      });
    } else {
      this.router.navigate(['/login']);
    }
  }

  getFeedbackList(hotelId: number): void {
    this.router.navigate(['/feedbackforusers'], { queryParams: { hotelId } });
  }

}