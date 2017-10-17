import { Component,OnInit ,AfterViewInit } from '@angular/core';
import { CartService } from './cart.service';
import { Product } from './product';
import { Router, ActivatedRoute } from '@angular/router';
import { AppHeaderComponent } from './app-header.component'; 

@Component({
    selector:'cart',
    templateUrl : './cart.component.html'
})

export class CartComponent implements OnInit , AfterViewInit{

    products: Product[];
    constructor(private cartServices : CartService , private router: Router , private appheadcomp : AppHeaderComponent){}
    
    ngOnInit() {
        this.getCartProduct();
    }
    
    getCartProduct() : void{
        this.cartServices.getCartProducts().then(products => this.products=products);
    }

    delete(product : Product){
        this.cartServices.deleteProductFromCart(product).then(() => {
            let index = this.products.indexOf(product);
            this.products.splice(index,1); this.appheadcomp.ngOnInit();

        });
       
    }

    ngAfterViewInit() : void {
        this.getCartProduct();
    }

    toCheckout() {
        this.router.navigate(['main/checkout']);
    }

  

}