import db.DBHelper;
import models.Actor;
import models.Director;
import models.Film;
import models.Studio;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {

        Studio studio1 = new Studio("All American Action Films Inc");
        DBHelper.saveOrUpdate(studio1);

        Director director1 = new Director("John Carpenter");
        DBHelper.saveOrUpdate(director1);
        Director director2 = new Director("Edmund Burke");
        DBHelper.saveOrUpdate(director2);

        Actor actor1 = new Actor("Nick Nicholson");
        DBHelper.saveOrUpdate(actor1);
        Actor actor2 = new Actor("Jarvis Arbuckle");
        DBHelper.saveOrUpdate(actor2);
        Actor actor3 = new Actor("Spingle Gambolls");
        DBHelper.saveOrUpdate(actor3);

        Set<Actor> actors1 = new HashSet<Actor>();
        actors1.add(actor1);
        actors1.add(actor2);

        Set<Actor> actors2 = new HashSet<Actor>();
        actors2.add(actor1);
        actors2.add(actor3);

        Film film1 = new Film("I Married My Gun", 2018, studio1, director1, actors1);
        DBHelper.saveOrUpdate(film1);

        Film film2 = new Film("Dancing with Databases", 1976, studio1, director2, actors2);
        DBHelper.saveOrUpdate(film2);

        Film foundFilm = DBHelper.find(Film.class, film1.getId());
        Actor foundActor = DBHelper.find(Actor.class, actor1.getId());
        Director foundDirector = DBHelper.find(Director.class, director1.getId());
        Studio foundStudio = DBHelper.find(Studio.class, studio1.getId());

        foundStudio.setName("AAAF inc");
        DBHelper.saveOrUpdate(foundStudio);

        List<Film> allFilms = DBHelper.getAll(Film.class);
        List<Actor> allActors = DBHelper.getAll(Actor.class);
        List<Director> allDirectors = DBHelper.getAll(Director.class);
        List<Studio> allStudios = DBHelper.getAll(Studio.class);

        List<Film> filmsByDirector1 = DBHelper.getFilmsByDirector(director1);

    }
}
