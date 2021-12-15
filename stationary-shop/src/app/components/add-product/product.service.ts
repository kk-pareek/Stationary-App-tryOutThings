import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from './product';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  productUrlToAdd : string = "http://localhost:8083/api/product/create";
  constructor(private theHttpClient : HttpClient) { }

  public addNewProduct(theProduct: Product) {
    return this.theHttpClient.post(this.productUrlToAdd, theProduct);
  }
}
