package fr.greta.java.jpa.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="_soigneur")
public class Soigneur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _soigneur_id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "_soigneur_cloture",
            joinColumns = @JoinColumn(name = "_soigneur_id"),
            inverseJoinColumns = @JoinColumn(name = "_cloture_id"))
    private Set<Cloture> clotures;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "_animal_id")
    private Animal animaux;

    @Column(name = "_prenom")
    private String prenom;

    //----------------------------------------------------------

    public int get_soigneur_id() {
        return _soigneur_id;
    }

    public void set_soigneur_id(int _soigneur_id) {
        this._soigneur_id = _soigneur_id;
    }

    public Set<Cloture> getClotures() {
        if(clotures == null) {
            clotures = new HashSet<>();
        }
        return clotures;
    }

    public void setClotures(Set<Cloture> clotures) {
        this.clotures = clotures;
    }

    public Animal getAnimaux() {
        return animaux;
    }

    public void setAnimaux(Animal animaux) {
        this.animaux = animaux;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
