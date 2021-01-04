package fr.greta.java.jpa.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="_cloture")
public class Cloture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _cloture_id;

    @Column(name = "_numero")
    private int numero;

    //----------------------------------------------------------

    public int get_cloture_id() {
        return _cloture_id;
    }

    public void set_cloture_id(int _cloture_id) {
        this._cloture_id = _cloture_id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
