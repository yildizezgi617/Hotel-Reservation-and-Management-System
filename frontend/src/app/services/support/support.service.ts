import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SupportService {
  private baseUrl: string = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  createSupport(supportRequest: any): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.post(`${this.baseUrl}/support/addSupport`, supportRequest, { headers, responseType: 'text' as 'json' });
  }
  getSupportRequestsByUserId(userId: number): Observable<any> {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    let token = localStorage.getItem('token');
    if (token) {
      headers = headers.set('Authorization', `Bearer ${token}`);
    }
    return this.http.get(`${this.baseUrl}/support/list/${userId}`, { headers });
  }
}