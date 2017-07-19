package test.automobili.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.automobili.model.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

	List<Model> findByMarkaId(Long markaId);

}
