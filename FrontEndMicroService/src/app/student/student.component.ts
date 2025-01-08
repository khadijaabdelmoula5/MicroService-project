import { Component, OnInit } from '@angular/core';
import { ApiService } from '../service/api.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  students: any[] = [];
  addresses: any[] = [];

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.fetchStudents();
    this.fetchAddresses();
  }

  fetchStudents() {
    this.apiService.getAllStudents().subscribe((data) => {
      this.students = data;
    });
  }

  fetchAddresses() {
    this.apiService.getAllAddresses().subscribe((data) => {
      this.addresses = data;
    });
  }
}
