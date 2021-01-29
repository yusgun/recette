package m2i.recettes.controllers;

import m2i.recettes.services.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecetteController {

    @Autowired
    private RecetteService service;
}
