# Comandos Angular CLI 
>### ng new <i>nome-do-projeto</i> --no--standlone
>cria um novo projeto

>### ng serve
>roda a aplicação

>### ng s -o
>roda a aplicação e abre ela no navegador

>### ng g c <i>pasta</i>/<i>nome-do-componente</i>
>gera um novo componente na pasta especificada<br>
>exemplo: <i>ng g c components/views/home</i>

>### ng g s <i>pasta</i>/<i>nome-do-service</i>
>gera um novo service na pasta especificada<br>
>exemplo: <i>ng g c components/views/home</i>

<br>

# Arquitetura de pastas
- app
    - components
        - shared
            - card
            - navbar
        - views
            - cadastrar
            - home
    - model
    - services

<br>

# Adicionar Bootstrap
- Instalar o Bootstrap na pasta do projeto usando o comando <i>npm i bootstrap@5.3.3</i>
- Adicionar o caminho 
<i>"node_modules/bootstrap/dist/css/bootstrap.min.css"</i> no arquivo <i>angular.json</i> dentro da lista <i>"styles"</i>
- Pronto, basta adicionar as partes prontas que desejar usar
- Caso queira trocar para o tema escuro inclua os atributos <i>bg-dark</i> e <i>data-bs-theme ="dark"</i> dentro da tag como em 
<i>`<nav class="navbar bg-dark navbar-expand-lg" data-bs-theme ="dark">`</i>

- provideHttpClient()
adicionar no app.module em providers para utilizar o HttpClient

- routerLink
pra trocar entre as rotas


