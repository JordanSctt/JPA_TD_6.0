package fr.greta.java.jpa.entity;


import javax.persistence.*;

@Entity
@Table(name ="_regime")
public class Regime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _regime_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "_animal_id")
    private Animal animal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "_nourriture_id")
    private Nourriture nourriture;

    @Column(name = "_quantite")
    private int quantite;

    //----------------------------------------------------------

    public int get_regime_id() {
        return _regime_id;
    }

    public void set_regime_id(int _regime_id) {
        this._regime_id = _regime_id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Nourriture getNourriture() {
        return nourriture;
    }

    public void setNourriture(Nourriture nourriture) {
        this.nourriture = nourriture;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
