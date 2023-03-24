package com.example.rest.books;

import java.util.Optional;

import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.mapping.MappingConfig;

// see https://deltaspike.apache.org/documentation/data.html

@Repository(forEntity = BookEntity.class)
@MappingConfig(BookDtoMapper.class)
public interface BookDtoRepository {

  Optional<BookDto> findOptionalBy(Long id);

}
