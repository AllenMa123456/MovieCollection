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

    public String getTitle(){
        return title;
    }

    public String getDirector(){
        return director;
    }

    public String getOverview(){
        return overview;
    }

    public String[] getCast(){
        return cast;
    }
    public int getRuntime(){
        return runtime;
    }
    public double getUserRating(){
        return userRating;
    }
}
