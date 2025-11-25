import { Component, Input } from '@angular/core';
import { NgClass } from '@angular/common';
import { Customer } from '../../../app/shared/models/customer.model';

@Component({
  selector: 'app-customer-item',
  standalone: true,
  imports: [NgClass],
  templateUrl: './customer-item.html',
  styleUrls: ['./customer-item.css']
})
export class CustomerItem {
  @Input() customer!: Customer;

  getDetails(): void {
    console.log(this.customer);
  }
}
