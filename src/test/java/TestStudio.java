import db.DBHelper;
import models.Film;
import models.Studio;
import org.hibernate.dialect.DB2Dialect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestStudio {

    private Studio studio;

    @After
    public void tearDown() throws Exception {
        DBHelper.delete(studio);
    }

    @Before
    public void setUp() throws Exception {
        studio = new Studio("Wowsers Pictures");
        DBHelper.saveOrUpdate(studio);
    }

    @Test
    public void canSave() {
        Studio found = DBHelper.find(Studio.class, studio.getId());
        assertEquals("Wowsers Pictures", found.getName());
    }

//    can update

    @Test
    public void canUpdate() {
        Studio found = DBHelper.find(Studio.class, studio.getId());
        found.setName("Times Up presents ...");
        DBHelper.saveOrUpdate(found);
        found = DBHelper.find(Studio.class, studio.getId());
        assertEquals("Times Up presents ...", found.getName());
        List<Studio> foundFilms = DBHelper.getAll(Film.class);
        assertEquals(1, foundFilms.size());
    }


//    can delete

//    can get all
}
