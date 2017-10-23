package br.com.dijalmasilva.pos.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank"> Dijalma Silva </a> on 23/10/17.
 */
@Controller
public class DefaultController {

    @GetMapping(value = {"/", "/index"})
    String index() {
        return "index";
    }
}
