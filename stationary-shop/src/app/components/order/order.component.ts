import { Component, OnInit } from '@angular/core';
import { Order } from '../../model/order';
import { OrderService } from './order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  constructor(private orderService : OrderService) { }

  ngOnInit(): void {
  }


}
