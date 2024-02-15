import java.util.*;
public class Movie {
    private String title;
    private String[] cast;
    private String director;
    private String overview;
    private int runtime;
    private double userRating;

    public Movie (String title, String[] cast, String director, String overview, int runtime, double userRating){
        this.cast = cast;
        this.title = title;
        this.director = director;
        this.overview = overview;
        this.runtime = runtime;
        this.userRating = userRating;
    }

    private String getTitle(){
        return title;
    }

    private String getDirector(){
        return director;
    }

    private String getOverview(){
        return overview;
    }

    private String[] getCast(){
        return cast;
    }
    private int getRuntime(){
        return runtime;
    }
    private double getUserRating(){
        return userRating;
    }
}
