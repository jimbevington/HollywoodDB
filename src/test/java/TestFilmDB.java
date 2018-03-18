import db.DBHelper;
import models.Actor;
import models.Director;
import models.Film;
import models.Studio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFilmDB {

    private Actor actor;
    private Studio studio;
    private Director director;
    private Film film;

    @After
    public void tearDown() throws Exception {
        DBHelper.delete(film);
        DBHelper.delete(director);
        DBHelper.delete(actor);
        DBHelper.delete(studio);
    }

    @Before
    public void setUp() throws Exception {
        actor = new Actor("Peter Sellers");
        DBHelper.saveOrUpdate(actor);
        studio = new Studio("MGM");
        DBHelper.saveOrUpdate(studio);
        director = new Director("Blake Edwards");
        DBHelper.saveOrUpdate(director);
        film = new Film("A Shot In The Dark", 1964, 1000000, studio, director);
        DBHelper.saveOrUpdate(film);
    }

    @Test
    public void canAddActorToFilm() {
        DBHelper.addActorToFilm(actor, film);
        Film foundFilm = DBHelper.find(Film.class, film.getId());
        Actor foundActor = DBHelper.find(Actor.class, actor.getId());
        assertEquals(1, foundFilm.getActors().size());
        assertEquals(1, foundActor.getFilms().size());
    }

    @Test
    public void canReduceBudget() {
        DBHelper.payActor(actor, film, 10000);
        Film foundFilm = DBHelper.find(Film.class, film.getId());
        assertEquals(990000, foundFilm.getBudget());
    }
}
