package m2i.recettes.repository;

import m2i.recettes.models.Recette;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetteRepository extends MongoRepository<Recette, String> {
}
