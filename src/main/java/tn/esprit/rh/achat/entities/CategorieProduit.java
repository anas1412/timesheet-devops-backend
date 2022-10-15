package tn.esprit.rh.achat.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategorieProduit implements Serializable {

	public CategorieProduit(Long idCategorieProduit, String codeCategorie, String libelleCategorie) {
		// TODO Auto-generated constructor stub
		this.idCategorieProduit=idCategorieProduit;
		this.codeCategorie=codeCategorie;
		this.libelleCategorie=libelleCategorie;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategorieProduit;
	private String codeCategorie;
	private String libelleCategorie;
	@OneToMany(mappedBy = "categorieProduit")
	@JsonIgnore
	private Set<Produit> produits;
	
	public void setidCategorieProduit(Long idCategorieProduit) {
	    this.idCategorieProduit=idCategorieProduit;
	}
	 
	public Long getIdCategorieProduit() {
	    return this.idCategorieProduit;
	}
	
	public void setcodeCategorie(String codeCategorie) {
	    this.codeCategorie=codeCategorie;
	}
	 
	public String getCodeCategorie() {
	    return this.codeCategorie;
	}
}
