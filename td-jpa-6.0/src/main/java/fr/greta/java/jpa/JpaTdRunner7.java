package fr.greta.java.jpa;

import fr.greta.java.jpa.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaTdRunner7 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-unit");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        //----------------------------------
        Cloture cloture1 = new Cloture();
        cloture1.setNumero(1);

        Cloture cloture2 = new Cloture();
        cloture2.setNumero(2);

        Cloture cloture3 = new Cloture();
        cloture3.setNumero(3);

        //----------------------------------
        Nourriture nourriture1 = new Nourriture();
        nourriture1.setLibelle("Salade");

        Nourriture nourriture2 = new Nourriture();
        nourriture2.setLibelle("Granule");

        Nourriture nourriture3 = new Nourriture();
        nourriture3.setLibelle("Foin");

        Nourriture nourriture4 = new Nourriture();
        nourriture4.setLibelle("Grain");

        //----------------------------------
        Animal animal1 = new Animal();
        animal1.setCloture(cloture1);
        animal1.setNom("Fifi");
        animal1.setEspece("Chevre");

        Animal animal2 = new Animal();
        animal2.setCloture(cloture2);
        animal2.setNom("Denzel");
        animal2.setEspece("Cheval");

        Animal animal3 = new Animal();
        animal3.setCloture(cloture2);
        animal3.setNom("Galinor");
        animal3.setEspece("Cheval");

        Animal animal4 = new Animal();
        animal4.setCloture(cloture3);
        animal4.setNom("Panpan");
        animal4.setEspece("Lapin");

        Animal animal5 = new Animal();
        animal5.setCloture(cloture3);
        animal5.setNom("Tutur");
        animal5.setEspece("Lapin");

        //----------------------------------
        Regime regime1 = new Regime();
        regime1.setAnimal(animal1);
        regime1.setNourriture(nourriture3);
        regime1.setQuantite(1);
        animal1.getRegimes().add(regime1);

        Regime regime2 = new Regime();
        regime2.setAnimal(animal2);
        regime2.setNourriture(nourriture2);
        regime2.setQuantite(1);
        animal2.getRegimes().add(regime2);

        Regime regime3 = new Regime();
        regime3.setAnimal(animal2);
        regime3.setNourriture(nourriture3);
        regime3.setQuantite(2);
        animal2.getRegimes().add(regime3);

        Regime regime4 = new Regime();
        regime4.setAnimal(animal3);
        regime4.setNourriture(nourriture3);
        regime4.setQuantite(3);
        animal3.getRegimes().add(regime4);

        Regime regime5 = new Regime();
        regime5.setAnimal(animal4);
        regime5.setNourriture(nourriture1);
        regime5.setQuantite(2);
        animal4.getRegimes().add(regime5);

        Regime regime6 = new Regime();
        regime6.setAnimal(animal4);
        regime6.setNourriture(nourriture4);
        regime6.setQuantite(1);
        animal4.getRegimes().add(regime6);

        Regime regime7 = new Regime();
        regime7.setAnimal(animal5);
        regime7.setNourriture(nourriture1);
        regime7.setQuantite(2);
        animal5.getRegimes().add(regime7);

        //----------------------------------
        Soigneur soigneur1 = new Soigneur();
        soigneur1.getClotures().add(cloture1);
        soigneur1.getClotures().add(cloture2);
        soigneur1.setAnimaux(animal1);
        soigneur1.setPrenom("Anais");

        Soigneur soigneur2 = new Soigneur();
        soigneur2.getClotures().add(cloture2);
        soigneur2.getClotures().add(cloture3);
        soigneur2.setAnimaux(animal3);
        soigneur2.setPrenom("Manon");

        Soigneur soigneur3 = new Soigneur();
        soigneur3.getClotures().add(cloture1);
        soigneur3.getClotures().add(cloture2);
        soigneur3.getClotures().add(cloture3);
        soigneur3.setAnimaux(animal4);
        soigneur3.setPrenom("Jordan");

        //----------------------------------
        entityManager.persist(cloture1);
        entityManager.persist(cloture2);
        entityManager.persist(cloture3);

        entityManager.persist(animal1);
        entityManager.persist(animal2);
        entityManager.persist(animal3);
        entityManager.persist(animal4);
        entityManager.persist(animal5);

        entityManager.persist(soigneur1);
        entityManager.persist(soigneur2);
        entityManager.persist(soigneur3);

        entityManager.persist(nourriture1);
        entityManager.persist(nourriture2);
        entityManager.persist(nourriture3);
        entityManager.persist(nourriture4);

        entityManager.persist(regime1);
        entityManager.persist(regime2);
        entityManager.persist(regime3);
        entityManager.persist(regime4);
        entityManager.persist(regime5);
        entityManager.persist(regime6);
        entityManager.persist(regime7);
        //----------------------------------

        entityManager.getTransaction().commit();

        System.out.println("successfully saved");

        TypedQuery<Animal> query = entityManager.createQuery(
                "SELECT a FROM Animal a" +
                        " LEFT JOIN FETCH a.cloture cloture" +
                        " LEFT JOIN FETCH a.regimes regime", Animal.class);


        List<Animal> results = query.getResultList();

        for (Animal animaux : results) {
            System.out.println("Nom: " + animaux.getNom() + " - Espece: " + animaux.getEspece()
                    + " - cloture: " + animaux.getCloture().getNumero());

            for(Regime regimes:  animaux.getRegimes()) {
                System.out.println("Nourriture: " + regimes.getNourriture().getLibelle() + " - Quantite: " + regimes.getQuantite());
            }
            System.out.println(" ");
        }

        entityManager.close();
    }

}
