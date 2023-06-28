package klotski.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import klotski.model.Board;
import klotski.view.KlotskiApp;

public class TestSetConfigController {

    @Test
    public void testSetConfigController() {
        Board b = new Board();
        KlotskiApp app = new KlotskiApp(b);
        SetConfigController testCont = new SetConfigController(app, b);
        //test metodo setConfig
        int config = b.getConfig();
        assertFalse(config == 4);
        testCont.setConfig(4);
        assertTrue(config == 4);
    }
}
