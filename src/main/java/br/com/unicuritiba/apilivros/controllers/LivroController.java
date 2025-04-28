package br.com.unicuritiba.apilivros.controllers;

import br.com.unicuritiba.apilivros.models.Livros;
import br.com.unicuritiba.apilivros.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;


    @GetMapping
    public String livros() {
        return "paginaInicial";
    }


    @GetMapping("/todos")
    public String listarTodosLivros(Model model) {

        List<Livros> livros = livroRepository.findAll();
        model.addAttribute("livros", livros);
        return "listarLivros";
    }


    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro() {
        return "cadastroLivro";  // Nome da página HTML com o formulário
    }


    @PostMapping("/cadastrar")
    public String cadastrarLivro(
            @RequestParam("titulo") String titulo,
            @RequestParam("editora") String editora,
            @RequestParam("autor") String autor,
            @RequestParam("sinopse") String sinopse,
            Model model) {

        // Criando um novo objeto Livro
        Livros livro = new Livros();
        livro.setTitulo(titulo);
        livro.setEditora(editora);
        livro.setAutor(autor);
        livro.setSinopse(sinopse);

        // Salvando o livro no banco de dados
        livroRepository.save(livro);

        // Adicionando uma mensagem de sucesso para exibir na página
        model.addAttribute("mensagem", "Livro cadastrado com sucesso!");

        // Retorna para o formulário com uma mensagem de sucesso
        return "cadastroLivro";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable("id") Long id, Model model) {

        Livros livro = livroRepository.findById(id).orElse(null);


        if (livro == null) {
            return "redirect:/livros/todos";
        }


        model.addAttribute("livro", livro);


        return "editarLivro";
    }

    @PostMapping("/editar/{id}")
    public String editarLivro(
            @PathVariable("id") Long id,
            @RequestParam("titulo") String titulo,
            @RequestParam("editora") String editora,
            @RequestParam("autor") String autor,
            @RequestParam("sinopse") String sinopse,
            Model model) {


        Livros livro = livroRepository.findById(id).orElse(null);


        if (livro == null) {
            return "redirect:/livros/todos";
        }


        livro.setTitulo(titulo);
        livro.setEditora(editora);
        livro.setAutor(autor);
        livro.setSinopse(sinopse);


        livroRepository.save(livro);


        model.addAttribute("mensagem", "Livro atualizado com sucesso!");


        return "redirect:/livros/todos";
    }

    @GetMapping("/apagar/{id}")
    public String apagarLivro(@PathVariable Long id, Model model) {
        // Verifica se o livro existe
        Livros livro = livroRepository.findById(id).orElse(null);

        if (livro != null) {
            livroRepository.delete(livro);
            model.addAttribute("mensagem", "Livro deletado com sucesso!");
        } else {
            model.addAttribute("mensagem", "Livro não encontrado.");
        }

        // Redireciona para a lista de livros após a exclusão
        return "listarLivros";
    }


    @GetMapping("/pesquisar")
    public String pesquisarLivros(
            @RequestParam(value = "titulo", required = false) String titulo,
            @RequestParam(value = "autor", required = false) String autor,
            @RequestParam(value = "editora", required = false) String editora,
            Model model) {

        List<Livros> livros;

        if (titulo != null && !titulo.isEmpty()) {
            livros = livroRepository.findByTituloContainingIgnoreCase(titulo);
        } else if (autor != null && !autor.isEmpty()) {
            livros = livroRepository.findByAutorContainingIgnoreCase(autor);
        } else if (editora != null && !editora.isEmpty()) {
            livros = livroRepository.findByEditoraContainingIgnoreCase(editora);
        } else {
            livros = livroRepository.findAll(); // Caso não tenha filtros, retorna todos os livros
        }

        model.addAttribute("livros", livros);
        return "pesquisaLivros"; // A mesma página de listagem de livros
    }

}
