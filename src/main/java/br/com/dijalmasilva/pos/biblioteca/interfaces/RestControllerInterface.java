package br.com.dijalmasilva.pos.biblioteca.interfaces;

import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 23/10/17.
 */
public interface RestControllerInterface<T> {

    ResponseEntity<T> save(T t);

    ResponseEntity<T> edit(Long id, T t);

    ResponseEntity<T> findOne(Long id);

    List<T> findAll();

    void delete(Long id);

    void deleteAll();
}
