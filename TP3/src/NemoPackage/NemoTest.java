package NemoPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class NemoTest {
	
	@Test public void test00NemoIsCorrectlyInitialized() {
		Nemo nemo = new Nemo();
		assertEquals(nemo.getPositionX(), 0);
		assertEquals(nemo.getPositionY(), 0);
		assertEquals(nemo.getDepth(), 1);
		assertEquals(nemo.getDirection(), "South");
	}
	@Test public void test01NemoStaysInTheSamePositionWhenCommandIsEmpty() {
		Nemo nemo = new Nemo();
		assertEquals( nemo.getPositionX(), nemo.moveX("") );
		assertEquals( nemo.getPositionY(), nemo.moveY("") ); //move me retorna la position
		//Si le paso un string vacío que no se mueva
	}
	@Test public void test02CommandDNemoDescendsOneUnitInLevelOneOfImmersion() throws Exception {
		//le paso un char 'd'
		Nemo nemo = new Nemo();
		nemo.processCommand("d");
		assertEquals(2, nemo.getDepth());
	}
	
	@Test public void test03CommandUNemoAscendsOneUnit() throws Exception {
		//le paso un char 'u'
		Nemo nemo = new Nemo();
		nemo.processCommand("u");
		assertEquals(0, nemo.getDepth());
	}
	
	@Test public void test04CommandLNemoTurnsLeft() throws Exception {
		Nemo nemo = new Nemo();
		nemo.processCommand("l");
		assertEquals( "East", nemo.getDirection());
	}
	
	@Test public void test05CommandRNemoTurnsRight() throws Exception {
		Nemo nemo = new Nemo();
		nemo.processCommand("r");
		assertEquals( "West", nemo.getDirection());
	}
	@Test public void test06CommandFNemoMovesForwardOneUnit() throws Exception {
		Nemo nemo = new Nemo();
		nemo.processCommand("f");
		assertEquals(1, nemo.posicionX);
	}
	@Test public void test07CommandMNemoReleasesCapsule() throws Exception {
		Nemo nemo = new Nemo();
		nemo.processCommand("m");
		assertTrue(nemo.capsuleIsLiberated);
	}
	@Test public void test08DoesNotFailWhenGoingDownTooMuch() throws Exception {
		Nemo nemo = new Nemo();
		nemo.processCommand("d");
		nemo.processCommand("d");
		nemo.processCommand("d");
		nemo.processCommand("d");
		assertEquals(5, nemo.getDepth());
	}
	@Test public void test09DoesNotFailWhenGoingUpTooMuchAndStaysInSurface() throws Exception {
		Nemo nemo = new Nemo();
		nemo.processCommand("u");
		nemo.processCommand("u");
		nemo.processCommand("u");
		nemo.processCommand("u");
		assertEquals(0, nemo.getDepth());
	}
	
	@Test public void test10WhenNemoIsFacingNorthTurningLeftFacesWest() throws Exception {
		Nemo nemo = new Nemo();
		nemo.setDirection("North");
		nemo.processCommand("l");
		assertEquals("West", nemo.getDirection());
	}
	@Test public void test11WhenNemoIsFacingWestTurningLeftFacesSouth() throws Exception {
		Nemo nemo = new Nemo();
		nemo.setDirection("West");
		nemo.processCommand("l");
		assertEquals("South", nemo.getDirection());
	}
	@Test public void test12WhenNemoIsFacingEastTurningLeftFacesNorth() throws Exception {
		Nemo nemo = new Nemo();
		nemo.setDirection("East");
		nemo.processCommand("l");
		assertEquals("North", nemo.getDirection());
	}
	@Test public void test13WhenNemoIsFacingNorthTurningRightFacesEast() throws Exception {
		Nemo nemo = new Nemo();
		nemo.setDirection("North");
		nemo.processCommand("r");
		assertEquals("East", nemo.getDirection());
	}
	@Test public void test14WhenNemoIsFacingWestTurningRightFacesNorth() throws Exception {
		Nemo nemo = new Nemo();
		nemo.setDirection("West");
		nemo.processCommand("r");
		assertEquals("North", nemo.getDirection());
	}
	@Test public void test15WhenNemoIsFacingEastTurningRightFacesSouth() throws Exception {
		Nemo nemo = new Nemo();
		nemo.setDirection("East");
		nemo.processCommand("r");
		assertEquals("South", nemo.getDirection());
	}
	@Test public void test16RotatesLeftAsMuchAsAsked() throws Exception {
		Nemo nemo = new Nemo();
		nemo.processCommand("l");
		nemo.processCommand("l");
		nemo.processCommand("l");
		nemo.processCommand("l");
		assertEquals("South", nemo.getDirection());
	}
	@Test public void test17RotatesRightAsMuchAsAsked() throws Exception {
		Nemo nemo = new Nemo();
		nemo.processCommand("r");
		nemo.processCommand("r");
		nemo.processCommand("r");
		nemo.processCommand("r");
		assertEquals("South", nemo.getDirection());
	}
	@Test public void test18CannotReleaseCapsuleIfLevelDeeperThanOne() throws Exception {
		Nemo nemo = new Nemo();
		nemo.processCommand("d");
		assertEquals( Nemo.CannotReleaseCapsuleInDeeperLevels,
				  assertThrows( RuntimeException.class, () -> nemo.processCommand("m") ).getMessage() );
	}
	
	@Test public void test19CapsuleReleasesWhenNemoIsOnSurface() throws Exception {
		Nemo nemo = new Nemo();
		nemo.processCommand("m");
		assertTrue(nemo.capsuleIsLiberated);
	}

	/*que pasa si le insistis mucho con bajar
	que pasa si le insistis mucho con subir
	para donde se mueve si esta faceando para cada lado
	que rote tantasveces para la izq der como le pidas
	que puedas lanzar la capsula en el primer nivel o superficie y despues no
	combinaciones de a pares o triplets
	*/
}
