package br.com.dijalmasilva.pos.biblioteca.repository;

import br.com.dijalmasilva.pos.biblioteca.model.Autor;
import br.com.dijalmasilva.pos.biblioteca.model.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 23/10/17.
 */
@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

    List<Livro> findLivroByAutores(Autor autor);
}
