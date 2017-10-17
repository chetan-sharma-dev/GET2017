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
var order_payement_1 = require("./order_payement");
var router_1 = require("@angular/router");
var checkout_service_1 = require("./checkout.service");
var CheckoutComponent = (function () {
    function CheckoutComponent(router, checkoutservice) {
        this.router = router;
        this.checkoutservice = checkoutservice;
    }
    CheckoutComponent.prototype.placeOrder = function (cardNumber, expMonth, expYear, cvCode) {
        console.log(cardNumber);
        console.log(cvCode);
        var curpayement = new order_payement_1.Order_Payement();
        curpayement.cardNumber = cardNumber;
        curpayement.expMonth = expMonth;
        curpayement.expYear = expYear;
        curpayement.cvCode = cvCode;
        this.checkoutservice.makeOrder(curpayement);
        this.router.navigate(['/main/products']);
    };
    return CheckoutComponent;
}());
CheckoutComponent = __decorate([
    core_1.Component({
        selector: 'checkout',
        templateUrl: './checkout.component.html',
        styleUrls: ['./checkout.component.css']
    }),
    __metadata("design:paramtypes", [router_1.Router, checkout_service_1.CheckOutService])
], CheckoutComponent);
exports.CheckoutComponent = CheckoutComponent;
//# sourceMappingURL=checkout.component.js.map