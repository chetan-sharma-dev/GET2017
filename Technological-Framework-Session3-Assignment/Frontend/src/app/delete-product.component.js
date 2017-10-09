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
var router_1 = require("@angular/router");
var common_1 = require("@angular/common");
require("rxjs/add/operator/switchMap");
var product_service_1 = require("./product.service");
var DeleteProductComponent = (function () {
    function DeleteProductComponent(productService, route, location) {
        this.productService = productService;
        this.route = route;
        this.location = location;
    }
    DeleteProductComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            _this.id = +params['id'];
            _this.delete();
        });
    };
    DeleteProductComponent.prototype.goBack = function () {
        this.location.back();
    };
    DeleteProductComponent.prototype.delete = function () {
        var _this = this;
        alert('product deleted successfully');
        this.productService
            .delete(this.id)
            .then(function () { return _this.goBack(); });
    };
    return DeleteProductComponent;
}());
DeleteProductComponent = __decorate([
    core_1.Component({
        selector: 'delete-product',
        template: "\n    DELETING PRODUCT\n        \n     "
    }),
    __metadata("design:paramtypes", [product_service_1.ProductService,
        router_1.ActivatedRoute,
        common_1.Location])
], DeleteProductComponent);
exports.DeleteProductComponent = DeleteProductComponent;
//# sourceMappingURL=delete-product.component.js.map