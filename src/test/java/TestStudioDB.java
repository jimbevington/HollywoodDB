import db.DBHelper;
import models.Film;
import models.Studio;
import org.hibernate.dialect.DB2Dialect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestStudioDB {

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


    @Test
    public void canUpdate() {
        Studio found = DBHelper.find(Studio.class, studio.getId());
        found.setName("Times Up presents ...");
        DBHelper.saveOrUpdate(found);
//        get Film back and check name has been updated
        found = DBHelper.find(Studio.class, studio.getId());
        assertEquals("Times Up presents ...", found.getName());
//        get All Films and check there's still only 1
        List<Studio> foundStudios = DBHelper.getAll(Studio.class);
        assertEquals(1, foundStudios.size());
    }

    @Test
    public void canDelete() {
        Studio studio2 = new Studio("Bad Films");
        DBHelper.saveOrUpdate(studio2);
        DBHelper.delete(studio2);
//        get all Studios back and test only 1 after deletion
        List<Studio> studios = DBHelper.getAll(Studio.class);
        assertEquals(1, studios.size());
//        get Studio out of list and test its not the deleted one
        Studio foundStudio = studios.get(0);
        assertEquals(studio.getId(), foundStudio.getId());
    }
}
