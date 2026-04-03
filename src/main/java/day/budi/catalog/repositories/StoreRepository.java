package day.budi.catalog.repositories;

import org.springframework.data.repository.CrudRepository;

import day.budi.catalog.entities.Store;

public interface StoreRepository extends CrudRepository<Store, Long> {
    //
}
