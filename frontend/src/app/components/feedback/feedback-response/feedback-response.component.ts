import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { LayoutComponent } from '../../layout/layout.component';
import { ActivatedRoute, Router } from '@angular/router';
import { HotelService } from '../../../services/hotel/hotel.service';

@Component({
  selector: 'app-feedback-response',
  standalone: true,
  imports: [CommonModule,
    ReactiveFormsModule,
    LayoutComponent
  ],
  templateUrl: './feedback-response.component.html',
  styleUrl: './feedback-response.component.scss'
})
export class FeedbackResponseComponent implements OnInit {
  feedbackId: number | null = null;
  responseForm: FormGroup;
  message: string | null = null;
  errorMessage: string | null = null;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private hotelService: HotelService
  ) {
    this.responseForm = this.fb.group({
      description: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.feedbackId = +params['feedbackId'];
      if (!this.feedbackId) {
        this.errorMessage = 'Feedback ID not found in query parameters';
        this.router.navigate(['/hotelmanagment/hoteldetails']);
      }
    });
  }

  onSubmit(): void {
    if (this.responseForm.valid && this.feedbackId !== null) {
      const description = this.responseForm.get('description')?.value;
      this.hotelService.addResponseToFeedback(this.feedbackId, description).subscribe(
        response => {
          this.message = 'Yorum başarıyla yanıtlandı.';
          setTimeout(() => {
            this.router.navigate(['/hotelmanagment/hoteldetails']);
          }, 2000);
        },
        error => {
          this.errorMessage = 'Yorum yanıtlanırken bir hata oluştu.';
          console.error('Error responding to feedback:', error);
        }
      );
    }
  }
}
