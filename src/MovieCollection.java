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
                Movie movie = new Movie(title, cast, director, overview, runtime, rating);
                movieList.add(movie);
            }
        } catch(IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void searchTitles(){
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<Integer> otherStuff = new ArrayList<>();
        System.out.print("Enter a search term: ");
        String searchTerm = scan.nextLine().toLowerCase();
        int count = 1;
        for (int i = 0; i < movieList.size(); i++){
            if (movieList.get(i).getTitle().toLowerCase().contains(searchTerm)){
                titles.add(movieList.get(i).getTitle());
                otherStuff.add(i);
            }
        }
        System.out.println();
        if (titles.isEmpty()){
            System.out.println("No movie titles match that search term!");
        } else {
            for (int i = 0; i < titles.size(); i++){
                insertionSortWordList(titles);
                System.out.println(count + ". " + titles.get(i));
                count++;
            }
            System.out.println();
            System.out.println("Which movie would you like to learn about?");
            System.out.print("Enter number: ");
            int choice = scan.nextInt();
            System.out.println();
            for (int i = 0; i < otherStuff.size(); i++){
                if (movieList.get(otherStuff.get(i)).getTitle().contains(titles.get(choice - 1))){
                    System.out.println("Title: " + movieList.get(otherStuff.get(i)).getTitle());
                    System.out.println("Runtime: " + movieList.get(otherStuff.get(i)).getRuntime() + " minutes");
                    System.out.println("Directed by: " + movieList.get(otherStuff.get(i)).getDirector());
                    System.out.println("Cast: " + movieList.get(otherStuff.get(i)).getCast());
                    System.out.println("Overview: " + movieList.get(otherStuff.get(i)).getOverview());
                    System.out.println("User Rating: " + movieList.get(otherStuff.get(i)).getUserRating());
                    break;
                }
            }
        }
        scan.nextLine();
        System.out.println();
    }

    private void searchCast(){
        ArrayList<String> people = new ArrayList<>();
        ArrayList<Integer> otherStuff = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        System.out.print("Enter a person to search for (first or last name): ");
        String searchTerm = scan.nextLine().toLowerCase();
        int count = 1;
        for (int i = 0; i < movieList.size(); i++){
            if (movieList.get(i).getCast().toLowerCase().contains(searchTerm)){
                String[] actors = movieList.get(i).getCast().split("\\|");
                for (int j = 0; j < actors.length; j++){
                    if (actors[j].toLowerCase().contains(searchTerm) && !(people.contains(actors[j]))){
                        people.add(actors[j]);
                        otherStuff.add(i);
                    }
                }
            }
        }
        if (people.isEmpty()){
            System.out.println("No results match your search");
        } else {
            for (int i = 0; i < people.size(); i++){
                insertionSortWordList(people);
                System.out.println(count + ". " + people.get(i));
                count++;
            }
            System.out.println();
            System.out.println("Which would you like to see all movies for?");
            System.out.print("Enter number: ");
            int choice = scan.nextInt();
            System.out.println();
            for (int i = 0; i < movieList.size(); i++){
                if (movieList.get(i).getCast().contains(people.get(choice - 1))){
                    titles.add(movieList.get(i).getTitle());
                }
            }
            insertionSortWordList(titles);
            count = 1;
            for (int i = 0; i < titles.size(); i++){
                System.out.println(count + ". " + titles.get(i));
                count++;
            }
            System.out.println();
            System.out.println("Which movie would you like to learn about?");
            System.out.print("Enter number: ");
            choice = scan.nextInt();
            System.out.println();

            for (int i = 0; i < movieList.size(); i++){
                if (movieList.get(i).getTitle().contains(titles.get(choice - 1))){
                    System.out.println("Title: " + movieList.get(i).getTitle());
                    System.out.println("Runtime: " + movieList.get(i).getRuntime() + " minutes");
                    System.out.println("Directed by: " + movieList.get(i).getDirector());
                    System.out.println("Cast: " + movieList.get(i).getCast());
                    System.out.println("Overview: " + movieList.get(i).getOverview());
                    System.out.println("User Rating: " + movieList.get(i).getUserRating());
                    break;
                }
            }
        }
        scan.nextLine();
        System.out.println();
    }

    public static void insertionSortWordList(ArrayList<String> words) {
        for (int i = 1; i < words.size(); i++){
            String str = words.get(i);
            int idx = i;
            while (idx > 0 && str.compareTo(words.get(idx - 1)) < 0){
                words.set(idx, words.get(idx - 1));
                idx--;
            }
            words.set(idx, str);
        }
    }










}
