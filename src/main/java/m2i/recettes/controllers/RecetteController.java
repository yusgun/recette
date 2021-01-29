package m2i.recettes.controllers;

import m2i.recettes.models.Categorie;
import m2i.recettes.models.Ingredient;
import m2i.recettes.models.Recette;
import m2i.recettes.services.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recettes")
public class RecetteController {

    @Autowired
    private RecetteService service;

    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public List<Recette> findAll(){
        return this.service.findAll();
    }

    // READ
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Recette findById(@PathVariable String id){
        return this.service.findById(id);
    }

    // UPDATE
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Recette save(@RequestBody Recette recette) {
        return this.service.save(recette);
    }

    // PUT
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Recette update(@PathVariable String id, @RequestBody Recette recette){
        Recette oldRecette = this.findById(id);
        recette.setId(oldRecette.getId());
        return this.service.update(recette);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable String id){
        this.service.delete(id);
    }

    @GetMapping("/nom/{nom}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<Recette> findByNom(@PathVariable String nom){
        return this.service.findByNom(nom);
    }

    @PostMapping("/{id}/ingredients/ajouterListe")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Recette ajouterListeIngredients(@PathVariable String id, @RequestBody List<Ingredient> ingredients){
        return this.service.ajouterListeIngredients(id, ingredients);
    }

    @PostMapping("/{id}/ingredients/ajouter")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Recette ajouterUnIngredient(@PathVariable String id, @RequestBody Ingredient ingredient){
        return this.service.ajouterUnIngredient(id, ingredient);
    }

    @PostMapping("/{id}/categories/ajouterListe")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Recette ajouterListeCategories(@PathVariable String id, @RequestBody List<Categorie> categories){
        return this.service.ajouterListeCategories(id, categories);
    }

    @PostMapping("/{id}/categories/ajouter")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Recette ajouterUneCategorie(@PathVariable String id, @RequestBody Categorie categorie){
        return this.service.ajouterUneCategorie(id, categorie);
    }

    @DeleteMapping("/{id}/categories/supprimer")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Recette supprimerUneCategorie(@PathVariable String id, @RequestBody Categorie categorie){
        return this.service.supprimerUneCategorie(id, categorie);
    }

    @GetMapping("/categories/{categorie}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<Recette> findByCategorie(@PathVariable Categorie categorie){
        return this.service.findByCategorie(categorie);
    }

}
