import { Injectable } from '@angular/core';
import { Headers,Http, RequestOptionsArgs } from '@angular/http';
import { UserService } from './user.service';
import { Order_Payement } from './order_payement';
import { OrderProduct } from './OrderProduct';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class MyOrderService {

    private headers = new Headers({'Content-Type': 'application/json'});

    constructor(private http : Http , private userService : UserService){}

    private GetMyOrder = 'http://localhost:8080/shoppinghibernate/rest/user/getorders';
    private GetMyOrderProducts = 'http://localhost:8080/shoppinghibernate/rest/user/getorderproducts';
    
  
    getMyOrders() : Promise<Order_Payement[]>{

        let userId = this.userService.getLoggedInUserId();
        const url = `${this.GetMyOrder}/${userId}`;
        
        return this.http.get(url)
        .toPromise()
        .then(response => response.json() as Order_Payement[]);
        
    }

    getOrderDetail(orderId : number) : Promise<OrderProduct>{

        const url = `${this.GetMyOrderProducts}/${orderId}`;
        
        return this.http.get(url)
        .toPromise()
        .then(response => response.json() as OrderProduct);
    }

  

}