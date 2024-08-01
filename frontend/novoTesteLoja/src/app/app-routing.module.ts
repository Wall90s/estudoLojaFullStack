import { NgModule } from '@angular/core';
import { RouterLink, RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/views/home/home.component';
import { CadastroComponent } from './components/views/cadastro/cadastro.component';

const routes: Routes = [
  {
    path: '', component: HomeComponent
  },
  {
    path: 'cadastro', component: CadastroComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes), RouterLink],
  exports: [RouterModule]
})
export class AppRoutingModule { }
