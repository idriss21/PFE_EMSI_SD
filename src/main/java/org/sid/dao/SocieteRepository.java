package org.sid.dao;

import org.sid.entities.Societe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;

public interface SocieteRepository extends JpaRepository<Societe, String>{
	/*@Query("select s from societe s where s.nom like :x")
	public Page<Societe> chercherparNom(@Param("x")String nom,Pageable pageable);*/
	
	@Query("select s from Societe s where s.nom like :x")
	public Page<Societe> chercherSociete(@Param("x")String mc,Pageable pageable);
	


}
