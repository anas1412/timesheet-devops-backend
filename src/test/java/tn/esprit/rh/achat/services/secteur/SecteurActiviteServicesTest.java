package tn.esprit.rh.achat.services.secteur;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.services.ISecteurActiviteService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class SecteurActiviteServicesTest {

	
	 @Autowired
	    ISecteurActiviteService s;
	 
	 @Test
	    @Order(1)
	    public void retrieveAllSecteurActivite() {
	        List<SecteurActivite> listSecteur = s.retrieveAllSecteurActivite();
	        Assertions.assertEquals(0, listSecteur.size());
	    }
	 @Test
	 	@Order(2)
	 	public void addSecteurActivite() {
	     SecteurActivite savedsecteur = s.addSecteurActivite(new SecteurActivite(null, "achref","aaaa", null));
	      
	     assertThat(savedsecteur.getIdSecteurActivite()).isGreaterThan(0);
	 	}
	 @Test
	 @Order(3)
	 public void testRetrieveSecteur() {
	 SecteurActivite secteur = s.retrieveSecteurActivite(3L);
	 assertEquals(3L, secteur.getIdSecteurActivite().longValue());
	 }
	 @Test
	 @Order(4)
	 public void testDeleteSecteur() {
	 s.deleteSecteurActivite(4L);
	 assertNull(s.retrieveSecteurActivite(4L));
	 }
	
	 
}
