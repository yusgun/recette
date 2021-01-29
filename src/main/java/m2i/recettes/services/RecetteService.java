package m2i.recettes.services;

import m2i.recettes.models.Categorie;
import m2i.recettes.models.Ingredient;
import m2i.recettes.models.Recette;
import m2i.recettes.repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecetteService {

    @Autowired
    private RecetteRepository repository;

    public List<Recette> findAll() {
        return this.repository.findAll();
    }

    public Recette findById(String id) {
        return this.repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Recette save(Recette recette) {
        return this.repository.insert(recette);
    }

    public Recette update(Recette recette) {
        return this.repository.save(recette);
    }

    public void delete(String id) {
        this.repository.deleteById(id);
    }

    public List<Recette> findByNom(String nom) {
        return this.repository.findByNomAllIgnoreCase(nom);
    }

    public Recette ajouterListeIngredients(String id, List<Ingredient> ingredients) {
        Recette recette = this.findById(id);
        recette.setIngredients(ingredients);
        return this.repository.save(recette);
    }

    public Recette ajouterUnIngredient(String id, Ingredient ingredient) {
        Recette recette = this.findById(id);
        if(recette.getIngredients() == null){
            recette.setIngredients(new ArrayList<Ingredient>());
        }
        recette.getIngredients().add(ingredient);
        return this.repository.save(recette);
    }

    public Recette ajouterListeCategories(String id, List<Categorie> categories) {
        Recette recette = this.findById(id);
        recette.setCategories(categories);
        return this.repository.save(recette);
    }

    public Recette ajouterUneCategorie(String id, Categorie categorie) {
        Recette recette = this.findById(id);
        if(recette.getCategories() == null){
            recette.setCategories(new ArrayList<Categorie>());
        }
        recette.getCategories().add(categorie);
        return this.repository.save(recette);
    }

    public Recette supprimerUneCategorie(String id, Categorie categorie) {
        Recette recette = this.findById(id);
        recette.getCategories().remove(categorie);
        return this.repository.save(recette);
    }

    public List<Recette> findByCategorie(Categorie categorie) {
        return this.repository.findByCategories(categorie);
    }
}
