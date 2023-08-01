package io.nology.pokedex.pokemon;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreatePokemonDTO {
	
	public enum AllowedType {
		Normal,
		Fire,
		Water,
		Grass,
		Electric,
		Ice,
		Fighting,
		Poison,
		Ground,
		Flying,
		Psychic,
		Bug,
		Rock,
		Ghost,
		Dark,
		Dragon,
		Steel,
		Fairy;
	}

	@NotBlank
	String name;
	
	@Enumerated(EnumType.STRING)
	public AllowedType type;
	
	@NotNull
	Integer hp;
	
	
	@NotBlank
	String imageLink;
	
	Integer evolutionId;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public AllowedType getType() {
		return type;
	}

	public void setType(AllowedType type) {
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

	public CreatePokemonDTO(String name, AllowedType type, Integer hp, String imageLink, Integer evolutionId) {
		this.name = name;
		this.type = type;
		this.hp = hp;
		this.imageLink = imageLink;
		this.evolutionId = evolutionId;
	}
}
