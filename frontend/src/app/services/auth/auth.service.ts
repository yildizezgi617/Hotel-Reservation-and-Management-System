import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl: string = 'http://localhost:8080/api';
  private tokenKey: string = 'token';

  constructor(private http: HttpClient) { }

  registerUser(user: any): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(`${this.baseUrl}/auth/register`, user, { headers, responseType: 'text' });
  }


  loginUser(user: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/auth/login`, user, { responseType: 'text' })
  }


  login(token: string): void {
    localStorage.setItem(this.tokenKey, token);
  }

  logout(): void {
    localStorage.removeItem(this.tokenKey);
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem(this.tokenKey);
  }

  getToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }

  getUserRole(): string | null {
    const token = this.getToken();
    if (token) {
      const payload = this.decodeTokenPayload(token);
      return payload ? payload.UserRole : null;
    }
    return null;
  }

  getUserIdFromToken(): number | null {
    const token = this.getToken();
    if (token) {
      const payload = this.decodeTokenPayload(token);
      return payload ? payload.UserId : null;
    }
    return null;
  }

  private decodeTokenPayload(token: string): any {
    const payloadPart = token.split('.')[1];
    if (payloadPart) {
      const decodedPayload = atob(payloadPart.replace(/-/g, '+').replace(/_/g, '/'));
      return JSON.parse(decodedPayload);
    }
    return null;
  }


}
