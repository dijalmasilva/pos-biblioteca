package br.com.dijalmasilva.pos.biblioteca.service;

import br.com.dijalmasilva.pos.biblioteca.interfaces.ServiceInterface;
import br.com.dijalmasilva.pos.biblioteca.model.Autor;
import br.com.dijalmasilva.pos.biblioteca.model.Livro;
import br.com.dijalmasilva.pos.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 23/10/17.
 */
@Service
public class LivroService implements ServiceInterface<Livro> {

    @Autowired
    private LivroRepository dao;

    @Override
    public Livro save(Livro obj) {
        return dao.save(obj);
    }

    @Override
    public Livro edit(Long id, Livro obj) {
        Livro find = dao.findOne(id);
        find.setNome(obj.getNome());
        find.setAutores(obj.getAutores());
        return dao.save(find);
    }

    @Override
    public Livro findOne(Long id) {
        return dao.findOne(id);
    }

    @Override
    public List<Livro> findAll() {
        return (List<Livro>) dao.findAll();
    }

    @Override
    public void delete(Long id) {
        Livro find = dao.findOne(id);
        find.removeAllAutores();
        Livro update = dao.save(find);
        dao.delete(update);
    }

    @Override
    public void deleteAll() {
        Iterable<Livro> all = dao.findAll();
        for (Livro l : all) {
            l.removeAllAutores();
            dao.save(l);
        }
        dao.deleteAll();
    }

    public List<Livro> livrosDoAutor(Autor autor) {
        return dao.findLivroByAutores(autor);
    }
}
