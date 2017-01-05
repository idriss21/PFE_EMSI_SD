package org.sid.dao;

import java.util.Collection;

import org.sid.entities.Ordre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrdreRepository extends JpaRepository<Ordre, Long>{
	/*@Query("delete from Ordre o where o.societe.getCode() = :x")
	public void deleteOrdre(@Param("x")String code);*/
	
	@Query("select o from Ordre o where o.societe.code=:x") // query + order by o.dateOrdre 
	public Page<Ordre> listeOrdres(@Param("x")String  val , Pageable pageable);

	
}
