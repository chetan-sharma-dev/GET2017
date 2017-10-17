"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var products_component_1 = require("./products.component");
var product_detail_component_1 = require("./product-detail.component");
var dashboard_component_1 = require("./dashboard.component");
var product_edit_component_1 = require("./product-edit.component");
var add_product_component_1 = require("./add-product.component");
var contactus_component_1 = require("./contactus.component");
var cart_component_1 = require("./cart.component");
var app_login_component_1 = require("./app-login.component");
var app_header_component_1 = require("./app-header.component");
var checkout_component_1 = require("./checkout.component");
var myorder_component_1 = require("./myorder.component");
var orderdetail_component_1 = require("./orderdetail.component");
var routes = [
    {
        path: 'main',
        component: app_header_component_1.AppHeaderComponent,
        children: [
            { path: 'dashboard', component: dashboard_component_1.DashboardComponent },
            {
                path: 'products',
                component: products_component_1.ProductsComponent
            },
            {
                path: 'contactus',
                component: contactus_component_1.ContactUs
            },
            {
                path: 'cart',
                component: cart_component_1.CartComponent,
            },
            {
                path: 'checkout',
                component: checkout_component_1.CheckoutComponent
            },
            {
                path: 'myorders',
                component: myorder_component_1.MyOrderComponent
            },
            {
                path: 'orderdetail/:orderId',
                component: orderdetail_component_1.OrderDetailComponent
            }
        ]
    },
    {
        path: 'dashboard',
        component: dashboard_component_1.DashboardComponent
    },
    {
        path: '',
        component: app_login_component_1.LoginComponent
    },
    {
        path: 'detail/:id',
        component: product_detail_component_1.ProductDetailComponent
    },
    {
        path: 'edit-product/:id',
        component: product_edit_component_1.ProductEditComponent
    },
    {
        path: 'addProduct',
        component: add_product_component_1.AddProductComponent
    }
];
var AppRoutingModule = (function () {
    function AppRoutingModule() {
    }
    return AppRoutingModule;
}());
AppRoutingModule = __decorate([
    core_1.NgModule({
        imports: [router_1.RouterModule.forRoot(routes)],
        exports: [router_1.RouterModule]
    })
], AppRoutingModule);
exports.AppRoutingModule = AppRoutingModule;
//# sourceMappingURL=app-routing.module.js.map