package com.example.rest.books;

import java.util.Optional;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.mapping.MappingConfig;

// see https://deltaspike.apache.org/documentation/data.html

@Repository(forEntity = BookEntity.class)
@MappingConfig(BookDtoMapper.class)
public interface BookDtoRepository extends EntityRepository<BookDto, Long> {

  // when using findOptionalBy there is an exception:
  // org.apache.deltaspike.data.api.QueryInvocationException: Failed calling Repository:
  // [Repository=com.example.rest.books.BookDtoRepository,entity=com.example.rest.books.BookEntity,method=findOptionalBy,exception=class
  // java.lang.ClassCastException,message=class java.util.Optional cannot be cast to class
  // com.example.rest.books.BookEntity

  default Optional<BookDto> retrieveBy(Long id) {
    return Optional.ofNullable(findBy(id));
  }

}
