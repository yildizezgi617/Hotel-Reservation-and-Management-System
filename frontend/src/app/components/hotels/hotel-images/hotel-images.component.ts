import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { HotelImageService } from '../../../services/hotel/hotel-image.service';

@Component({
  selector: 'app-hotel-images',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './hotel-images.component.html',
  styleUrl: './hotel-images.component.scss'
})
export class HotelImageComponent implements OnInit {
  hotelId: number | null = null;
  imageForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private hotelImageService: HotelImageService
  ) {
    this.imageForm = this.fb.group({
      image: [null]
    });
  }

  ngOnInit(): void {
    this.hotelId = Number(this.route.snapshot.paramMap.get('hotelId'));
    if (!this.hotelId) {
      console.error('Hotel ID bulunamadı.');
      this.router.navigate(['/hotelmanagment/myhotellist']);
    }
  }

  onFileSelect(event: any): void {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.imageForm.get('image')?.setValue(file);
    }
  }

  onSubmit(): void {
    if (this.imageForm.valid) {
      const formData = new FormData();
      formData.append('file', this.imageForm.get('image')?.value);

      this.hotelImageService.uploadHotelImage(this.hotelId!, formData).subscribe(
        response => {
          console.log('', response);
        },
        error => {
          console.error('Resim yükleme hatası', error);
        }
      );
    }
  }
}