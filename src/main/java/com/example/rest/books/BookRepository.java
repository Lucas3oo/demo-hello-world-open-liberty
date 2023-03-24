package com.example.rest.books;

import java.util.Optional;

import org.apache.deltaspike.data.api.AbstractFullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;

// see https://deltaspike.apache.org/documentation/data.html

@Repository
public abstract class BookRepository extends AbstractFullEntityRepository<BookEntity, Long> {

  abstract Optional<BookEntity> findByDescription(String description);

  // old school projections so we don't fetch more data from DB than we need
  @Query(value = "SELECT new com.example.rest.books.BookDto(b.id, b.description) FROM BookEntity b WHERE b.id = :id")
  abstract Optional<BookDto> retrieveBy(@QueryParam("id") Long id);
}
