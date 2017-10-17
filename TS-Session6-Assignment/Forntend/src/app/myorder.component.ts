import { Component , OnInit } from '@angular/core';
import { Order_Payement } from './order_payement';
import { MyOrderService } from './myorder.service';
import { Router } from '@angular/router';

@Component({
    selector : 'my-order',
    templateUrl : './myorder.component.html'
})

export class MyOrderComponent implements OnInit{
    
    constructor( private myorderservice : MyOrderService , private router: Router ){}

    myorders : Order_Payement[] = [];

    ngOnInit(): void {
        this.myorderservice.getMyOrders().then( response => this.myorders = response);
    }

    getOrderDetail(orderId : number){
        this.router.navigate(['main/orderdetail' , orderId]);
    }


}