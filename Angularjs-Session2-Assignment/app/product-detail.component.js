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
var product_1 = require("./product");
var ProductDetailComponent = (function () {
    function ProductDetailComponent() {
    }
    return ProductDetailComponent;
}());
__decorate([
    core_1.Input(),
    __metadata("design:type", product_1.Product)
], ProductDetailComponent.prototype, "product", void 0);
ProductDetailComponent = __decorate([
    core_1.Component({
        selector: 'product-detail',
        template: "\n    <div class=\"container text-center\">\n    <div *ngIf=\"product\" class=\"col-xs-12 col-sm-6 \">\n      <div class=\"panel panel-primary\">\n          <div class=\"panel-heading\">\n            <h3>  {{product.name}} details!</h3>\n          </div>\n          <div class=\"panel-body\">\n              <table class=\"table table-bordered\">\n                  <tbody>\n                      <tr>\n                            <td>\n                                <label>id: </label>\n                            </td>\n                          <td>\n                              {{product.id}}\n                          </td>\n                      </tr>\n    \n                      <tr>\n                          <td>\n                              <label>Name: </label>\n                          </td>\n                        <td>\n                            {{product.name}}\n                        </td>\n                    </tr>\n    \n                    <tr>\n                        <td>\n                            <label>Price: </label>\n                        </td>\n                      <td>\n                          {{product.price}}\n                        <!-- <input [(ngModel)]=\"selectedProduct.price\" placeholder=\"price\"/>-->\n                      </td>\n                  </tr>\n                    </tbody>\n                </table>\n            \n          </div>\n      </div>\n    </div>\n    </div>\n    "
    })
], ProductDetailComponent);
exports.ProductDetailComponent = ProductDetailComponent;
//# sourceMappingURL=product-detail.component.js.map