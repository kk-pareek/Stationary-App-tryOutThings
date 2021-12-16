// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class AddCustomerService {

//   constructor() { }
// }


import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from '../../model/customer';


@Injectable({
  providedIn: 'root'
})
export class AddCustomerService {

  customerUrlToAdd : string = "http://localhost:8082/customers";
  constructor(private theHttpClient : HttpClient) { }

  public addNewCustomer(theCustomer: Customer) {
    return this.theHttpClient.post(this.customerUrlToAdd, theCustomer);
  }
}
