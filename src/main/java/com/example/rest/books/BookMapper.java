package com.example.rest.books;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

//for javaee9 use jsr330
//@Mapper(componentModel = "jsr330")
// for javaee8 use cdi
@Mapper(componentModel = "cdi")
public interface BookMapper {

  /**
   * Create a new entity instance from the DTO.
   *
   * @param dto
   * @return a new entity with id set to null since JPA shall generate a new id when saving a new entity to DB
   */
  @Mapping(target = "id", ignore = true)
  BookEntity createNewEntity(BookDto dto);

  /**
   * Update all fields in the entity with values from the DTO except the id since that is not allowed to be updated.
   *
   * @param dto
   * @param entity
   *          - entity to be updated with the values from the DTO
   */
  @Mapping(target = "id", ignore = true)
  void updateEntity(BookDto dto, @MappingTarget BookEntity entity);

}
