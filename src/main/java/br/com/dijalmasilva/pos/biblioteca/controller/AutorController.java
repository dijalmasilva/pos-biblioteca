package br.com.dijalmasilva.pos.biblioteca.controller;

import br.com.dijalmasilva.pos.biblioteca.interfaces.RestControllerInterface;
import br.com.dijalmasilva.pos.biblioteca.model.Autor;
import br.com.dijalmasilva.pos.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 23/10/17.
 */
@RestController
@RequestMapping("/autor")
public class AutorController implements RestControllerInterface<Autor> {

    @Autowired
    private AutorService autorService;

    @PostMapping
    @Override
    public ResponseEntity<Autor> save(@RequestBody Autor autor) {
        Autor saved = autorService.save(autor);
        if (saved != null) {
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new Autor(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Autor> edit(@PathVariable Long id, @RequestBody Autor autor) {
        Autor edit = autorService.edit(id, autor);
        if (edit != null) {
            return new ResponseEntity<>(edit, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Autor(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Autor> findOne(@PathVariable Long id) {
        Autor find = autorService.findOne(id);
        if (find != null) {
            return new ResponseEntity<>(find, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Autor(), HttpStatus.NOT_FOUND);
    }

    @GetMapping
    @Override
    public List<Autor> findAll() {
        return autorService.findAll();
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable Long id) {
        autorService.delete(id);
    }

    @DeleteMapping
    @Override
    public void deleteAll() {
        autorService.deleteAll();
    }
}
