package m2i.recettes.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("ingredients")
public class Ingredient {

    // attributs
    @Id
    private String id;
    private String nom;
    private double quantite;
    private int unite;

    /**
     * Constructeur vide
     */
    public Ingredient() {
    }

    /**
     * Constructeur avec paramètres
     * @param nom de l'ingrédient
     * @param quantite de l'ingrédient
     * @param unite de l'ingrédient
     */
    public Ingredient(String nom, double quantite, int unite) {
        this.nom = nom;
        this.quantite = quantite;
        this.unite = unite;
    }
}
