package io.nology.pokedex.pokemon;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.nology.pokedex.exceptions.NotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	private PokemonService pokemonService;
	
	
//	Create
	@PostMapping
	public ResponseEntity<Pokemon> createPokemon(@Valid @RequestBody CreatePokemonDTO data) {
		Pokemon createdPokemon = this.pokemonService.create(data);
		return new ResponseEntity<>(createdPokemon, HttpStatus.CREATED);
	}
	
	
//	READ
//	@GetMapping
//	public ResponseEntity<List<Pokemon>> getAll(@RequestParam(required = false) String type , Integer minHp) {
//		if  (type != null) {
//			List<Pokemon> allPokemon = this.pokemonService.findByType(type);
//			if(allPokemon.isEmpty()) {
//				throw new NotFoundException(String.format("Pokemon with type: %s not found, are you sure it is the correct type?", type));
//			}
//			return new ResponseEntity<>(allPokemon, HttpStatus.OK);			
//		} else if (minHp != null){
//			List<Pokemon> allPokemon = this.pokemonService.findByHpGreaterThan(minHp);
//			if(allPokemon.isEmpty()) {
//				throw new NotFoundException(String.format("Pokemon with hp less than: %s not found.", minHp));
//			}
//			return new ResponseEntity<>(allPokemon, HttpStatus.OK);		
//		} else if (type == null && minHp == null) {
//			List<Pokemon> allPokemon = this.pokemonService.findAll();
//			return new ResponseEntity<>(allPokemon, HttpStatus.OK);		
//		} else {
//			throw new NotFoundException(String.format("Invalid Parameter"));
//		}
//	}
	
	@GetMapping
	public ResponseEntity<List<Pokemon>> getAll(@RequestParam(required = false) Map<String, String> allParams) {
		if  (allParams.containsKey("type")) {
			String type = allParams.get("type");
			List<Pokemon> allPokemon = this.pokemonService.findByType(type);
			if(allPokemon.isEmpty()) {
				throw new NotFoundException(String.format("Pokemon with type: %s not found, are you sure it is the correct type?", type));
			}
			return new ResponseEntity<>(allPokemon, HttpStatus.OK);			
		} else if (allParams.containsKey("minHp")){
			String StringMinHp = allParams.get("minHp");
			Integer minHp = Integer.parseInt(StringMinHp);
			List<Pokemon> allPokemon = this.pokemonService.findByHpGreaterThan(minHp);
			if(allPokemon.isEmpty()) {
				throw new NotFoundException(String.format("Pokemon with hp less than: %s not found.", minHp));
			}
			return new ResponseEntity<>(allPokemon, HttpStatus.OK);		
		} else if (allParams.isEmpty()) {
			List<Pokemon> allPokemon = this.pokemonService.findAll();
			return new ResponseEntity<>(allPokemon, HttpStatus.OK);		
		} else {
			throw new NotFoundException(String.format("Invalid Parameter"));
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pokemon> getById(@PathVariable Long id) {
		Optional<Pokemon> foundPokemon = this.pokemonService.findById(id);
		
		if(foundPokemon.isEmpty()) {
			throw new NotFoundException(String.format("Post with id: %s not found", id));
		}
		return new ResponseEntity<>(foundPokemon.get(), HttpStatus.OK);
	}
	
//	UPDATE
	@PatchMapping("/{id}")
	public ResponseEntity<Pokemon> updateById(@PathVariable Long id,
			@Valid @RequestBody UpdatePokemonDTO data) {
		Optional<Pokemon> maybeUpdated = this.pokemonService.updateById(id, data);
		if(maybeUpdated.isEmpty()) {
			throw new NotFoundException(String.format(
					"Pokemon with id: %s not found, could not update", 
					id));
		}
		
		return new ResponseEntity<Pokemon>(maybeUpdated.get(), HttpStatus.OK);
	}
	
	
//	DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Pokemon> deletebyId(@PathVariable Long id) {
		boolean deleted = this.pokemonService.deleteById(id);
		
		if(!deleted) {
			throw new NotFoundException(String.format(
					"Post with id: %s not found, could not delete.", 
					id));
		}
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
}
