package com.chaima.livres.service;

import java.util.List;

import com.chaima.livres.dto.LivreDTO;
import com.chaima.livres.entities.Bibliotheque;
import com.chaima.livres.entities.Livre;

public interface LivreService {
	LivreDTO saveLivre(LivreDTO p);
	LivreDTO updateLivre(LivreDTO p);
	 void deleteLivre(Livre p);
    void deleteLivreById(Long id);
    LivreDTO getLivre(Long id);

	 List<LivreDTO> getAllLivres();
	 
	 List<Livre> findByTitreLivre(String titre);
	 List<Livre> findByTitreLivreContains(String titre);
	 List<Livre> findByTitrePrix (String titre, Double prix);
	 List<Livre> findByBibliotheque (Bibliotheque  Bibliotheque );
	 List<Livre> findByBibliothequeIdBib(Long id);
	 List<Livre> findByOrderByTitreLivreAsc();
	 List<Livre> trierLivresTitresPrix();
	 
	 LivreDTO convertEntityToDto (Livre livre);
	Livre convertDtoToEntity(LivreDTO livreDto);
	
}
