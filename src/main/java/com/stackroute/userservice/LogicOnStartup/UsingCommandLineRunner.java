package com.stackroute.userservice.LogicOnStartup;
import com.stackroute.userservice.Exceptions.MovieAlreadyExistsException;
import com.stackroute.userservice.Model.Movie;
import com.stackroute.userservice.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class UsingCommandLineRunner implements CommandLineRunner {
    private static MovieRepository movieRepository;
    private static Movie movie=new Movie();
    @Autowired
    public UsingCommandLineRunner(MovieRepository movieRepository) {
        this.movieRepository=movieRepository;
    }
    @Override
    public void run(String... args) throws MovieAlreadyExistsException {
        movie.setId(2);
        movie.setOriginal_title("Om Shanti Oshana");
        movie.setOriginal_language("Malayalam");
        movie.setRelease_date("15-06-2011");
        movieRepository.save(movie);
    }
}
