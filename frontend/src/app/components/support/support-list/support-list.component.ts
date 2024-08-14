import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SupportService } from '../../../services/support/support.service';

@Component({
  selector: 'app-support-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './support-list.component.html',
  styleUrl: './support-list.component.scss'
})
export class SupportListComponent implements OnInit {
  userId: number | null = null;
  supportRequests: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private supportService: SupportService
  ) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.userId = +params['userId'] || null;
      if (this.userId !== null) {
        this.loadSupportRequests();
      }
    });
  }

  loadSupportRequests(): void {
    if (this.userId !== null) {
      this.supportService.getSupportRequestsByUserId(this.userId).subscribe(
        data => {
          this.supportRequests = data;
        },
        error => {
          console.error('Error loading support requests', error);
        }
      );
    }
  }
}