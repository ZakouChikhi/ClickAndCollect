package com.orleans.univ.microservices.servicecatalogue.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {


    List<Item> findAll();
    Optional<Item> findById(long s);

    List<Item> findByIdIn(List<Long> ids);
}
