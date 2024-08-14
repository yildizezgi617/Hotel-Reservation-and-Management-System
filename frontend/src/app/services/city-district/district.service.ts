import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DistrictService {

  private baseUrl = 'http://localhost:8080/api/districts';

  constructor(private http: HttpClient) { }

  getDistrictsByCity(cityId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/by-city/${cityId}`);
  }
}