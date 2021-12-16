import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../../model/product';
// import { products } from '../../../assets/json/products';


@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  // products : Product[] = products;

  products : Product[] = [];

  constructor(private httpClient : HttpClient) { }

  getProducts() { 

    this.httpClient.get("http://localhost:8083/api/product/products").subscribe(data => {
      this.products = data as Product[];
    })

    // console.log(typeof this.products);
    // console.log(this.products);
    
    return this.products;
  }


}
