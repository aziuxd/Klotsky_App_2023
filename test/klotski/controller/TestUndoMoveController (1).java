package klotski.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import klotski.model.Board;
import klotski.view.KlotskiApp;

public class TestUndoMoveController {

    @Test
    public void testUndoMoveController() {
        Board b = new Board();
        KlotskiApp app = new KlotskiApp(b);
        UndoMoveController testCont = new UndoMoveController(app, b);
        //test metodo undoMove()
        assertFalse(b.isOccupied(0, 4));
        b.selectPiece(1, 4);
        b.movePiece(3);
        testCont.undoMove();
        assertFalse(b.isOccupied(0, 4));
    }
}
