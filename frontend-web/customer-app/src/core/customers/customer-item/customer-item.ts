import { Component, Input } from '@angular/core';
import { Customer } from '../../../app/shared/models/customer.model';
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-customer-item',
  imports: [NgClass],
  templateUrl: './customer-item.html',
  styleUrl: './customer-item.css'
})
export class CustomerItem {
  @Input() customer!: Customer;

  getDetails(): void{
    console.log(this.customer);
  }
}

