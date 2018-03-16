import db.DBHelper;
import models.Actor;
import models.Director;
import models.Film;
import models.Studio;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Studio studio1 = new Studio("All American Action Films Inc");
        DBHelper.saveOrUpdate(studio1);

        Director director1 = new Director("John Carpenter");
        DBHelper.saveOrUpdate(director1);

        Actor actor1 = new Actor("Nick Nicholson");
        DBHelper.saveOrUpdate(actor1);

        Film film1 = new Film("I Married My Gun", 2018, studio1, director1);
        DBHelper.saveOrUpdate(film1);

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

    }
}
