package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="actors")
public class Actor {

    private int id;
    private String name;
    private int cash;
    private Set<Film> films;

    public Actor() {
    }

    public Actor(String name) {
        this.name = name;
        this.cash = 0;
        this.films = new HashSet<Film>();
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

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="cash")
    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @ManyToMany(mappedBy = "actors", fetch = FetchType.EAGER)
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public void addFilm(Film film){
        this.films.add(film);
    }

    public void increaseCash(int amount){
        this.cash += amount;
    }
}
