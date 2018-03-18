import db.DBHelper;
import models.Director;
import models.Film;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDirectorDB {

    private Studio studio;
    private Director director;
    private Film film;

    @Before
    public void setUp() throws Exception {
        studio = new Studio("Technicolour Travesties");
        director = new Director("Bong Joon-Ho");
        film = new Film("Cage Flipper", 1967, 400000, "Wildlife", studio, director);
    }

    @Test
    public void canIncreaseCash() {
        DBHelper.payEmployee(director, film, 200000);
        Director foundDirector = DBHelper.find(Director.class, director.getId());
        assertEquals(200000, foundDirector.getCash());
    }
}
