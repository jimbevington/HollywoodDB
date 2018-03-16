package models;

import java.util.HashSet;
import java.util.Set;

public class Actor {

    private int id;
    private String name;
    private Set<Film> films;

    public Actor() {
    }

    public Actor(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
