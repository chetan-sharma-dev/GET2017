import 'rxjs/add/operator/switchMap';
import {Component , Input , OnInit} from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';
import { MyOrderService } from './myorder.service';
import { OrderProduct } from './OrderProduct';
import { Product } from './product';

@Component({
    selector : 'order-detail',
    templateUrl : './order-detail.component.html',
    
})

export class OrderDetailComponent implements OnInit { 
    
    constructor(
        private myorderservice : MyOrderService,
        private route : ActivatedRoute,
        private location : Location 
    ){}

    products : Product [];
    total : number;

    ngOnInit(): void {
        this.route.paramMap
        .switchMap((params : ParamMap) => this.myorderservice.getOrderDetail( +params.get('orderId')) )
        .subscribe(response => (this.products=response.products , this.total= response.total));
    }

    goBack() : void{
        this.location.back();
    }
    
}
