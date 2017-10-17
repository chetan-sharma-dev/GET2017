import { Component } from '@angular/core';
import { Location } from '@angular/common';

import { Product } from './product';
import { ProductService } from './product.service';
import { ProductsComponent } from './products.component';

@Component({
    selector : 'add-product',
    templateUrl : './add-product.component.html',
    styleUrls : ['./add-product.component.css']
})

export class AddProductComponent{

    constructor (private productService : ProductService,
        private productcomponent : ProductsComponent,
        private location : Location 

    ){}
    
    add(name : string , price : number) : void {
        name = name.trim();
        
        
         this.productService.create(name,price)
        .then( product => {
           this.productcomponent.products.push(product);
        } )
        
        

    }

    goBack() : void{
        this.location.back();
    }
}