package fr.greta.java.jpa.entity;


import javax.persistence.*;

@Entity
@Table(name ="_nourriture")
public class Nourriture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _nourriture_id;

    @Column(name = "_libelle")
    private String libelle;

    //----------------------------------------------------------

    public int get_nourriture_id() {
        return _nourriture_id;
    }

    public void set_nourriture_id(int _nourriture_id) {
        this._nourriture_id = _nourriture_id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
