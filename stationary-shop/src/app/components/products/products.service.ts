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

    this.httpClient.get("assets/json/data.json").subscribe(data => {
        this.products = data as Product[];
    })

    // console.log(typeof this.products);
    // console.log(this.products);
    
    return this.products;
  }


}
