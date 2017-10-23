package br.com.dijalmasilva.pos.biblioteca.interfaces;

import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 23/10/17.
 */
public interface ServiceInterface<T> {

    T save(T obj);

    T edit(Long id, T obj);

    T findOne(Long id);

    List<T> findAll();

    void delete(Long id);

    void deleteAll();
}
