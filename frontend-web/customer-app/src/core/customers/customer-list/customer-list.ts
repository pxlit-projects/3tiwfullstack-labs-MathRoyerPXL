import { Component, OnInit } from '@angular/core';
import { Customer } from '../../../app/shared/models/customer.model';
import { Filter } from "../filter/filter";
import { CustomerItem } from "../customer-item/customer-item";

@Component({
  selector: 'app-customer-list',
  imports: [Filter, CustomerItem],
  templateUrl: './customer-list.html',
  styleUrl: './customer-list.css'
})
export class CustomerList implements OnInit {
  customers!: Customer[];

   ngOnInit(): void {
    this.customers = [
      new Customer('Dries Swinnen', 'dries@pxl.be', 'Pelt', 'mystreet', 'Belgium', 21),
      new Customer('John Doe', 'john@doe.be', 'New York', '5th Avenue', 'USA', 6),
      new Customer('Jane Doe', 'jane@doe.be', 'Los Angeles', 'Sunset Boulevard', 'USA', 6)
    ];

    this.customers[1].isLoyal = true;
  }

}

