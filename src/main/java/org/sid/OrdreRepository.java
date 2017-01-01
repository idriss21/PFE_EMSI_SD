package org.sid.dao;

import org.sid.entities.Ordre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrdreRepository extends JpaRepository<Ordre, Long>{
	/*@Query("delete from Ordre o where o.societe.getCode() = :x")
	public void deleteOrdre(@Param("x")String code);*/
}
