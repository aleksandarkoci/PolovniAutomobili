package test.automobili.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.automobili.model.Marka;

@Repository
public interface MarkaRepository extends JpaRepository<Marka, Long> {

}
