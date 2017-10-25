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
var myorder_service_1 = require("./myorder.service");
var router_1 = require("@angular/router");
var MyOrderComponent = (function () {
    function MyOrderComponent(myorderservice, router) {
        this.myorderservice = myorderservice;
        this.router = router;
        this.myorders = [];
    }
    MyOrderComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.myorderservice.getMyOrders().then(function (response) { return _this.myorders = response; });
    };
    MyOrderComponent.prototype.getOrderDetail = function (orderId) {
        this.router.navigate(['main/orderdetail', orderId]);
    };
    return MyOrderComponent;
}());
MyOrderComponent = __decorate([
    core_1.Component({
        selector: 'my-order',
        templateUrl: './myorder.component.html'
    }),
    __metadata("design:paramtypes", [myorder_service_1.MyOrderService, router_1.Router])
], MyOrderComponent);
exports.MyOrderComponent = MyOrderComponent;
//# sourceMappingURL=myorder.component.js.map