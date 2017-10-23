package br.com.dijalmasilva.pos.biblioteca.controller;

import br.com.dijalmasilva.pos.biblioteca.interfaces.RestControllerInterface;
import br.com.dijalmasilva.pos.biblioteca.model.Livro;
import br.com.dijalmasilva.pos.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 23/10/17.
 */
@RestController
@RequestMapping("/livro")
public class LivroController implements RestControllerInterface<Livro> {

    @Autowired
    private LivroService livroService;

    @PostMapping
    @Override
    public ResponseEntity<Livro> save(@RequestBody Livro livro) {
        Livro saved = livroService.save(livro);
        if (saved != null) {
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(new Livro(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Livro> edit(@PathVariable Long id, @RequestBody Livro livro) {
        Livro edit = livroService.edit(id, livro);
        if (edit != null) {
            return new ResponseEntity<>(edit, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Livro(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Livro> findOne(@PathVariable Long id) {
        Livro find = livroService.findOne(id);
        if (find != null) {
            return new ResponseEntity<>(find, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Livro(), HttpStatus.NOT_FOUND);
    }

    @GetMapping
    @Override
    public List<Livro> findAll() {
        return livroService.findAll();
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable Long id) {
        livroService.delete(id);
    }

    @DeleteMapping
    @Override
    public void deleteAll() {
        livroService.deleteAll();
    }
}
