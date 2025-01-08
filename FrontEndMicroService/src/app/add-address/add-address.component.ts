import { Component } from '@angular/core';
import { ApiService } from '../service/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-address',
  templateUrl: './add-address.component.html',
  styleUrls: ['./add-address.component.css'],
})
export class AddAddressComponent {
  address = { street: '', city: '' };
  successMessage: string | null = null;
  errorMessage: string | null = null;

  constructor(private apiService: ApiService, public router: Router) {}

  onSubmit(): void {
    this.apiService.createAddress(this.address).subscribe({
      next: (response) => {
        this.router.navigate(['/addresses']); 
        this.errorMessage = null;
        this.address = { street: '', city: '' }; 
      },
      error: (error) => {
        this.errorMessage = 'Failed to add address. Please try again.';
        console.error(error);
      },
    });
  }
}
