import models.Actor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestActor {

    private Actor actor;

    @Before
    public void setUp() throws Exception {
        actor = new Actor("Peter Sellers");
    }

    @Test
    public void canAddCash() {
        actor.increaseCash(50);
        assertEquals(50, actor.getCash());
    }
}
