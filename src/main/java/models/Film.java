package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="films")
public class Film {

    private int id;
    private String title;
    private int year;
    private int budget;
    private String genre;
    private Studio studio;
    private Director director;
    private Set<Actor> actors;

    public Film() {
    }

    public Film(String title, int year, int budget, String genre,  Studio studio, Director director) {
        this.title = title;
        this.year = year;
        this.budget = budget;
        this.genre = genre;
        this.studio = studio;
        this.director = director;
        this.actors = new HashSet<Actor>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Column(name="budget")
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Column(name="genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @ManyToOne
    @JoinColumn(name="studio", nullable = false)
    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    @ManyToOne
    @JoinColumn(name="director", nullable = false)
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(name="actors_films",
                joinColumns = {@JoinColumn(name="actor_id", nullable = false, updatable = false)},
                inverseJoinColumns = {@JoinColumn(name="film_id", nullable = false, updatable = false)})
    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public void addActor(Actor actor){
        this.actors.add(actor);
    }

    public void removeActor(Actor actor){
//        choose to remove the actor by matching Actor IDs, rather than object
        for (Actor a : this.actors){
            if (a.getId() == actor.getId()){
                this.actors.remove(a);
            }
        }
    }

    public void decreaseBudget(int amount){
        this.budget -= amount;
    }
}
