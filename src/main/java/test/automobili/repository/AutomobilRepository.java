package test.automobili.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import test.automobili.model.Automobil;

@Repository
public interface AutomobilRepository extends JpaRepository<Automobil, Long> {

	
	@Query("SELECT p FROM Automobil p WHERE (:cenaOd IS NULL or p.cena >= :cenaOd ) AND (:cenaDo IS NULL or p.cena <= :cenaDo ) AND"
			+ "(:godisteOd IS NULL or p.godiste >= :godisteOd) AND (:godisteDo IS NULL or p.godiste <= :godisteDo) AND"
			+ "(:model IS NULL or p.model.id >= :model) AND (:model IS NULL or p.model.id <= :model)" )
	Page<Automobil> pretrag (
			@Param("model") Long idMin,
			@Param("model") Long idMax,
			@Param("cenaOd") Double cenaOd,
			@Param("cenaDo") Double cenaDo,
			@Param("godisteOd") Integer godOd,
			@Param("godisteDo") Integer godDo,
			Pageable page);
}
