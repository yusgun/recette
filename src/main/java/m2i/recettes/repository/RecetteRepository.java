package m2i.recettes.repository;

import m2i.recettes.models.Recette;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetteRepository extends MongoRepository<Recette, String> {
    public List<Recette> findByNomAllIgnoreCase(String nom);
    public List<Recette> findByCategories(String nom);
}
