import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  private baseUrl = 'http://localhost:8080/api/cities';

  constructor(private http: HttpClient) { }

  getAllCities(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
