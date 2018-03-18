import db.DBHelper;
import models.Actor;
import models.Director;
import models.Film;
import models.Studio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFilm {

    private Studio studio;
    private Director director;
    private Film film;

    @Before
    public void setUp() throws Exception {
        film = new Film("A Shot In The Dark", 1964, 1000000, studio, director);
    }

    @Test
    public void canReduceBudget() {
        film.decreaseBudget(500000);
        assertEquals(500000, film.getBudget());
    }


}
