package com.stackroute.userservice.LogicOnStartup;
import com.stackroute.userservice.Model.Movie;
import com.stackroute.userservice.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
public class UsingApplicationListener implements ApplicationListener<ContextRefreshedEvent>   {
    private static MovieRepository movieRepository;
    private static Movie movie=new Movie();
    @Autowired
    public UsingApplicationListener(MovieRepository movieRepository) {
        this.movieRepository=movieRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        movie.setId(1);
        movie.setOriginal_title("Bangalore Days");
        movie.setOriginal_language("Malayalam");
        movie.setRelease_date("20-02-2014");
        movieRepository.save(movie);
    }
}
