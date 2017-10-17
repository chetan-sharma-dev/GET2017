import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AppComponent }  from './app.component';
import { ProductsComponent } from './products.component';
import { ProductDetailComponent } from './product-detail.component';
import { ProductService } from './product.service'; 
import { DashboardComponent } from './dashboard.component';
import { ProductEditComponent } from './product-edit.component';
import { AddProductComponent } from './add-product.component';
import { ProductSearchComponent } from './product-search.component';
import { ContactUs } from './contactus.component';
import { CartComponent } from './cart.component';
import { CartService } from './cart.service';
import { AppHeaderComponent } from './app-header.component';
import { LoginComponent } from './app-login.component';
import { AppRoutingModule } from './app-routing.module';
import { UserService } from './user.service';
import { CheckoutComponent } from './checkout.component';
import { CheckOutService } from './checkout.service';
import { MyOrderComponent } from './myorder.component';
import { MyOrderService } from './myorder.service';
import { OrderDetailComponent } from './orderdetail.component';


@NgModule({
  imports:      [ 
      BrowserModule,
      AppRoutingModule,
      HttpModule,
      FormsModule
  ],
  declarations: [ 
    AppComponent, 
    ProductDetailComponent , 
    ProductsComponent,
    DashboardComponent,
    ProductEditComponent,
    AddProductComponent,
    ProductSearchComponent,
    ContactUs,
    CartComponent,
    AppHeaderComponent,
    LoginComponent,
    CheckoutComponent,
    MyOrderComponent,
    OrderDetailComponent
  ],
  bootstrap:    [ AppComponent ],
  providers :   [ ProductService , ProductsComponent , CartService, UserService ,CheckOutService , MyOrderService , AppHeaderComponent]
})



export class AppModule { }
