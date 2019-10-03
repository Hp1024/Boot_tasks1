package com.stackroute.userservice.Controller;
import com.stackroute.userservice.Model.Movie;
import com.stackroute.userservice.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userservice")
public class MovieController {
    private MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("movie")
    public ResponseEntity<?> getAllMoviesController(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }
    @PostMapping("movie")
    public ResponseEntity<?> saveMovieController(@RequestBody Movie movie){

        try {
            return new ResponseEntity<Boolean>(movieService.saveMovie(movie),HttpStatus.ACCEPTED);

        }
        catch (Exception ex){
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @PutMapping("movie")
    public ResponseEntity<?> updateMovieController(@RequestBody Movie movie){
        try {
            return new ResponseEntity<Boolean>(movieService.updateMovie(movie),HttpStatus.ACCEPTED);
        }
        catch (Exception ex){
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping("movie")
    public ResponseEntity<?> deleteMovieController(@RequestBody long id){
        try {
            return new ResponseEntity<Boolean>(movieService.deleteMovie(id),HttpStatus.ACCEPTED);
        }
        catch (Exception ex){
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
    }
}
