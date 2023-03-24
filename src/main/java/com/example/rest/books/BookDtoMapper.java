package com.example.rest.books;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

@ApplicationScoped
public class BookDtoMapper extends SimpleQueryInOutMapperBase<BookEntity, BookDto> {

  @Inject
  private BookMapper mMapper;

  @Override
  protected Object getPrimaryKey(BookDto dto) {
    return dto.getId();
  }

  @Override
  protected BookDto toDto(BookEntity entity) {
    return mMapper.toDto(entity);
  }

  @Override
  protected BookEntity toEntity(BookEntity entity, BookDto dto) {
    throw new UnsupportedOperationException();
  }

}
