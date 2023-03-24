package com.example.rest.books;

import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/api/v1/books")
public class BookController {

  private static final Logger sLogger = LoggerFactory.getLogger(BookController.class);

  @Inject
  private BookRepository mRepository;

  @Inject
  private BookMapper mMapper;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public Long create(@Valid BookDto dto) {
    sLogger.info("in create method");
    BookEntity entity = mMapper.createNewEntity(dto);
    // save and flush so we can get the ID of the entity since the DB is generating the ID.
    Long id = mRepository.saveAndFlush(entity).getId();
    sLogger.info("in create method - created with id: {}", id);
    return id;
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public BookDto getById(@PathParam("id") Long id) {
    // TODO can't get debug log message on the console log
    sLogger.info("in getById method, id: {}", id);
    Optional<BookDto> dto = mRepository.retrieveBy(id);
    // TODO empty Optional will be translated to 200, not really a good option
    return dto.orElseThrow(() -> new NotFoundException("Book with id '" + id + "' not found"));
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Transactional
  public void update(@PathParam("id") Long id, @Valid BookDto dto) {
    sLogger.info("in update method, id: {}", id);
    if (!id.equals(NumberUtils.createLong(dto.getId()))) {
      throw new BadRequestException("Id in path and id in DTO are not the same.");
    }
    BookEntity entity = mRepository.findOptionalBy(id)
        .orElseThrow(() -> new NotFoundException("Book with id '" + id + "' not found"));
    mMapper.updateEntity(dto, entity);
  }

}
