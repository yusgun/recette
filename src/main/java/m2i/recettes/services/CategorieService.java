package m2i.recettes.services;

import m2i.recettes.models.Categorie;
import m2i.recettes.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository repository;

    public List<Categorie> findAll() {
        return this.repository.findAll();
    }

    public Categorie findById(String id) {
        return this.repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Categorie save(Categorie categorie) {
        return this.repository.insert(categorie);
    }

    public Categorie update(Categorie categorie) {
        return this.repository.save(categorie);
    }

    public void delete(String id) {
        this.repository.deleteById(id);
    }

    public List<Categorie> findByNom(String nom) {
        return this.repository.findByNomAllIgnoreCase(nom);
    }

}
