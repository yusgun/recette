package m2i.recettes.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("recettes")
public class Recette {

    // attributs
    @Id
    private String id;
    private String nom;
    private List<Ingredient> ingredients;
    @DBRef
    private List<Categorie> categories;
    private String description;

    /**
     * Constructeur vide
     */
    public Recette() {
    }

    /**
     * Constructeur avec paramètres
     * @param nom de la recette
     * @param ingredients de la recette
     * @param categories de la recette
     * @param description de la recette
     */
    public Recette(String nom, List<Ingredient> ingredients, List<Categorie> categories, String description) {
        this.nom = nom;
        this.ingredients = ingredients;
        this.categories = categories;
        this.description = description;
    }
}
