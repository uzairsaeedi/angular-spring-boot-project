import { Component } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrl: './product-create.component.css'
})
export class ProductCreateComponent {
 product: Product = {id:0, name: ""};

 constructor( private productService: ProductService, private router: Router) {}

 createProduct(): void {
  this.productService.createProduct(this.product).subscribe(() => {
    this.router.navigate(['/products'])
  })
 }
}
