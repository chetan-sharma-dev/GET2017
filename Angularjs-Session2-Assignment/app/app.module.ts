import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms'; // <-- NgModel lives here

import { AppComponent }  from './app.component';
import { ProductService }  from './product.service';
import {ProductDetailComponent } from './product-detail.component';

@NgModule({
  imports:      [ BrowserModule ,FormsModule],
  declarations: [ AppComponent ,ProductDetailComponent ],
  bootstrap:    [ AppComponent ],
  providers: [ProductService]
})
export class AppModule { }
