package NemoPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class NemoTest {
	
	@Test public void test00() {
		Nemo nemo = new Nemo();
		assertEquals(nemo.getPositionX(), 0);
		assertEquals(nemo.getPositionY(), 0);
		assertEquals(nemo.getDepth(), 0);
		assertEquals(nemo.getDirection(), "South");
	}
	@Test public void test01() {
		Nemo nemo = new Nemo();
		assertEquals( nemo.getPositionX(), nemo.moveX("") );
		assertEquals( nemo.getPositionY(), nemo.moveY("") ); //move me retorna la position
		//Si le paso un string vacío que no se mueva
	}
	@Test public void test02() {
		//le paso un char 'd'
		Nemo nemo = new Nemo();
		nemo.moveDepth('d');
		assertEquals(1, nemo.getDepth());
	}
	
	@Test public void test03() {
		//le paso un char 'u'
		Nemo nemo = new Nemo();
		nemo.moveDepth('u');
		assertEquals(0, nemo.getDepth());
	}
	
	@Test public void test04() {
		Nemo nemo = new Nemo();
		nemo.rotate('l');
		assertEquals(nemo.getDirection(), "East");
	}
}
