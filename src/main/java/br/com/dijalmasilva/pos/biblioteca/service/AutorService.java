package br.com.dijalmasilva.pos.biblioteca.service;

import br.com.dijalmasilva.pos.biblioteca.interfaces.ServiceInterface;
import br.com.dijalmasilva.pos.biblioteca.model.Autor;
import br.com.dijalmasilva.pos.biblioteca.model.Livro;
import br.com.dijalmasilva.pos.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 23/10/17.
 */
@Service
public class AutorService implements ServiceInterface<Autor> {

    @Autowired
    private AutorRepository dao;
    @Autowired
    private LivroService livroService;

    @Override
    public Autor save(Autor obj) {
        return dao.save(obj);
    }

    @Override
    public Autor edit(Long id, Autor obj) {
        Autor find = dao.findOne(id);
        find.setNome(obj.getNome());
        return dao.save(find);
    }

    @Override
    public Autor findOne(Long id) {
        return dao.findOne(id);
    }

    @Override
    public List<Autor> findAll() {
        return (List<Autor>) dao.findAll();
    }

    @Override
    public void delete(Long id) {
        Autor autor = dao.findOne(id);
        List<Livro> livros = livroService.livrosDoAutor(autor);
        for (Livro l : livros) {
            l.removeAutor(autor);
            livroService.edit(l.getId(), l);
        }
        dao.delete(autor);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }
}
