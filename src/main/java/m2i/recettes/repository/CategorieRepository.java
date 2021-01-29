package m2i.recettes.repository;

import jdk.jfr.Category;
import m2i.recettes.models.Categorie;
import m2i.recettes.models.Recette;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository extends MongoRepository<Categorie, String> {
    public List<Categorie> findByNomAllIgnoreCase(String nom);
}
