"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var dashboard_component_1 = require("./dashboard.component");
var products_component_1 = require("./products.component");
var product_detail_component_1 = require("./product-detail.component");
var contactus_component_1 = require("./contactus.component");
var product_detail_edit_component_1 = require("./product-detail-edit.component");
var add_product_component_1 = require("./add-product.component");
var delete_product_component_1 = require("./delete-product.component");
var routes = [
    { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
    { path: 'dashboard', component: dashboard_component_1.DashboardComponent },
    { path: 'detail/:id', component: product_detail_component_1.ProductDetailComponent },
    { path: 'editdetail/:id', component: product_detail_edit_component_1.ProductDetailEditComponent },
    { path: 'products', component: products_component_1.ProductsComponent },
    { path: 'contactus', component: contactus_component_1.ContactusComponent },
    { path: 'addproduct', component: add_product_component_1.AddProductComponent },
    { path: 'delete/:id', component: delete_product_component_1.DeleteProductComponent }
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