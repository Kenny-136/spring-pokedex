package io.nology.pokedex.pokemon;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{

	List<Pokemon> findByType(String type);
	
	List<Pokemon> findByHpGreaterThan(Integer hp);
}
