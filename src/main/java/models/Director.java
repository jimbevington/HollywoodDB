package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="directors")
public class Director {

    private int id;
    private String name;
    private Set<Film> films;

    public Director() {
    }

    public Director(String name) {
        this.name = name;
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

    @OneToMany(mappedBy = "director", fetch = FetchType.EAGER)
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
