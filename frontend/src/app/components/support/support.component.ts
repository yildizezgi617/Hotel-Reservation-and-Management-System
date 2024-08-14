import { Component } from '@angular/core';
import { LayoutComponent } from '../layout/layout.component';
import { CommonModule } from '@angular/common';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { AuthService } from '../../services/auth/auth.service';
import { SupportListComponent } from './support-list/support-list.component';

@Component({
  selector: 'app-support',
  standalone: true,
  imports: [LayoutComponent,
    CommonModule,
    RouterOutlet,
    RouterLink,
    SupportListComponent
  ],
  templateUrl: './support.component.html',
  styleUrl: './support.component.scss'
})
export class SupportComponent {
  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  navigateToSupportList(): void {
    const userId = this.authService.getUserIdFromToken();
    if (userId !== null) {
      this.router.navigate(['/support/supportlist'], { queryParams: { userId: userId } });
    } else {
      console.error('User ID not found in token');
    }
  }
}