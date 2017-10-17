"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var product_service_1 = require("./product.service");
var cart_service_1 = require("./cart.service");
var app_header_component_1 = require("./app-header.component");
var ProductsComponent = (function () {
    function ProductsComponent(productservice, cartService, appheadcomp) {
        this.productservice = productservice;
        this.cartService = cartService;
        this.appheadcomp = appheadcomp;
        this.minicart = new core_1.EventEmitter();
    }
    ProductsComponent.prototype.getProduct = function () {
        var _this = this;
        this.productservice.getProducts().then(function (products) { return _this.products = products; });
    };
    ProductsComponent.prototype.ngOnInit = function () {
        this.getProduct();
    };
    ProductsComponent.prototype.onSelect = function (product) {
        this.selectedProduct = product;
    };
    ProductsComponent.prototype.delete = function (product) {
        var _this = this;
        this.productservice.delete(product.id)
            .then(function () {
            _this.products = _this.products.filter(function (p) { return p !== product; });
            if (_this.selectedProduct === product) {
                _this.selectedProduct = null;
            }
        });
    };
    ProductsComponent.prototype.addToCart = function (product) {
        var _this = this;
        this.cartService.addProductToCart(product).then(function () { return _this.appheadcomp.ngOnInit(); });
        alert("product has been added to the cart");
    };
    return ProductsComponent;
}());
__decorate([
    core_1.Output(),
    __metadata("design:type", Object)
], ProductsComponent.prototype, "minicart", void 0);
ProductsComponent = __decorate([
    core_1.Component({
        selector: 'my-products',
        templateUrl: './products.component.html',
        styleUrls: ['./products.component.css'],
        providers: [product_service_1.ProductService, cart_service_1.CartService]
    }),
    __metadata("design:paramtypes", [product_service_1.ProductService,
        cart_service_1.CartService,
        app_header_component_1.AppHeaderComponent])
], ProductsComponent);
exports.ProductsComponent = ProductsComponent;
//# sourceMappingURL=products.component.js.map