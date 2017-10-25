import { Component } from '@angular/core';
import { Order_Payement } from './order_payement';
import { Router, ActivatedRoute } from '@angular/router';
import { CheckOutService } from './checkout.service';



@Component({
    selector  : 'checkout',
    templateUrl : './checkout.component.html',
    styleUrls : [ './checkout.component.css']
})


export class CheckoutComponent{

    constructor( private router: Router ,  private checkoutservice : CheckOutService){}

    
    
    placeOrder(
        cardNumber : string ,
        expMonth : number,
        expYear : number,
        cvCode : number
    ){

        console.log(cardNumber);
        console.log(cvCode);
        var curpayement = new Order_Payement();

        curpayement.cardNumber = cardNumber;
        curpayement.expMonth = expMonth;
        curpayement.expYear = expYear;
        curpayement.cvCode = cvCode;
        
        this.checkoutservice.makeOrder(curpayement);

        this.router.navigate(['/main/products']);
        
    }
}
