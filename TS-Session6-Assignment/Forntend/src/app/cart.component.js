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
var cart_service_1 = require("./cart.service");
var router_1 = require("@angular/router");
var app_header_component_1 = require("./app-header.component");
var CartComponent = (function () {
    function CartComponent(cartServices, router, appheadcomp) {
        this.cartServices = cartServices;
        this.router = router;
        this.appheadcomp = appheadcomp;
    }
    CartComponent.prototype.ngOnInit = function () {
        this.getCartProduct();
    };
    CartComponent.prototype.getCartProduct = function () {
        var _this = this;
        this.cartServices.getCartProducts().then(function (products) { return _this.products = products; });
    };
    CartComponent.prototype.delete = function (product) {
        var _this = this;
        this.cartServices.deleteProductFromCart(product).then(function () {
            var index = _this.products.indexOf(product);
            _this.products.splice(index, 1);
            _this.appheadcomp.ngOnInit();
        });
    };
    CartComponent.prototype.ngAfterViewInit = function () {
        this.getCartProduct();
    };
    CartComponent.prototype.toCheckout = function () {
        this.router.navigate(['main/checkout']);
    };
    return CartComponent;
}());
CartComponent = __decorate([
    core_1.Component({
        selector: 'cart',
        templateUrl: './cart.component.html'
    }),
    __metadata("design:paramtypes", [cart_service_1.CartService, router_1.Router, app_header_component_1.AppHeaderComponent])
], CartComponent);
exports.CartComponent = CartComponent;
//# sourceMappingURL=cart.component.js.map