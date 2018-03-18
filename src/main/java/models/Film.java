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
    private Studio studio;
    private Director director;
    private Set<Actor> actors;

    public Film() {
    }

    public Film(String title, int year, Studio studio, Director director) {
        this.title = title;
        this.year = year;
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
}
