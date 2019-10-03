package com.stackroute.userservice.Controller;
import com.stackroute.userservice.Model.Movie;
import com.stackroute.userservice.Service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

@Api(value="Movie Management System", description="Operations pertaining to movie in Movie Management System")
@RestController
@RequestMapping("/userservice")
public class MovieController {
    private MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @ApiOperation(value = "View a list of available movies", response = List.class)
    @GetMapping("movie")
    public ResponseEntity<?> getAllMoviesController(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @ApiOperation(value = "Add a movie")
    @PostMapping("movie")
    public ResponseEntity<?> saveMovieController(@RequestBody Movie movie){

        try {
            return new ResponseEntity<Boolean>(movieService.saveMovie(movie),HttpStatus.ACCEPTED);

        }
        catch (Exception ex){
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @ApiOperation(value = "Update a movie")
    @PutMapping("movie")
    public ResponseEntity<?> updateMovieController(@RequestBody Movie movie){
        try {
            return new ResponseEntity<Boolean>(movieService.updateMovie(movie),HttpStatus.ACCEPTED);
        }
        catch (Exception ex){
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @ApiOperation(value = "Delete a movie")
    @DeleteMapping("movie/{id}")
    public ResponseEntity<?> deleteMovieController(@PathVariable("id") long id){
        try {
            return new ResponseEntity<Boolean>(movieService.deleteMovie(id),HttpStatus.ACCEPTED);
        }
        catch (Exception ex){
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
    }
    @ApiOperation(value = "Get a movie by title")
    @GetMapping("movie/{title}")
    public ResponseEntity<?> searchByNameController(@PathVariable("title") String string){
        try {
            return new ResponseEntity<List<Movie>>(movieService.findByName(string),HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
    }
}
