package io.nology.pokedex.pokemon;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PokemonService {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
//	CREATE SERVICE
	public Pokemon create(CreatePokemonDTO data) {
		Pokemon newPokemon = modelMapper.map(data, Pokemon.class);
		Pokemon createdPokemon = this.pokemonRepository.save(newPokemon);
		return createdPokemon;
	}
	
//	GET SERVICE
	public List<Pokemon> findAll() {
		return this.pokemonRepository.findAll();
	}
	
	public Optional<Pokemon> findById(Long id) {
		Optional<Pokemon> maybePokemon = this.pokemonRepository.findById(id);
		
		return maybePokemon;
	}
	
//	UPDATE SERVICE
	public Optional<Pokemon> updateById(Long id, UpdatePokemonDTO data) {
		Optional<Pokemon> maybePokemon = this.findById(id);
		
		if(maybePokemon.isPresent()) {
			Pokemon existingPokemon = maybePokemon.get();
			modelMapper.map(data, existingPokemon);
			return Optional.of(this.pokemonRepository.save(existingPokemon));
		}
		
		return maybePokemon;
	}
			
	
	
//	DELETE SERVICE
	public boolean deleteById(Long id) {
		Optional<Pokemon> maybePokemon = this.findById(id);
		
		if(maybePokemon.isEmpty()) {
			return false;
		}
		
		this.pokemonRepository.delete(maybePokemon.get());
		return true;
	}
	
}
