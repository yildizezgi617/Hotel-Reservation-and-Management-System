import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { RoomService } from '../../services/room/room.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-room',
  standalone: true,
  imports: [ReactiveFormsModule,
    CommonModule
  ],
  templateUrl: './room.component.html',
  styleUrl: './room.component.scss'
})
export class RoomComponent implements OnInit {
  roomForm: FormGroup;
  hotelId: number | null = null;
  message: string | null = null;
  errorMessage: string | null = null;
  roomStatuses = Object.values(RoomStatus);  // Enum değerlerini burada alıyoruz

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private roomService: RoomService,
  ) {
    this.roomForm = this.fb.group({
      hotelId: ['', Validators.required],
      roomType: ['', Validators.required],
      capacity: ['', [Validators.required, Validators.min(1), Validators.max(8)]],
      price: ['', [Validators.required]],
      roomStatus: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.hotelId = Number(this.route.snapshot.paramMap.get('hotelId'));
    if (this.hotelId) {
      this.roomForm.patchValue({ hotelId: this.hotelId });
    } else {
      console.error('Hotel ID bulunamadı.');
      this.router.navigate(['/myhotellist']);
    }
  }

  onSubmit(): void {
    if (this.roomForm.valid) {
      this.roomService.addRoom(this.roomForm.value).subscribe(
        response => {
          this.message = 'Oda başarıyla eklendi.';
        },
        error => {
          this.errorMessage = 'Oda ekleme hatası: ';
        }
      );
    }
  }
}

enum RoomStatus {
  AVAILABLE = 'AVAILABLE',
  NOTAVAILABLE = 'NOTAVAILABLE'
}