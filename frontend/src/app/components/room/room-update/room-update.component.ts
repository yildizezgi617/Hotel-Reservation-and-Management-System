import { Component, OnInit } from '@angular/core';
import { LayoutComponent } from '../../layout/layout.component';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { RoomService } from '../../../services/room/room.service';

@Component({
  selector: 'app-room-update',
  standalone: true,
  imports: [LayoutComponent,
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './room-update.component.html',
  styleUrl: './room-update.component.scss'
})
export class RoomUpdateComponent implements OnInit {
  roomForm: FormGroup;
  roomId: number | null = null;
  roomStatuses = ['AVAILABLE', 'NOTAVAILABLE'];
  message: string | null = null;  // Mesaj değişkeni
  errorMessage: string | null = null;  // Mesaj değişkeni
  hotelId: number | null = null;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private roomService: RoomService,
    private router: Router
  ) {
    this.roomForm = this.fb.group({
      id: ['', Validators.required],
      roomType: ['', [Validators.required, Validators.minLength(3)]],
      capacity: ['', [Validators.required, Validators.min(1), Validators.max(8)]],
      price: ['', Validators.required],
      roomStatus: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.roomId = +params['roomId'];
      this.hotelId = +params['hotelId'];
      if (this.roomId && this.hotelId) {
        this.roomForm.patchValue({ id: this.roomId });
      } else {
        if (!this.roomId) {
          console.error('Room ID not found in query parameters');
        }
        if (!this.hotelId) {
          console.error('Hotel ID not found in query parameters');
        }
      }
    });
  }

  onSubmit(): void {
    if (this.roomForm.valid) {
      const updateRoomRequest = this.roomForm.value;
      this.roomService.updateRoom(updateRoomRequest).subscribe(
        response => {
          this.message = 'Oda başarıyla güncellendi.';  // Mesajı güncelle
          setTimeout(() => {
            this.message = null;  // Mesajı belirli bir süre sonra temizle
            this.router.navigate(['/hotelmanagment/myhotellist']);
          }, 2000);  // Mesaj 3 saniye sonra kaybolur ve yönlendirilir
          console.log('Room updated successfully', response);
        },
        error => {
          this.errorMessage = 'Oda Güncellenemedi';
          setTimeout(() => {
            this.errorMessage = null;
          }, 2000);  // 2000 milisaniye = 2 saniye // Hata mesajını güncelle
          console.error('Error updating room', error);
        }
      );
    }
  }
}