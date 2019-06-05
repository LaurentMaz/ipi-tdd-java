package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

public class EmployeTest {

    @Test
    public void testGetNombreAnneeAncienneteNow(){
        //Given
        Employe employe = new Employe();
        LocalDate dateEmbauche = LocalDate.now();
        employe.setDateEmbauche(dateEmbauche);

        //When
        Integer nbAnnee = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnnee).isEqualTo(0);
    }

    @Test
    public void testGetNombreAnneeAncienneteNull(){
        //Given
        Employe e = new Employe();
        e.setDateEmbauche(null);

        //When
        Integer nbAnnee = e.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnnee).isEqualTo(0);
    }

    @Test
    public void testGetNombreAnneeAncienneteNmoins2(){
        //Given
        Employe e = new Employe();
        e.setDateEmbauche(LocalDate.now().minusYears(2));

        //When
        Integer nbAnnee = e.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnnee).isEqualTo(2);
    }

    @Test
    public void testGetNombreAnneeAncienneteNplus2(){
        //Given
        Employe e = new Employe();
        e.setDateEmbauche(LocalDate.now().plusYears(2));

        //When
        Integer nbAnnee = e.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnnee).isEqualTo(0);
    }

    //Test a décommenter si le pourcentage est un Double (ici c'est un double)
    /*@Test
    public void testAugmenterSalaireNull(){
        //Given
        Employe e = new Employe();
        Double salaire = e.getSalaire();
        //When
        e.augmenterSalaire(null);
        //Then
        Assertions.assertThat(e.getSalaire()).isEqualTo(salaire);
    }*/

    ///////* TEST DE LA METHODE augmenterSalaire */////


    @Test
    public void testAugmenterSalaireZero(){
        //Given
        Employe e = new Employe();
        Double salaire = e.getSalaire();
        //When
        e.augmenterSalaire(0);
        //Then
        Assertions.assertThat(e.getSalaire()).isEqualTo(salaire);
    }

    @Test
    public void testAugmenterSalaireNegatif(){
        //Given
        Employe e = new Employe();
        Double salaire = e.getSalaire();
        //When
        e.augmenterSalaire(-0.5);
        //Then
        Assertions.assertThat(e.getSalaire()).isEqualTo(salaire);
    }

    @Test
    public void testAugmenterSalaireSpec(){
        //Given
        Employe e = new Employe();
        Double salaire = e.getSalaire();
        double pourcentage = 0.10;
        //When
        e.augmenterSalaire(pourcentage);
        //Then
        Assertions.assertThat(e.getSalaire()).isEqualTo(salaire*(1+pourcentage));
    }

    ///////* TEST DE LA METHODE GetNbRtt */////
    @ParameterizedTest(name = "date {0} possede rtt : {1} ")
    @CsvSource({"0, 9","2, 11"," 3, 11"," 13, 10"})
    public void testNbRTT(int date, int rtt){
        Employe emp = new Employe();
        Assertions.assertThat(emp.getNbRtt(LocalDate.now().plusYears(date))).isEqualTo(rtt);
    }


}
