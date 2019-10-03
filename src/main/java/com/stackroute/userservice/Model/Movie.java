package com.stackroute.userservice.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
@ApiModel(description = "All details about the Movies. ")
@Entity
public class Movie {

    @Id
    @ApiModelProperty(notes = "id of the movie")
    private long id;
    @ApiModelProperty(notes = "title of the movie")
    private String  original_title;
    @ApiModelProperty(notes = "language of the movie")
    private String  original_language;
    @ApiModelProperty(notes = "released date of the movie")
    private String  release_date;

    public Movie() {
    }

    public Movie(long id, String original_title, String original_language, String release_date) {
        this.id = id;
        this.original_title = original_title;
        this.original_language = original_language;
        this.release_date = release_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", original_title='" + original_title + '\'' +
                ", original_language='" + original_language + '\'' +
                ", release_date='" + release_date + '\'' +
                '}';
    }
}
