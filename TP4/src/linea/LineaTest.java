package linea;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

public class LineaTest {

    @Test
    public void testInicializacion() {
        assertEquals('A', newLinea4x4WithStrategyA().getEstrategia());
    }
    
    @Test
    public void testInicializacionEstrategiaB() {
        assertEquals('B', new Linea(4, 4, 'B').getEstrategia());
    }
    
    @Test
    public void testInicializacionEstrategiaC() {
        assertEquals('C', new Linea(4, 4, 'C').getEstrategia());
    }
    
    @Test
    public void testEstrategiaIncorrecta() {
		assertThrowsLike(() -> new Linea(3, 3, 'a'), "No value present");
    }

    @Test
    public void testJuegadaRojo() {
        Linea linea = newLinea4x4WithStrategyA();
        linea.playRedAt(1);
        assertEquals("- - - - \n- - - - \n- - - - \nX - - - \n", linea.show());
    }
    
    @Test
    public void testJuegaRojoDosVecesSeguidas() {
        Linea linea = newLinea4x4WithStrategyA();
        linea.playRedAt(1);
		assertThrowsLike(() -> linea.playRedAt(1), Linea.ItIsNotYourTurn);
    }
    
    @Test
    public void testJuegaAzulDosVecesSeguidas() {
        Linea linea = newLinea4x4WithStrategyA();
        linea.playRedAt(1);
        linea.playBlueAt(1);
		assertThrowsLike(() -> linea.playBlueAt(1), Linea.ItIsNotYourTurn);
    }
    
    @Test
    public void juegaRojoYAzul() {
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
    public void testRedWinsInStrategyA() {
        Linea linea = newLinea4x4WithStrategyA();
        redWins(linea);
        assertEquals(linea.whoWon(), "Ganador: Rojo");
        assertTrue(linea.finished());
    }
    
    @Test
    public void testBlueWinsInStrategyB() {
        Linea linea = new Linea(4, 4, 'B');
        blueWins(linea);
        assertEquals(linea.whoWon(), "Ganador: Azul");
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
    public void canNotPlayAfterGameIsFinishedAndPlayerWon() {
        Linea linea = newLinea4x4WithStrategyA();
        redWins(linea);
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

	private void redWins(Linea linea) {
		linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
        linea.playBlueAt(2);
        linea.playRedAt(1);
	}
	
	private void blueWins(Linea linea) {
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
    
  private void assertThrowsLike(Executable executable, String message) {
	assertEquals(message, assertThrows(Exception.class, executable).getMessage());
  }

   
}
