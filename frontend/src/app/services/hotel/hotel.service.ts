import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  private baseUrl: string = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  addHotel(hotel: any): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.post(`${this.baseUrl}/hotel/createhotel`, hotel, { headers, responseType: 'text' as 'json' });
  }

  getAllHotels(): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.get(`${this.baseUrl}/hotel/hotellist`, { headers });
  }

  addHotelAddress(hotelAddress: any): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.post(`${this.baseUrl}/hotel_address/addHotelAddress`, hotelAddress, { headers, responseType: 'text' as 'json' })
  }

  getReservationsByHotelId(hotelId: number): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.get(`${this.baseUrl}/reservation/hotel/${hotelId}/reservations`, { headers });
  }
  updateHotel(hotel: any): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.put(`${this.baseUrl}/hotel/updateHotel`, hotel, { headers, responseType: 'text' as 'json' });
  }

  getFeedbacksByHotelId(hotelId: number): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.get(`${this.baseUrl}/feedback/hotel/${hotelId}/feedbacks`, { headers });
  }

  addResponseToFeedback(feedbackId: number, description: string): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    const body = { feedbackId, description };
    return this.http.post(`${this.baseUrl}/responseToFeedback/addResponseToFeedback`, body, { headers, responseType: 'text' as 'json' });
  }

}
