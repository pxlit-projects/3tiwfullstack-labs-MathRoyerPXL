// customer-app/src/core/customers/customer-list/customer-list.ts
import { Component, OnInit, inject } from '@angular/core';
import { Customer } from '../../../app/shared/models/customer.model';
import { CustomerItem } from '../customer-item/customer-item';
import { Filter } from '../filter/filter';
import { FilterModel } from '../../../app/shared/models/filter.model';
import { AddCustomer } from '../add-customer/add-customer';
import { CustomerService } from '../../../app/shared/services/customer';

@Component({
  selector: 'app-core-customer-list',
  standalone: true,
  imports: [CustomerItem, Filter, AddCustomer],
  templateUrl: './customer-list.html',
  styleUrls: ['./customer-list.css']
})
export class CustomerList implements OnInit {
  customers!: Customer[];
  filteredData!: Customer[];

  customerService: CustomerService = inject(CustomerService);

  ngOnInit(): void {
    this.customers = this.customerService.getCustomers();
    this.customers[1].isLoyal = true;
    this.filteredData = this.customers;
  }

  handleFilter(filter: FilterModel) {
    this.filteredData = this.customerService.filterCustomers(filter);
  }

  processAdd(customer: Customer) {
    this.customerService.addCustomer(customer);
    this.filteredData = this.customerService.getCustomers();
  }
}
