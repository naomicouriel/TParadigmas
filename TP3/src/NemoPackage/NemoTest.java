package NemoPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class NemoTest {
	
	@Test public void test00NemoIsCorrectlyInitialized() {
		assertEquals(newNemoAtOriginFacingSouth().getPositionX(), 0);
		assertEquals(newNemoAtOriginFacingSouth().getPositionY(), 0);
		assertEquals(newNemoAtOriginFacingSouth().getDepth(), 0);
		assertEquals(newNemoAtOriginFacingSouth().getDirection(), "South");
	}
	
	@Test public void test01NemoStaysInTheSamePositionWhenCommandIsEmpty() {
		newNemoAtOriginFacingSouth().move("");
		
		assertEquals( newNemoAtOriginFacingSouth().getPositionX(), 0 );
		assertEquals( newNemoAtOriginFacingSouth().getPositionY(), 0 );
	}
	
	@Test public void test02CommandDNemoDescendsOneUnitInLevelOneOfImmersion() {
		Nemo nemo = newNemoAtOriginFacingSouth();
		
		nemo.move("d");
		assertEquals(1, nemo.getDepth());
	}
	
	@Test public void test03CommandUNemoAscendsOneUnit(){
		Nemo nemo = newNemoAtOriginFacingSouth();
		
		nemo.move("u");
		assertEquals(0, nemo.getDepth());
	}
	
	@Test public void test04CommandLNemoTurnsLeft() {
		Nemo nemo = newNemoAtOriginFacingSouth();
		
		nemo.move("l");
		assertEquals( "East", nemo.getDirection());
	}
	
	@Test public void test05CommandRNemoTurnsRight() {
		Nemo nemo = newNemoAtOriginFacingSouth();
		
		nemo.move("r");
		assertEquals( "West", nemo.getDirection());
	}
	
	@Test public void test06CommandFNemoMovesForwardOneUnit() {
		Nemo nemo = newNemoAtOriginFacingSouth();
		
		nemo.move("f");
		assertEquals(1, nemo.getPositionX());
	}
	
	@Test public void test07CommandMNemoReleasesCapsule() {
		Nemo nemo = newNemoAtOriginFacingSouth();
		
		nemo.move("m");
		assertTrue(Nemo.capsuleIsLiberated);
	}
	
	@Test public void test08DoesNotFailWhenGoingDownTooMuch() {
		Nemo nemo = newNemoAtOriginFacingSouth();
		
		nemo.move("ddddd");
		assertEquals(5, nemo.getDepth());
	}
	
	@Test public void test09DoesNotFailWhenGoingUpTooMuchAndStaysInSurface() {
		newNemoAtOriginFacingSouth().move("uuuuu");
		assertEquals(0, newNemoAtOriginFacingSouth().getDepth());
	}
	
	@Test public void test10WhenNemoIsFacingNorthTurningLeftFacesWest() {
		Posicion posicion = new Posicion(0, 0);
		Direccion direccion = new North();
		
		Nemo nemo = new Nemo(posicion, direccion);
		
		nemo.move("l");
		assertEquals("West", nemo.getDirection());
	}
	
	@Test public void test11WhenNemoIsFacingWestTurningLeftFacesSouth() {
		Posicion posicion = new Posicion(0, 0);
		Direccion direccion = new West();
		
		Nemo nemo = new Nemo(posicion, direccion);
		
		nemo.move("l");
		assertEquals("South", nemo.getDirection());
	}
	
	@Test public void test12WhenNemoIsFacingEastTurningLeftFacesNorth()  {
		Posicion posicion = new Posicion(0, 0);
		Direccion direccion = new East();
		
		Nemo nemo = new Nemo(posicion, direccion);
		
		nemo.move("l");
		assertEquals("North", nemo.getDirection());
	}
	
	@Test public void test13WhenNemoIsFacingNorthTurningRightFacesEast() {
		Posicion posicion = new Posicion(0, 0);
		Direccion direccion = new North();
		
		Nemo nemo = new Nemo(posicion, direccion);
		
		nemo.move("r");
		assertEquals("East", nemo.getDirection());
	}
	
	@Test public void test14WhenNemoIsFacingWestTurningRightFacesNorth() {
		Posicion posicion = new Posicion(0, 0);
		Direccion direccion = new West();
		
		Nemo nemo = new Nemo(posicion, direccion);
		
		nemo.move("r");
		assertEquals("North", nemo.getDirection());
	}
	
	@Test public void test15WhenNemoIsFacingEastTurningRightFacesSouth() {
		Posicion posicion = new Posicion(0, 0);
		Direccion direccion = new East();
		
		Nemo nemo = new Nemo(posicion, direccion);
		
		nemo.move("r");
		assertEquals("South", nemo.getDirection());
	}
	
	
	@Test public void test16RotatesLeftAsMuchAsAsked(){
		Nemo nemo = newNemoAtOriginFacingSouth();
		
		nemo.move("llll");
		assertEquals("South", nemo.getDirection());
	}
	
	@Test public void test17RotatesRightAsMuchAsAsked() {
		Nemo nemo = newNemoAtOriginFacingSouth();
		
		nemo.move("rrrr");
		assertEquals("South", nemo.getDirection());
	}
	
	@Test public void test18CannotReleaseCapsuleIfLevelDeeperThanOne() {
		Nemo nemo = newNemoAtOriginFacingSouth();
		
		nemo.move("dd");
		assertEquals( Nemo.CannotReleaseCapsuleInDeeperLevels,
				  assertThrows( RuntimeException.class, () -> nemo.move("m") ).getMessage() );
		
		assertFalse(Nemo.capsuleIsLiberated);
	}
	
	@Test public void test19CapsuleReleasesWhenNemoIsOnSurface() {
		Nemo nemo = newNemoAtOriginFacingSouth();
		nemo.move("m");
		
		assertTrue(Nemo.capsuleIsLiberated);
	}
	
	@Test public void test20CapsuleReleasesWhenNemoIsOnLevelOne() {
		Nemo nemo = newNemoAtOriginFacingSouth();
		nemo.move("dm");
		
		assertTrue(Nemo.capsuleIsLiberated);
	}
	
	@Test public void test21NemoRotatesLeftAndGoesForward() {
		Nemo nemo = newNemoAtOriginFacingSouth();
		nemo.move("lf");
		assertEquals( "East", nemo.getDirection());
		assertEquals(1, nemo.getPositionY());
	}
	
	@Test public void test22NemoGoesUpAndDownManyTimes() {
		Nemo nemo = newNemoAtOriginFacingSouth();
		nemo.move("dduddu");
		assertEquals(2, nemo.getDepth());
	}
	
	@Test public void test23NemoRotatesAndReleasesCapsule() {
		Posicion posicion = new Posicion(0, 0);
		Direccion direccion = new West();
		
		Nemo nemo = new Nemo(posicion, direccion);
		nemo.move("rm");
		assertEquals( "North", nemo.getDirection());
		assertTrue(Nemo.capsuleIsLiberated);
	}
	
	@Test public void test24CapsuleCanBeReleasedMultipleTimes() {
		Posicion posicion = new Posicion(0, 0);
		Direccion direccion = new West();
		
		Nemo nemo = new Nemo(posicion, direccion);

		nemo.move("mmmm");
		assertTrue(Nemo.capsuleIsLiberated);
	}
	
	@Test public void test25NemoCanBeInitializedInAPositionDifferentThanTheOrigin() {
		Posicion posicion = new Posicion(8, 4);
		Direccion direccion = new East();
		
		Nemo nemo = new Nemo(posicion, direccion);
		assertEquals(8, nemo.getPositionX());
		assertEquals(4, nemo.getPositionY());
	}
	
	@Test public void test26NemoDescendsGoesForwardRotatesRightAndReleasesCapsule() {
		Posicion posicion = new Posicion(5, 8);
		Direccion direccion = new East();
		
		Nemo nemo = new Nemo(posicion, direccion);
		nemo.move("dfrm");
		
		assertEquals(1, nemo.getDepth());
		assertEquals(9, nemo.getPositionY());
		assertEquals("South", nemo.getDirection());
		assertTrue(Nemo.capsuleIsLiberated);
	}
	
	private Nemo newNemoAtOriginFacingSouth() {
		Posicion posicion = new Posicion(0, 0);
		Direccion direccion = new South();
		
		Nemo nemo = new Nemo(posicion, direccion);
		return nemo;
	}

}
