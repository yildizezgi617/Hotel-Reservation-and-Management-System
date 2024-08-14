import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { SupportService } from '../../../services/support/support.service';
import { AuthService } from '../../../services/auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-support',
  standalone: true,
  imports: [ReactiveFormsModule,
    CommonModule
  ],
  templateUrl: './create-support.component.html',
  styleUrl: './create-support.component.scss'
})
export class CreateSupportComponent implements OnInit {
  supportForm: FormGroup;
  userId: number | null = null;
  message: string | null = null;  // Mesaj değişkeni
  errorMessage: string | null = null;  // Mesaj değişkeni

  constructor(
    private fb: FormBuilder,
    private supportService: SupportService,
    private authService: AuthService,
    private router: Router
  ) {
    this.supportForm = this.fb.group({
      title: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
      text: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(300)]]
    });
  }

  ngOnInit(): void {
    this.userId = this.authService.getUserIdFromToken();
  }

  onSubmit(): void {
    if (this.supportForm.valid && this.userId !== null) {
      const supportRequest = {
        userId: this.userId,
        ...this.supportForm.value
      };

      this.supportService.createSupport(supportRequest).subscribe(
        response => {
          this.message = 'Destek Talebi Başarıyla Oluştu';  // Mesajı güncelle
          setTimeout(() => {
            this.message = null;  // Mesajı belirli bir süre sonra temizle
            this.router.navigate(['/support/supportlist'], { queryParams: { userId: this.userId } });
          }, 2000);  // Mesaj 2 saniye sonra kaybolur ve yönlendirilir
        },
        error => {
          this.errorMessage = 'Destek Talebi Oluşurutulurken Hata';
          console.error('Error creating support request', error);
          setTimeout(() => {
            this.errorMessage = null;
          }, 2000);  // 2000 milisaniye = 2 saniye // Hata mesajını güncelle
        }
      );
    }
  }
}