import { Component, OnInit } from '@angular/core';
import { ApiService } from '../service/api.service';

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent implements OnInit {
  addresses: any[] = [];

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.fetchAddresses();
  }

  fetchAddresses() {
    this.apiService.getAllAddresses().subscribe((data) => {
      this.addresses = data;
    });
  }
}
