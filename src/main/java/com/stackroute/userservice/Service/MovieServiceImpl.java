package com.stackroute.userservice.Service;

import com.stackroute.userservice.Model.Movie;
import com.stackroute.userservice.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public boolean saveMovie(Movie movie) {
            movieRepository.save(movie);
            return true;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public boolean deleteMovie(long id) {

        movieRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateMovie(Movie movie) {
            movieRepository.save(movie);
            return true;
    }

    @Override
    public List<Movie> findByName(String string) {
        System.out.println(movieRepository.findByTitle(string));
        return movieRepository.findByTitle(string);

    }


}
