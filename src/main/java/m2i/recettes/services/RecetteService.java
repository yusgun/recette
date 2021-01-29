package m2i.recettes.services;

import m2i.recettes.repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecetteService {

    @Autowired
    private RecetteRepository repository;
}
