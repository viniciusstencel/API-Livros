# API-Livros
API CRUD para atividade professor João Paulo


 JDK/Java 17

API para gerir um estoque de livros, informações: titulo, editora, autor e sinopse. podemos inserir livros novos, atualizar os dados, e excluir.
 Usamos o mysql workbench, o nome do banco de dados que deve ser criado é “api_livros” nota: para o aplicação funcionar deve-se alterar a senha do banco de dados no arquivo Application.properties.

# EndPoints:
1. GET /livros
Descrição: Exibe a página inicial da biblioteca.

Resposta: Retorna a página inicial (paginaInicial.html).

2. GET /livros/todos
Descrição: Lista todos os livros cadastrados.

Resposta: Retorna uma página HTML (listarLivros.html) com todos os livros da biblioteca.

3. GET /livros/cadastrar
Descrição: Exibe o formulário para cadastro de um novo livro.

Resposta: Retorna o formulário de cadastro (cadastroLivro.html).

4. POST /livros/cadastrar
Descrição: Cadastra um novo livro.

Parâmetros:

titulo (String): Título do livro.

editora (String): Editora do livro.

autor (String): Autor do livro.

sinopse (String): Sinopse do livro.

Resposta: Retorna uma mensagem de sucesso ou erro e exibe o formulário de cadastro novamente.

5. GET /livros/editar/{id}
Descrição: Exibe o formulário para editar um livro existente.

Parâmetros:

id (Long): ID do livro que será editado.

Resposta: Retorna o formulário de edição com os dados do livro.

6. POST /livros/editar/{id}
Descrição: Atualiza os dados de um livro.

Parâmetros:

id (Long): ID do livro que será editado.

titulo (String): Título do livro.

editora (String): Editora do livro.

autor (String): Autor do livro.

sinopse (String): Sinopse do livro.

Resposta: Redireciona para a página de listagem de livros com os dados atualizados.

7. GET /livros/apagar/{id}
Descrição: Exclui um livro da biblioteca.

Parâmetros:

id (Long): ID do livro que será excluído.

Resposta: Redireciona para a lista de livros atualizada após a exclusão.

8. GET /livros/pesquisar
Descrição: Pesquisa livros por título, autor ou editora.

Parâmetros (todos são opcionais):

titulo (String): Título do livro.

autor (String): Autor do livro.

editora (String): Editora do livro.

Resposta: Exibe a lista de livros encontrados com base nos critérios de pesquisa.
