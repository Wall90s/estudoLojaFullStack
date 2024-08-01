import { Component, OnInit } from '@angular/core';
import { Produto } from '../../../model/produto';
import { ProdutoService } from '../../../services/produto.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{

  produtos!: Produto[];

  constructor(private produtoService: ProdutoService){}

  ngOnInit(): void {
    this.fillProdutos();
  }

  public fillProdutos(): void{
    this.produtoService.getProdutos().subscribe((resposta) =>{
      this.produtos = resposta;
    })
  }

}
