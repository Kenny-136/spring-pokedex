package io.nology.pokedex.pokemon;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String type;
	
	@Column
	private Integer hp;
	
	@Column
	private String imageLink;
	
	@Column(nullable = true)
	private Integer evolutionId;
	
	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Integer getEvolutionId() {
		return evolutionId;
	}

	public void setEvolutionId(Integer evolutionId) {
		this.evolutionId = evolutionId;
	}

	public Pokemon() {}
	
	public Pokemon(String name, String type, Integer hp, String imageLink, Integer evolutionId) {
		super();
		this.name = name;
		this.type = type;
		this.hp = hp;
		this.imageLink = imageLink;
		this.evolutionId = evolutionId;
	}
}
