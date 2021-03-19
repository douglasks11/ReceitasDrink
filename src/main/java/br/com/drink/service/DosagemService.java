package br.com.drink.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.drink.dto.DosagemRequest;
import br.com.drink.dto.DosagemResponse;
import br.com.drink.entity.DosagemEntity;
import br.com.drink.exception.NotFoundException;
import br.com.drink.repository.DosagemRepository;

@Service
public class DosagemService {
	
	@Autowired
	private DosagemRepository dosagemRepository;
	
	public List<DosagemResponse> findAll() {
		return dosagemRepository.findAll().stream().map(DosagemResponse::new).collect(Collectors.toList());
	}
	
	public DosagemResponse findById(Long id) {
		return new DosagemResponse(findEntityById(id));
	}
	
	public DosagemEntity findEntityById(Long id) {
		return dosagemRepository.findById(id)
					.orElseThrow(() -> new NotFoundException("tipo de dosagem not found with the entered id."));
	}

	public DosagemResponse create(DosagemRequest dosagemRequest) {
		return new DosagemResponse(dosagemRepository.save(
				DosagemEntity.builder().tipo(dosagemRequest.getTipo()).build()
					)
				);
										
	}

	public DosagemResponse update(Long id, DosagemRequest dosagemRequest) {
		var dosagem = findEntityById(id);
		var updated = dosagemRepository.save(dosagem.update(dosagemRequest));
		return new DosagemResponse(updated);
	}

	public void delete(Long id) {
		var dosagem = findEntityById(id);
		dosagemRepository.delete(dosagem);
	}

}
