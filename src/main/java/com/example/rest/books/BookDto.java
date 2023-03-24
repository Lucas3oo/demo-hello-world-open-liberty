package com.example.rest.books;

public class BookDto {

  private String mId;
  private String mDescription;

  public BookDto() {
  }

  public BookDto(String description) {
    super();
    mDescription = description;
  }

  public BookDto(String id, String description) {
    super();
    mId = id;
    mDescription = description;
  }

  public BookDto(Long id, String description) {
    super();
    mId = id.toString();
    mDescription = description;
  }

  public void setId(String id) {
    mId = id;
  }

  public void setId(Long id) {
    mId = id.toString();
  }

  public String getId() {
    return mId;
  }

  public void setDescription(String description) {
    mDescription = description;
  }

  public String getDescription() {
    return mDescription;
  }

}
