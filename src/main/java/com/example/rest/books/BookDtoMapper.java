package com.example.rest.books;

import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

public class BookDtoMapper extends SimpleQueryInOutMapperBase<BookEntity, BookDto> {

  @Override
  protected Object getPrimaryKey(BookDto dto) {
    return dto.getId();
  }

  @Override
  protected BookDto toDto(BookEntity entity) {
    return new BookDto(entity.getId(), entity.getDescription());
  }

  @Override
  protected BookEntity toEntity(BookEntity entity, BookDto dto) {
    throw new UnsupportedOperationException();
  }

}
