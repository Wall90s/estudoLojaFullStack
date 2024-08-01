import { Component, Input, OnInit } from '@angular/core';
import { Produto } from '../../../model/produto';
import { ProdutoService } from '../../../services/produto.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrl: './card.component.css'
})
export class CardComponent implements OnInit {

  @Input() produto!: Produto;

  constructor(private produtoService: ProdutoService) { }

  ngOnInit(): void {
  }

  public onClickBotaoExcluir(): void {
    this.produtoService.deleteProduto(this.produto.id);
  }

  produtoEditavel: boolean = false;
  public onClickBotaoAtualizar(): void {
    this.produtoEditavel = !this.produtoEditavel;
    this.alterarTextoBotaoEditar()
  }

  textoBotaoEditar: string = "editar";
  public alterarTextoBotaoEditar(): void{
    if (this.produtoEditavel) {
      this.textoBotaoEditar = "cancelar";
    } else {
      this.textoBotaoEditar = "editar";
    }
  }
  
  public onClickBotaoSalvar() {
    this.produtoService.putProduto(this.produto).subscribe(resposta => {
      resposta
    })
    this.onClickBotaoAtualizar();
  }  
}
