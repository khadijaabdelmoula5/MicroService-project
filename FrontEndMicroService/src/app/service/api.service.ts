import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private gatewayUrl = 'http://localhost:9090/'; 

  constructor(private http: HttpClient) {}

  
  getAllStudents(): Observable<any> {
    return this.http.get(`${this.gatewayUrl}student-service/api/student/getAllStudent`);
  }

  
  getAllAddresses(): Observable<any> {
    return this.http.get(`${this.gatewayUrl}address-service/api/address/getAllAddress`);
  }

  
  createStudent(studentData: any): Observable<any> {
    const url = `${this.gatewayUrl}student-service/api/student/create`;
    return this.http.post(url, studentData);
  }

 
  createAddress(addressData: any): Observable<any> {
    const url = `${this.gatewayUrl}address-service/api/address/create`;
    return this.http.post(url, addressData);
  }
}
