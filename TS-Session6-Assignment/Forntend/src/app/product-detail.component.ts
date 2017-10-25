import 'rxjs/add/operator/switchMap';
import {Component , Input , OnInit} from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

import {Product} from './Product';
import { ProductService } from './product.service';

@Component({
    selector : 'product-detail',
    templateUrl:'./product-detail.component.html',
    styleUrls: ['./product-detail.component.css' ]
    
})

export class ProductDetailComponent implements OnInit {

    constructor(
        private productService : ProductService,
        private route : ActivatedRoute,
        private location : Location 
    ){}

   @Input() product : Product;

   ngOnInit() :void {
       this.route.paramMap
       .switchMap((params : ParamMap) => this.productService.getProduct( +params.get('id')) )
       .subscribe(product => this.product=product);
   }

   goBack():void {  
       this.location.back();
   }
}
