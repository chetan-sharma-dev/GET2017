"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var platform_browser_1 = require("@angular/platform-browser");
var forms_1 = require("@angular/forms"); // <-- NgModel lives here
var http_1 = require("@angular/http");
// Imports for loading & configuring the in-memory web api
var app_routing_module_1 = require("./app-routing.module");
var app_component_1 = require("./app.component");
var products_component_1 = require("./products.component");
var dashboard_component_1 = require("./dashboard.component");
var contactus_component_1 = require("./contactus.component");
var product_service_1 = require("./product.service");
var product_detail_component_1 = require("./product-detail.component");
var product_detail_edit_component_1 = require("./product-detail-edit.component");
var add_product_component_1 = require("./add-product.component");
var product_search_component_1 = require("./product-search.component");
var delete_product_component_1 = require("./delete-product.component");
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        imports: [
            platform_browser_1.BrowserModule,
            forms_1.FormsModule,
            http_1.HttpModule,
            app_routing_module_1.AppRoutingModule
        ],
        declarations: [
            app_component_1.AppComponent,
            product_detail_component_1.ProductDetailComponent,
            products_component_1.ProductsComponent,
            dashboard_component_1.DashboardComponent,
            contactus_component_1.ContactusComponent,
            product_detail_edit_component_1.ProductDetailEditComponent,
            add_product_component_1.AddProductComponent,
            product_search_component_1.ProductSearchComponent,
            delete_product_component_1.DeleteProductComponent
        ],
        bootstrap: [app_component_1.AppComponent],
        providers: [product_service_1.ProductService]
    })
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map