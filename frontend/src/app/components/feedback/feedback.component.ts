import { Component, OnInit } from '@angular/core';
import { LayoutComponent } from '../layout/layout.component';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../../services/user/user.service';
import { AuthService } from '../../services/auth/auth.service';

@Component({
  selector: 'app-feedback',
  standalone: true,
  imports: [LayoutComponent,
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './feedback.component.html',
  styleUrl: './feedback.component.scss'
})
export class FeedbackComponent implements OnInit {
  feedbackForm: FormGroup;
  reservationId: number | null = null;
  userId: number | null = null;
  message: string | null = null;
  errorMessage: string | null = null;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService,
    private authService: AuthService
  ) {
    this.feedbackForm = this.fb.group({
      rating: ['', [Validators.required, Validators.min(1), Validators.max(5)]],
      comment: ['', [Validators.required, Validators.maxLength(500)]]
    });
  }

  ngOnInit(): void {
    this.userId = this.authService.getUserIdFromToken(); // UserId'yi token'dan alıyoruz
    this.route.queryParams.subscribe(params => {
      this.reservationId = +params['reservationId'];
      if (!this.reservationId) {
        console.error('Reservation ID not found in query parameters');
        this.router.navigate(['/myreservations']); // Redirect if no reservation ID
      }
    });
  }

  onSubmit(): void {
    if (this.feedbackForm.valid && this.reservationId !== null) {
      const feedbackData = {
        reservationId: this.reservationId,
        ...this.feedbackForm.value
      };

      this.userService.addFeedback(feedbackData).subscribe(
        response => {
          this.message = 'Feedback başarıyla gönderildi.';
          setTimeout(() => {
            this.message = null;
            this.router.navigate(['/myreservationlist'], { queryParams: { userId: this.userId } }); // UserId'yi query parametre olarak gönderiyoruz
          }, 3000); // Mesajı 3 saniye sonra temizle ve yönlendir
        },
        error => {
          this.errorMessage = 'Feedback gönderilirken bir hata oluştu.';
          setTimeout(() => {
            this.errorMessage = null;
          }, 3000); // Hata mesajını 3 saniye sonra temizle
        }
      );
    }
  }
}
