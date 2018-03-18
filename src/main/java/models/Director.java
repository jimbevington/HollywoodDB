package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="directors")
public class Director extends Employee{

    private Set<Film> films;

    public Director() {
    }

    public Director(String name) {
        super(name);
    }

    @OneToMany(mappedBy = "director", fetch = FetchType.EAGER)
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
