package br.com.unicuritiba.apilivros.repositories;


import br.com.unicuritiba.apilivros.models.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livros, Long> {
    // Métodos de pesquisa por título, autor ou editora
    List<Livros> findByTituloContainingIgnoreCase(String titulo);
    List<Livros> findByAutorContainingIgnoreCase(String autor);
    List<Livros> findByEditoraContainingIgnoreCase(String editora);
}
