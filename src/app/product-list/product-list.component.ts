import { Component } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {
  products: Product[] = [];

  constructor( private productService: ProductService, private router: Router) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.get().subscribe(data => {
      this.products = data;
    })
  }

  deleteProduct(id: number) : void {
    this.productService.deleteProduct(id).subscribe(() => {
      this.loadProducts();
    })
  }
  editProduct(id: number): void {
    this.router.navigate(['/product/edit',id])
  }
  
}
