package com.chaima.livres.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.chaima.livres.dto.LivreDTO;
import com.chaima.livres.entities.Bibliotheque;
import com.chaima.livres.entities.Livre;
import com.chaima.livres.repos.LivreRepository;


@Service
public class LivreServiceImpl implements LivreService {

	@Autowired
	LivreRepository  livreRepository;
	

@Autowired
ModelMapper modelMapper;

	@Override
	public LivreDTO saveLivre(LivreDTO p) {
		return convertEntityToDto(livreRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public LivreDTO updateLivre(LivreDTO p) {
		return convertEntityToDto(livreRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public void deleteLivre(Livre p) {
		 livreRepository.delete(p);
	}

	@Override
	public void deleteLivreById(Long id) {
		 livreRepository.deleteById(id);
	}

	@Override
	public LivreDTO getLivre(Long id) {
		return  convertEntityToDto(livreRepository.findById(id).get());
	}

	@Override
	public List<LivreDTO> getAllLivres() {
		return livreRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());

	}

	@Override
	public List<Livre> findByTitreLivre(String titre) {
		return livreRepository. findByTitreLivre(titre);
	}

	@Override
	public List<Livre> findByTitreLivreContains(String titre) {
		return livreRepository.findByTitreLivreContains(titre);
	}

	@Override
	public List<Livre> findByTitrePrix(String titre, Double prix) {
		return livreRepository.findByTitrePrix(titre, prix);
	}

	@Override
	public List<Livre> findByBibliotheque(Bibliotheque bibliotheque) {
		return livreRepository. findByBibliotheque(bibliotheque);
	}

	@Override
	public List<Livre> findByBibliothequeIdBib(Long id) {
		return livreRepository.findByBibliothequeIdBib(id);
	}

	@Override
	public List<Livre> findByOrderByTitreLivreAsc() {
		return livreRepository.findByOrderByTitreLivreAsc();
	}

	@Override
	public List<Livre> trierLivresTitresPrix() {
		return livreRepository.trierLivresTitresPrix();
	}
	

	@Override
	public LivreDTO convertEntityToDto(Livre livre) {
		
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		LivreDTO livreDTO=  modelMapper.map(livre, LivreDTO.class);
		
		return livreDTO;
		
		
	}

	@Override
	public Livre convertDtoToEntity(LivreDTO livreDTO) {
		
		Livre livre = new Livre();
	livre = modelMapper.map(livreDTO, Livre.class);
		   return livre;
		
		
	}

}




