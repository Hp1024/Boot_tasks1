package com.stackroute.userservice.Service;

import com.stackroute.userservice.Model.Movie;

import java.util.List;
public interface MovieService {
    public boolean saveMovie(Movie movie);
    public List<Movie> getAllMovies();
    public boolean deleteMovie(long id);
    public boolean updateMovie(Movie movie);
}
