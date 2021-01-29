package m2i.recettes.controllers;

import m2i.recettes.models.Categorie;
import m2i.recettes.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategorieController {

    @Autowired
    private CategorieService service;

    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public List<Categorie> findAll(){
        return this.service.findAll();
    }

    // READ
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Categorie findById(@PathVariable String id){
        return this.service.findById(id);
    }

    // UPDATE
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categorie save(@RequestBody Categorie categorie) {
        return this.service.save(categorie);
    }

    // PUT
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Categorie update(@PathVariable String id, @RequestBody Categorie categorie){
        Categorie oldCategorie = this.findById(id);
        categorie.setId(oldCategorie.getId());
        return this.service.update(categorie);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable String id){
        this.service.delete(id);
    }

    @GetMapping("/nom/{nom}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<Categorie> findByNom(@PathVariable String nom){
        return this.service.findByNom(nom);
    }

}
