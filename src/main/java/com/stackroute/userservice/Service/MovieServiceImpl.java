package com.stackroute.userservice.Service;

import com.stackroute.userservice.Exceptions.MovieAlreadyExistsException;
import com.stackroute.userservice.Exceptions.MovieNotFoundException;
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
    public boolean saveMovie(Movie movie) throws MovieAlreadyExistsException {
        if(movieRepository.existsById(movie.getId())){
            throw new MovieAlreadyExistsException();
        }
        Movie result=movieRepository.save(movie);
        if(result==null){
            throw new MovieAlreadyExistsException();

        }
            return true;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public boolean deleteMovie(long id) throws MovieNotFoundException {
        if(movieRepository.existsById(id)){
            movieRepository.deleteById(id);
            return true;
        }
        else throw new MovieNotFoundException();

    }

    @Override
    public boolean updateMovie(Movie movie) {
            movieRepository.save(movie);
            return true;
    }

    @Override
    public List<Movie> findByName(String string) throws MovieNotFoundException{
         List<Movie> result=movieRepository.findByTitle(string);
         if(result.isEmpty()){
             throw new MovieNotFoundException();
         }
         else return result;

    }


}
