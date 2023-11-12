package linea;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

public class LineaTest {

    @Test
    public void testInitialization() {
        assertEquals('A', newLinea4x4WithStrategyA().getEstrategia());
    }
    
    @Test
    public void testInitializationStrategyB() {
        assertEquals('B', new Linea(4, 4, 'B').getEstrategia());
    }
    
    @Test
    public void testInitializationStrategyC() {
        assertEquals('C', new Linea(4, 4, 'C').getEstrategia());
    }
    
    @Test
    public void testWrongStrategy() {
		assertThrowsLike(() -> new Linea(3, 3, 'a'), "No value present");
    }

    @Test
    public void RedPlays() {
        Linea linea = newLinea4x4WithStrategyA();
        linea.playRedAt(1);
        assertEquals("- - - - \n- - - - \n- - - - \nX - - - \n", linea.show());
    }
    
    @Test
    public void RedPlaysTwiceInARow() {
        Linea linea = newLinea4x4WithStrategyA();
        linea.playRedAt(1);
		assertThrowsLike(() -> linea.playRedAt(1), Linea.ItIsNotYourTurn);
    }
    
    @Test
    public void BluePlaysTwiceInARow() {
        Linea linea = newLinea4x4WithStrategyA();
        linea.playRedAt(1);
        linea.playBlueAt(1);
		assertThrowsLike(() -> linea.playBlueAt(1), Linea.ItIsNotYourTurn);
    }
    
    @Test
    public void testShowWhenRedAndBluePlay() {
        Linea linea = newLinea4x4WithStrategyA();
        linea.playRedAt(1);
        linea.playBlueAt(1);
        assertEquals("- - - - \n- - - - \n0 - - - \nX - - - \n", linea.show());
    }
    
    @Test
    public void testDimentionsOutOfBounds() {
        Linea linea = newLinea4x4WithStrategyA();
		assertThrowsLike(() -> linea.playRedAt(5), Linea.CannotPlayAtThisPosition);
    }
    
    @Test
    public void testBigDimentionsWork() {
        Linea linea = new Linea(10, 10, 'A');
        assertEquals("- - - - - - - - - - \n"
        		+ "- - - - - - - - - - \n"
        		+ "- - - - - - - - - - \n"
        		+ "- - - - - - - - - - \n"
        		+ "- - - - - - - - - - \n"
        		+ "- - - - - - - - - - \n"
        		+ "- - - - - - - - - - \n"
        		+ "- - - - - - - - - - \n"
        		+ "- - - - - - - - - - \n"
        		+ "- - - - - - - - - - \n", linea.show());
    }
    
    @Test
    public void testRedWinsVerticalInStrategyA() {
        Linea linea = newLinea4x4WithStrategyA();
        redWinsVertical(linea);
        assertEquals(linea.whoWon(), "Ganador: Rojo");
        assertTrue(linea.finished());
    }
    
    @Test
    public void testBlueWinsHorizontalInStrategyA() {
        Linea linea = newLinea4x4WithStrategyA();
        blueWinsHorizontal(linea);
        assertEquals(linea.whoWon(), "Ganador: Azul");
        assertTrue(linea.finished());
    }
    
    @Test
    public void testBlueWinsLeftDiagonalInStrategyB() {
        Linea linea = new Linea(4, 4, 'B');
        blueWinsLeftDiagonal(linea);
        assertEquals(linea.whoWon(), "Ganador: Azul");
        assertTrue(linea.finished());
    }
    
    @Test
    public void testRedWinsRightDiagonalInStrategyB() {
        Linea linea = new Linea(4, 4, 'B');
        redWinsRightDiagonal(linea);
        assertEquals(linea.whoWon(), "Ganador: Rojo");
        assertTrue(linea.finished());
    }
    
    @Test
    public void testDrawInStrategyC() {
        Linea linea = new Linea(4, 4, 'C');
        testDraw(linea);
        assertTrue(linea.empate());
        assertTrue(linea.finished());
    }
    
    @Test
    public void testDiagonalWinInStrategyC() {
        Linea linea = new Linea(4, 4, 'C');
        redWinsRightDiagonal(linea);
        assertEquals(linea.whoWon(), "Ganador: Rojo");
        assertTrue(linea.finished());
    }
    
    @Test
    public void testVerticalWinInStrategyC() {
        Linea linea = new Linea(4, 4, 'C');
        redWinsVertical(linea);
        assertEquals(linea.whoWon(), "Ganador: Rojo");
        assertTrue(linea.finished());
    }
    
    @Test
    public void testHorizontalWinInStrategyC() {
        Linea linea = new Linea(4, 4, 'C');
        blueWinsHorizontal(linea);
        assertEquals(linea.whoWon(), "Ganador: Azul");
        assertTrue(linea.finished());
    }
    
    @Test
    public void canNotPlayAfterGameIsFinishedAndPlayerWon() {
        Linea linea = newLinea4x4WithStrategyA();
        redWinsVertical(linea);
        assertTrue(linea.finished());
		assertThrowsLike(() -> linea.playBlueAt(1), Linea.GameIsOver);
    }
    
   @Test  
   public void canNotPlayAfterGameIsFinishedAndNoOneWon() {
      Linea linea = newLinea4x4WithStrategyA();
      testDraw(linea);
      assertTrue(linea.empate());
	  assertThrowsLike(() -> linea.playBlueAt(1), Linea.GameIsOver);
   }
   
   @Test
   public void diagonalDoesNotWinInStrategyA() {
	   Linea linea = newLinea4x4WithStrategyA();
	   redWinsRightDiagonal(linea);
	   assertFalse(linea.finished());
   }
   
   @Test
   public void verticalDoesNotWinInStrategyB() {
       Linea linea = new Linea(4, 4, 'B');
       redWinsVertical(linea);
	   assertFalse(linea.finished());
   }
   
   @Test
   public void HorizontalDoesNotWinInStrategyB() {
       Linea linea = new Linea(4, 4, 'B');
       blueWinsHorizontal(linea);
	   assertFalse(linea.finished());
   }
   
   @Test
   public void gameNotFinished() {
       Linea linea = new Linea(4, 4, 'A');
       linea.playRedAt(1);
       linea.playBlueAt(1);
	   assertFalse(linea.finished());
   }
   
  private Linea newLinea4x4WithStrategyA() {
	Linea linea = new Linea(4, 4, 'A');
	return linea;
  }
  
	private void testDraw(Linea linea) {
		linea.playRedAt(1);
	    linea.playBlueAt(2);
	    linea.playRedAt(3);
	    linea.playBlueAt(4);
	    linea.playRedAt(2);
	    linea.playBlueAt(1);
	    linea.playRedAt(4);
	    linea.playBlueAt(3);
	    linea.playRedAt(2);
	    linea.playBlueAt(1);
	    linea.playRedAt(4);
	    linea.playBlueAt(3);
	    linea.playRedAt(1);
	    linea.playBlueAt(2);
	    linea.playRedAt(3);
	    linea.playBlueAt(4);
	}

	private void redWinsVertical(Linea linea) {
		linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
	}
	
	private void redWinsRightDiagonal(Linea linea) {
		linea.playRedAt(4);
        linea.playBlueAt(3);
        linea.playRedAt(3);
        linea.playBlueAt(2);
        linea.playRedAt(4);
        linea.playBlueAt(2);
        linea.playRedAt(2);
        linea.playBlueAt(1);
        linea.playRedAt(1);
        linea.playBlueAt(1);
        linea.playRedAt(1);
	}
	
	private void blueWinsLeftDiagonal(Linea linea) {
		linea.playRedAt(2);
        linea.playBlueAt(1);
        linea.playRedAt(3);
        linea.playBlueAt(2);
        linea.playRedAt(3);
        linea.playBlueAt(3);
        linea.playRedAt(4);
        linea.playBlueAt(4);
        linea.playRedAt(4);
        linea.playBlueAt(4);
	}
	
    private void blueWinsHorizontal(Linea linea) {
		linea.playRedAt(1);
		linea.playBlueAt(1);
		linea.playRedAt(2);
		linea.playBlueAt(2);
		linea.playRedAt(3);
		linea.playBlueAt(3);
		linea.playRedAt(1);
		linea.playBlueAt(4);
		linea.playRedAt(1);
		linea.playBlueAt(4);	
    }
  private void assertThrowsLike(Executable executable, String message) {
	assertEquals(message, assertThrows(Exception.class, executable).getMessage());
  }

   
}
