import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../service/api.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent {
  newStudent: any = {
    firstName: '',
    lastName: '',
    email: '',
    street: '',
    city: ''
  };

  constructor(private apiService: ApiService, public router: Router) {}

  saveStudent() {
    // Ensure the body matches the expected format
    const requestBody = {
      firstName: this.newStudent.firstName,
      lastName: this.newStudent.lastName,
      email: this.newStudent.email,
      street: this.newStudent.street,
      city: this.newStudent.city
    };

    this.apiService.createStudent(requestBody).subscribe(
      (response) => {
        console.log('Student created successfully:', response);
        this.router.navigate(['/students']); // Redirect to student list
      },
      (error) => {
        console.error('Error creating student:', error);
      }
    );
  }
}
