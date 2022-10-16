package tn.esprit.rh.achat.services.facture;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IFactureService;
import tn.esprit.rh.achat.services.IProduitService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FactureServiceTest {

    @Autowired
    IFactureService fs;

    @Test
    @Order(1)
    public void testRetrieveAllFactures() {
        List<Facture> listFactures = fs.retrieveAllFactures();
        Assertions.assertEquals(0, listFactures.size());
    }
    
    @Test
    @Order(2)
    public void testCreateStock() {
        Facture savedfacture = fs.addFacture(new Facture(1L, 100, 500, null, null, null, null, null, null)); 
        assertThat(savedfacture.getIdFacture()).isGreaterThan(0); 
    }

    @Test
    @Order(3)
    public void testRetrieveFacture() {
    	Facture facture = fs.retrieveFacture(1L);
    	assertEquals(1L, facture.getIdFacture().longValue());
    }
    



}
