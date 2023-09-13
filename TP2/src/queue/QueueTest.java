package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class QueueTest {

private static String element = "Something";
private static String secondElement = "Second";
private static String firstElement = "First";

@Test public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue( new Queue().isEmpty() );
  }

  @Test public void test02AddElementsToTheQueue() {
    assertFalse( addSomethingToNewQueue(element).isEmpty() );
  }

  @Test public void test03AddedElementsIsAtHead() {
    assertEquals( element, addSomethingToNewQueue(element).head() );
  }

  @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = addSomethingToNewQueue(element);
    queue.take();
    
    assertTrue( queue.isEmpty() );
  }

  @Test public void test05TakeReturnsLastAddedObject() {
    Queue queue = addSomethingToNewQueue(element);
    assertEquals( element, queue.take() );
  }

  @Test public void test06QueueBehavesFIFO() {
    Queue queue = addSomethingToNewQueue(firstElement).add(secondElement);

    assertEquals( queue.take(), firstElement );
    assertEquals( queue.take(), secondElement );
    assertTrue( queue.isEmpty() );
  }

  @Test public void test07HeadReturnsFirstAddedObject() {
    addSomethingToNewQueue(firstElement).add( secondElement );

    assertEquals( addSomethingToNewQueue(firstElement).head(), firstElement );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
	assertEquals( 1, addSomethingToNewQueue(element).size() );
    addSomethingToNewQueue(element).head();
    assertEquals( 1, addSomethingToNewQueue(element).size() );
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals( 2, addSomethingToNewQueue(firstElement).add( secondElement ).size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    assertThrowsLike(() -> new Queue().take(), QueueEmpty.queueIsEmpty);
  }

  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = addSomethingToNewQueue(element);
    queue.take();
    
    assertThrowsLike(() -> queue.take(), QueueEmpty.queueIsEmpty);

  }

  @Test public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() { 
    assertThrowsLike(() -> new Queue().head(), QueueEmpty.queueIsEmpty);
  }
  
  private Queue addSomethingToNewQueue(Object objectToAdd) {
		Queue queue = new Queue().add( objectToAdd );
		return queue;
	}
  
  private void assertThrowsLike( Executable executable, String message ) {
	    assertEquals( message, 
	                  assertThrows( Error.class, executable ).getMessage() );

  }

  @Test public void test11QueueBehavesFIFO() {
	    Queue queue = new Queue();
	    String firstAddedObject = firstElement;
	    String secondAddedObject = secondElement;
	    String thirdAddedObject = "Third element";

	    queue.add( firstAddedObject );
	    queue.add( secondAddedObject );
	    queue.add( thirdAddedObject );


	    assertEquals( queue.take(), firstAddedObject );
	    assertEquals( queue.take(), secondAddedObject );
	    //assertEquals( queue.take(), thirdAddedObject );

	    assertFalse( queue.isEmpty() );
	  }

}