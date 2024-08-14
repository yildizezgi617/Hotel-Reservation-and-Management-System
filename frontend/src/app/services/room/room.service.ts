import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private baseUrl: string = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  addRoom(room: any): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.post(`${this.baseUrl}/room/addRoom`, room, { headers, responseType: 'text' as 'json' });
  }

  findAvailableRooms(enteranceDay: string, releaseDay: string, roomType?: string, capacity?: number, location?: string): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }

    const params: any = {
      enteranceDay,
      releaseDay
    };

    if (roomType) {
      params.roomType = roomType;
    }

    if (capacity) {
      params.capacity = capacity;
    }

    if (location) {
      params.location = location;
    }

    return this.http.get(`${this.baseUrl}/room/available-rooms`, { headers, params });
  }

  updateRoom(room: any): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.put(`${this.baseUrl}/room/updateRoom`, room, { headers, responseType: 'text' as 'json' });
  }
}
