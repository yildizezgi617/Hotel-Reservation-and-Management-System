import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../../services/auth/auth.service';
import { Router } from '@angular/router';
import { error } from 'console';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  loginForm: FormGroup
  message: string | null = null;  // Mesaj değişkeni
  errorMessage: string | null = null;  // Mesaj değişkeni


  constructor(private formbuilder: FormBuilder, private authService: AuthService, private router: Router) {
    this.loginForm = this.formbuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      this.authService.loginUser(this.loginForm.value).subscribe(
        response => {
          this.authService.login(response);
          console.log("Giriş Başarılı");
          this.message = 'Giriş Başarılı, Ana Sayfaya Yönlendiriliyorsunuz.'
          setTimeout(() => {
            this.message = null;
            this.router.navigate(['/']);
          }, 2000);  // 2000 milisaniye = 2 saniye
        },
        error => {
          this.errorMessage = ('Eposta Veya Şifre Hatalı')
          console.log("Login Başarısız", error);
          setTimeout(() => {
            this.errorMessage = null;
          }, 2000);  // 2000 milisaniye = 2 saniye
        }
      );
    }
  }

}
