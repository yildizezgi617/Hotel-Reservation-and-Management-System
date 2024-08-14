import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private baseUrl: string = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  createReservation(reservation: any): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    let token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.post(`${this.baseUrl}/reservation/addReservation`, reservation, { headers });
  }


  createPayment(payment: any): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.post(`${this.baseUrl}/payment`, payment, { headers, responseType: 'text' });
  }

  addGuestInformation(guests: any[]): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.post(`${this.baseUrl}/guest/add`, guests, { headers, responseType: 'text' });
  }


  getReservationDetails(reservationId: number): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    let token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.get(`${this.baseUrl}/reservation/reservationlist/${reservationId}`, { headers });
  }

  getGuestsByReservationId(reservationId: number): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    let token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.get(`${this.baseUrl}/guest/reservation/${reservationId}`, { headers });
  }

  getReservationsByUserId(userId: number): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    let token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.get(`${this.baseUrl}/reservation/list/${userId}/reservations`, { headers });
  }

  updateReservationStatus(request: any): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.put(`${this.baseUrl}/reservation/updateReservation`, request, { headers, responseType: 'text' as 'json' });
  }


}