import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Movie {
//    private int id;
    private String title;
    private double score;
    private int year;
    private int duration;
    private String rating;
    private int budget;
    private ArrayList<String> genres;
    private int gross;
    private String director;
    private ArrayList<String> actors;
    private String language;
    private String country;
    private int id;

    public Movie(String[] imdbRawData){
        this.title = imdbRawData[0];
        this.score = Double.parseDouble(imdbRawData[1]);
        this.year = Integer.parseInt(imdbRawData[2]);
        this.duration = Integer.parseInt(imdbRawData[3]);
        this.rating = imdbRawData[4];
        this.budget = Integer.parseInt(imdbRawData[5]);
        this.genres = new ArrayList<String>(Collections.singleton(imdbRawData[6]));
        this.gross = Integer.parseInt(imdbRawData[7]);
        this.director = imdbRawData[8];
        this.actors = new ArrayList<String>(Collections.singleton(imdbRawData[9]));
        this.language = imdbRawData[12];
        this.country = imdbRawData[13];
        this.id = Integer.parseInt(imdbRawData[14]);
    }

    public Movie() {

    }

    public String getTitle() {
        return title;
    }

    public double getScore() {
        return score;
    }

    public int getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }

    public String getRating() {
        return rating;
    }

    public int getBudget() {
        return budget;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public int getGross() { return gross; }

    public String getDirector() {
        return director;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public int getId() { return id; }

    public void setId() {
        this.id = id;
        Random random = new Random();
        random.nextInt(10000);  // 10000 is the max random number, change that to whatever you want
    }

}
