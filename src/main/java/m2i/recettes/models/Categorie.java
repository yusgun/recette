package m2i.recettes.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("categories")
public class Categorie {

    // attributs
    @Id
    private String id;
    private String nom;

    /**
     * Constructeur vide
     */
    public Categorie() {
    }

    /**
     * Constructeur avec paramètre
     * @param nom de la catégorie
     */
    public Categorie(String nom) {
        this.nom = nom;
    }
}
