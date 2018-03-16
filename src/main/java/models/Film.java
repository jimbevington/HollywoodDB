package models;

public class Film {

    private int id;
    private String title;
    private int year;
    private Studio studio;
    private Director director;
    private Set<Actor> actors;

    public Film() {
    }

    public Film(String title, int year, Studio studio, Director director, Set<Actor> actors) {
        this.title = title;
        this.year = year;
        this.studio = studio;
        this.director = director;
        this.actors = actors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }
}
