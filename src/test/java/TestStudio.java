import models.Studio;
import org.hibernate.dialect.DB2Dialect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStudio {

    private Studio studio;

    @After
    public void tearDown() throws Exception {
        DBHelper.delete(studio);
    }

    @Before
    public void setUp() throws Exception {
        studio = new Studio("Wowsers Pictures");
    }

    @Test
    public void canSave() {
        Studio found = DBHelper.find(studio);
        assertEquals("Wowsers Pictures", found.getName());
    }

//    can update

//    can delete

//    can get all
}