package tn.esprit.rh.achat.services.categorieproduit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.services.ICategorieProduitService;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategorieProduitServiceTest {
	
	@Autowired
	ICategorieProduitService cps;
	
	@Test
    @Order(1)
	 public void testRetrieveAllCategoriesProduits() {
	        List<CategorieProduit> listReglements = cps.retrieveAllCategorieProduits();
	        Assertions.assertEquals(0, listReglements.size());
	    }
	
	@Test
 	@Order(2)
 	public void addCategorieProduit() {
     CategorieProduit savedcategoriesproduit = cps.addCategorieProduit(new CategorieProduit(null,"xyz","xyz"));
     assertThat(savedcategoriesproduit.getIdCategorieProduit()).isGreaterThan(0);
 	}

	@Test
	@Order(3)
	public void testRetrieveCategorieProduit() {
	CategorieProduit categorieProduit = cps.retrieveCategorieProduit(7L);
	assertEquals(7L, categorieProduit.getIdCategorieProduit().longValue());
	}
	
	@Test
	@Order(4)
	public void testDeleteCategorieProduit() {
	cps.deleteCategorieProduit(13L);
	assertNull(cps.retrieveCategorieProduit(13L));
	}
	
		
		
}
