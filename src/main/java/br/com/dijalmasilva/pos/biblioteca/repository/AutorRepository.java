package br.com.dijalmasilva.pos.biblioteca.repository;

import br.com.dijalmasilva.pos.biblioteca.model.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 23/10/17.
 */
@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {
}
