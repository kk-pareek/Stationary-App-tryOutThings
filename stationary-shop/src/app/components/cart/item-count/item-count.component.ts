import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Product } from 'src/app/model/product';

@Component({
  selector: 'app-item-count',
  templateUrl: './item-count.component.html',
  styleUrls: ['./item-count.component.css']
})
export class ItemCountComponent implements OnInit {

  @Input() product !: Product;
  @Output() priceIncrease = new EventEmitter<number>();
  @Output() priceDecrease = new EventEmitter<number>();
  count = 1;

  constructor() { }

  ngOnInit() { }

  increaseCount() {
    this.count = this.count + 1;
    this.priceIncrease.emit(this.product.productPrice);
  }

  decreaseCount() {
    if (this.count > 1) {
      this.count = this.count - 1;
      this.priceDecrease.emit(this.product.productPrice);
    }
  }

}
