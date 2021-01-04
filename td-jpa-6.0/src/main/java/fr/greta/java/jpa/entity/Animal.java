package fr.greta.java.jpa.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="_animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _animal_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "_cloture_id")
    private Cloture cloture;

    @OneToMany(mappedBy = "animal")
    private Set<Regime> regimes;

    @Column(name = "_nom")
    private String nom;

    @Column(name = "_espece")
    private String espece;

    //----------------------------------------------------------

    public int get_animal_id() {
        return _animal_id;
    }

    public void set_animal_id(int _animal_id) {
        this._animal_id = _animal_id;
    }

    public Cloture getCloture() {
        return cloture;
    }

    public void setCloture(Cloture cloture) {
        this.cloture = cloture;
    }

    public Set<Regime> getRegimes() {
        if(regimes == null) {
            regimes = new HashSet<>();
        }
        return regimes;
    }

    public void setRegimes(Set<Regime> regimes) {
        this.regimes = regimes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }
}
