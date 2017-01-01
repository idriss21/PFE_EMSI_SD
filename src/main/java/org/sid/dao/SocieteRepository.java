package org.sid.dao;

import org.sid.entities.Societe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

public interface SocieteRepository  extends MongoRepository<Societe,Long>{
	

}
