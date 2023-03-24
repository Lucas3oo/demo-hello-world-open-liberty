package com.example.rest.books;

import java.util.Optional;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

// see https://deltaspike.apache.org/documentation/data.html

@Repository
public interface BookRepository extends EntityRepository<BookEntity, Long> {

  Optional<BookEntity> findByDescription(String description);
}
