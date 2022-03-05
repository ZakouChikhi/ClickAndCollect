package com.orleans.univ.microservices.servicecatalogue.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ItemRepository extends CrudRepository<Item, String> {


}
