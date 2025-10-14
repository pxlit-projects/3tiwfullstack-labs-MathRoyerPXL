import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Customer } from '../../shared/models/customer.model';
import { CustomerItem } from '../../../core/customers/customer-item/customer-item';
import { Filter } from "../../../core/customers/filter/filter";

@Component({
  selector: 'app-customer-list',
  standalone: true,
  imports: [CommonModule, CustomerItem, Filter],
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerList {
  customers: Customer[] = [
    new Customer('Dries Swinnen', 'dries@d-ries.be','Pelt','mystreet','Belgium',21),
    new Customer('John Doe', 'john@doe.com','New York','5th Avenue','USA',6,'john.png')
  ];
}
