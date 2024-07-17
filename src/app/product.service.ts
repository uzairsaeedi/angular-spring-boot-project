import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient:HttpClient) { }

  private baseUrl = "http://localhost:8081/api/category"

 get():Observable<Product[]>{
  return this.httpClient.get<Product[]>(`${this.baseUrl}`)
 } 

 getProduct(id:number): Observable<Product> {
  return this.httpClient.get<Product>(`${this.baseUrl}/${id}`)
 }

 createProduct(product: Product){
  return this.httpClient.post<Product>(this.baseUrl,Product)
 }

 updateProduct(id:number, product:Product): Observable<Product>{
  return this.httpClient.put<Product>(`${this.baseUrl}`,product)
 }

 deleteProduct(id:number): Observable<void>{
  return this.httpClient.delete<void>(`${this.baseUrl}/${id}`);
 }
}
