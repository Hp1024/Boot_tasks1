package com.stackroute.userservice.Controller;
import com.stackroute.userservice.Exceptions.MovieAlreadyExistsException;
import com.stackroute.userservice.Exceptions.MovieNotFoundException;
import com.stackroute.userservice.Model.Movie;
import com.stackroute.userservice.Service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Api(value="Movie Management System", description="Operations pertaining to movie in Movie Management System")
@RestController
@RequestMapping("/userservice")
public class MovieController {
    private MovieService movieService;
    @Value("${deleteId}")
    private long deleteId;
    @Value("${title}")
    private String title;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @ApiOperation(value = "View the list")
    @GetMapping("movie")
    public ResponseEntity<?> getAllMoviesController(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @ApiOperation(value = "Add a movie")
    @PostMapping("movie")
    public ResponseEntity<?> saveMovieController(@RequestBody Movie movie)throws MovieAlreadyExistsException  {
            return new ResponseEntity<Boolean>(movieService.saveMovie(movie),HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Update a movie")
    @PutMapping("movie")
    public ResponseEntity<?> updateMovieController(@RequestBody Movie movie){
            return new ResponseEntity<Boolean>(movieService.updateMovie(movie),HttpStatus.ACCEPTED);
    }
    @ApiOperation(value = "Delete a movie")
    @DeleteMapping("movie")
    public ResponseEntity<?> deleteMovieController() throws MovieNotFoundException {
            return new ResponseEntity<Boolean>(movieService.deleteMovie(deleteId),HttpStatus.ACCEPTED);
    }
    @ApiOperation(value = "Get a movie by title")
    @GetMapping("movie/title")
    public ResponseEntity<?> searchByNameController() throws MovieNotFoundException{
            return new ResponseEntity<List<Movie>>(movieService.findByName(title),HttpStatus.OK);
    }
}
