import { Component, EventEmitter, Output, inject } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Customer } from '../../../app/shared/models/customer.model';
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-add-customer',
  standalone: true,
  imports: [ReactiveFormsModule, NgClass],
  templateUrl: './add-customer.html',
  styleUrls: ['./add-customer.css']
})
export class AddCustomer {
  fb: FormBuilder = inject(FormBuilder);

  customerForm: FormGroup = this.fb.group({
    name: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    avatar: ['default.png', [Validators.required]],
    city: ['', Validators.required],
    address: ['', Validators.required],
    country: ['', Validators.required],
    vat: ['', [Validators.required, Validators.min(0)]]
  });

  @Output() addCustomer = new EventEmitter<Customer>();

  onSubmit() {
    if (!this.customerForm.valid) {
      this.customerForm.markAllAsTouched();
      return;
    }

    const value = this.customerForm.value;

    const newCustomer = new Customer(
      value['name'],
      value['email'],
      value['city'],
      value['address'],
      value['country'],
      Number(value['vat']),
      value['avatar']
    );

    this.addCustomer.emit(newCustomer);
    this.customerForm.reset({ avatar: 'default.png' });
  }
}
