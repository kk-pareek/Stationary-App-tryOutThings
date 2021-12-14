import { Component, OnInit } from '@angular/core';
import { AddCustomerService } from './add-customer.service';
import { Customer } from '../../model/customer';

@Component({
  selector: 'register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  customer: Customer = new Customer();
  constructor(private addCustomerService: AddCustomerService) { }

  ngOnInit(): void {
  }

  addNewCustomer() : void{
    this.addCustomerService.addNewCustomer(this.customer)
    .subscribe(responseData => {
      alert("Customer added...");
    });
  }

}
