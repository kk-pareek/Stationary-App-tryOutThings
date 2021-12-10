import { Component, Input, OnInit, Output } from '@angular/core';
import { Product } from 'src/app/model/product';
import { CartService } from '../cart/cart.service';


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input() product !: Product;

  constructor(private cartService : CartService) { }

  ngOnInit(): void {
    
  }

}
