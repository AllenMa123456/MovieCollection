import java.util.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
public class MovieCollection {
    private Scanner scan;
    private ArrayList<Movie> movieList;

    public MovieCollection(){
        movieList = new ArrayList<>();
        scan = new Scanner(System.in);
        readData();
        start();
    }

    public void start(){
        System.out.println("Welcome to the movie collection!");
        String menuOption = "";

        while (!menuOption.equals("q")) {
            System.out.println("------------ Main Menu ----------");
            System.out.println("- search (t)itles");
            System.out.println("- search (c)ast");
            System.out.println("- (q)uit");
            System.out.print("Enter choice: ");
            menuOption = scan.nextLine();

            if (menuOption.equals("t")) {
                searchTitles();
            } else if (menuOption.equals("c")) {
                searchCast();
            } else if (menuOption.equals("q")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
        }

    }

    private void readData(){
        try {
            File myFile = new File("src\\movies_data.csv");
            Scanner fileScanner = new Scanner(myFile);
            fileScanner.nextLine();
            while (fileScanner.hasNext()) {
                String movies = fileScanner.nextLine();
                String[] splitData = movies.split(",");
                String title = splitData[0];
                String cast = splitData[1];
                String director = splitData[2];
                String overview = splitData[3];
                int runtime = Integer.parseInt(splitData[4]);
                double rating = Double.parseDouble((splitData[5]));
                String[] actors = cast.split("\\|");
                Movie movie = new Movie(title, actors, director, overview, runtime, rating);
                movieList.add(movie);
            }
        } catch(IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void searchTitles(){

    }

    private void searchCast(){

    }









}
