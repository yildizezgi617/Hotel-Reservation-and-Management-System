import { Component, OnInit } from '@angular/core';
import { LayoutComponent } from '../../layout/layout.component';
import { ActivatedRoute, Router } from '@angular/router';
import { HotelService } from '../../../services/hotel/hotel.service';
import { CommonEngine } from '@angular/ssr';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-hotel-feedbacks',
  standalone: true,
  imports: [LayoutComponent, CommonModule
  ],
  templateUrl: './hotel-feedbacks.component.html',
  styleUrl: './hotel-feedbacks.component.scss'
})
export class HotelFeedbacksComponent implements OnInit {
  hotelId: number | null = null;
  feedbacks: any[] = [];
  message: string | null = null;
  errorMessage: string | null = null;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private feedbackService: HotelService
  ) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.hotelId = +params['hotelId'];
      if (this.hotelId) {
        this.fetchFeedbacks(this.hotelId);
      } else {
        this.errorMessage = 'Hotel ID not found in query parameters';
      }
    });
  }

  fetchFeedbacks(hotelId: number): void {
    this.feedbackService.getFeedbacksByHotelId(hotelId).subscribe(
      data => {
        this.feedbacks = data;
        if (data.length === 0) {
          this.message = 'Bu otel için henüz yorum bulunmamaktadır.';
        }
      },
      error => {
        this.errorMessage = 'Yorumlar yüklenirken bir hata oluştu';
        console.error('Error fetching feedbacks:', error);
      }
    );
  }

  answerFeedback(feedbackId: number): void {
    this.router.navigate(['/addfeedbackresponse'], { queryParams: { feedbackId } });
  }

}
