package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="actors")
public class Actor extends Employee {

    private Set<Film> films;

    public Actor() {
    }

    public Actor(String name) {
        super(name);
        this.films = new HashSet<Film>();
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

}
