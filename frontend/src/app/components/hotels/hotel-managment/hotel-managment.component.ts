import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { LayoutComponent } from '../../layout/layout.component';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-hotel-managment',
  standalone: true,
  imports: [
    CommonModule,
    LayoutComponent,
    RouterLink,
    RouterOutlet
  ],
  templateUrl: './hotel-managment.component.html',
  styleUrl: './hotel-managment.component.scss'
})
export class HotelManagmentComponent {

}
