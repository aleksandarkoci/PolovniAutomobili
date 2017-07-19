package test.automobili.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import test.automobili.model.Automobil;

public interface AutomobilService {

	Page<Automobil> findAll(int pageNum);
	Automobil findOne(Long id);
	Automobil save (Automobil automobil);
	void delete (Long id);
	
	Page<Automobil> pretrag (
			@Param("model") Long idMin,
			@Param("model") Long idMax,
			@Param("cenaOd") Double cenaOd,
			@Param("cenaDo") Double cenaDo,
			@Param("godisteOd") Integer godOd,
			@Param("godisteDo") Integer godDo,
			int page);
}
