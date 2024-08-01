import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Produto } from '../model/produto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  private apiUrl = 'http://localhost:8080/produtos';

  constructor(private http: HttpClient) { }

  public getProdutos(): Observable<Produto[]> {
    return this.http.get<Produto[]>(this.apiUrl);
  }

  public postProduto(novoProduto: Produto): Observable<Produto> {
    return this.http.post<Produto>(this.apiUrl, novoProduto);
  }

  public putProduto(produtoAtualizado: Produto): Observable<Produto> {
    return this.http.put<Produto>(this.apiUrl, produtoAtualizado);
  }

  public deleteProduto(id: number): void {
    this.http.delete(`${this.apiUrl}/${id}`).subscribe();
  }
}
