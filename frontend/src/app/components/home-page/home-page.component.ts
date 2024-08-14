import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { LayoutComponent } from '../layout/layout.component';
import { CitySliderComponent } from '../city-slider/city-slider.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
import { MatNativeDateModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { RoomService } from '../../services/room/room.service';
import { AvailableRoomsComponent } from '../room/available-rooms/available-rooms.component';
import { Router, RouterLink } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [
    CommonModule,
    LayoutComponent,
    CitySliderComponent,
    MatDatepickerModule,
    MatInputModule,
    MatNativeDateModule,
    MatFormFieldModule,
    AvailableRoomsComponent,
    RouterLink,
    ReactiveFormsModule
  ],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.scss'
})
export class HomePageComponent implements OnInit {
  searchForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router
  ) {
    this.searchForm = this.fb.group({
      location: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      roomType: [''],
      capacity: ['']
    });
  }

  ngOnInit(): void {
  }

  formatDate(date: string): string {
    const dateObj = new Date(date);
    const year = dateObj.getFullYear();
    const month = (dateObj.getMonth() + 1).toString().padStart(2, '0');
    const day = dateObj.getDate().toString().padStart(2, '0');
    return `${year}-${month}-${day}`;
  }

  onSearch(): void {
    const { location, startDate, endDate, roomType, capacity } = this.searchForm.value;
    const formattedStartDate = this.formatDate(startDate);
    const formattedEndDate = this.formatDate(endDate);

    this.router.navigate(['/availableroomslist'], {
      queryParams: {
        enteranceDay: formattedStartDate,
        releaseDay: formattedEndDate,
        roomType: roomType,
        capacity: capacity,
        location: location
      }
    });
  }
}