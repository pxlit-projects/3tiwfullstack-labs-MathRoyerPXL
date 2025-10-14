/// <reference types="jasmine" />
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerList } from './customer-list.component';

describe('CustomerList', () => {
  let component: CustomerList;
  let fixture: ComponentFixture<CustomerList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CustomerList]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerList);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
// Removed local stubs that shadow Jasmine globals (beforeEach, expect).
});
