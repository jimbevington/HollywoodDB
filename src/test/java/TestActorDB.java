import db.DBHelper;
import models.Actor;
import models.Director;
import models.Film;
import models.Studio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestActorDB {

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
        Actor foundActor = DBHelper.find(Actor.class, actor.getId());
        assertEquals(1, foundActor.getFilms().size());
    }

    @Test
    public void canIncreaseCash() {
        DBHelper.payEmployee(actor, film, 10000);
        Actor foundActor = DBHelper.find(Actor.class, actor.getId());
        assertEquals(10000, foundActor.getCash());
    }
}
