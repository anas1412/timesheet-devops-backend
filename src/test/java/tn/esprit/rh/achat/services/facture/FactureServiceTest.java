package tn.esprit.rh.achat.services.facture;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IFactureService;
import tn.esprit.rh.achat.services.IProduitService;

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


}
