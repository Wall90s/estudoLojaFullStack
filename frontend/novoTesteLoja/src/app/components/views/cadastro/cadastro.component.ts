import { Component, Input, OnInit } from '@angular/core';
import { Produto } from '../../../model/produto';
import { ProdutoService } from '../../../services/produto.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrl: './cadastro.component.css'
})
export class CadastroComponent implements OnInit {

  produto: Produto = new Produto();

  constructor(private produtoService: ProdutoService) { }

  ngOnInit(): void {
  }

  public adicionarProduto() {
    this.produtoService.postProduto(this.produto).subscribe(resposta => {
      resposta
    })
  }
}
