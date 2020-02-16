package com.example.routingandfilteringbook.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the Book. ")
public class Book {

  @ApiModelProperty(notes = "The Book ID")
  private String id;

  @ApiModelProperty(notes = "Name of the Book")
  private String name;

  public Book(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
