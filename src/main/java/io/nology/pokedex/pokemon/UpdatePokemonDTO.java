package io.nology.pokedex.pokemon;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdatePokemonDTO {
	@NotBlank
	String name;
	
	@NotBlank
	String type;
	
	
	@NotNull
	Integer hp;
	
	
	@NotBlank
	String imageLink;
	
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

	Integer evolutionId;
}
