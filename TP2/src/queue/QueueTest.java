package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class QueueTest {

private static String ExpectedErrorNotThrown = "Expected Error was not thrown.";
private static String queueIsEmpty = "Queue is empty";
private static String element = "Something";
private static String secondElement = "Second";
private static String FirstElement = "First";

@Test public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue( new Queue().isEmpty() );
  }

  @Test public void test02AddElementsToTheQueue() {
    assertFalse( addSomethingToNewQueue().isEmpty() );
  }

  @Test public void test03AddedElementsIsAtHead() {
    assertEquals( element, addSomethingToNewQueue().head() );
  }

  @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = addSomethingToNewQueue();
    queue.take();
    
    assertTrue( queue.isEmpty() );
  }

  @Test public void test05TakeReturnsLastAddedObject() {
    Queue queue = new Queue();
    String addedObject = element;
    queue.add( addedObject );
    
    assertEquals( addedObject, queue.take() );
  }

  @Test public void test06QueueBehavesFIFO() {
    Queue queue = new Queue();
    String firstAddedObject = FirstElement;
    String secondAddedObject = secondElement;

    queue.add( firstAddedObject );
    queue.add( secondAddedObject );

    assertEquals( queue.take(), firstAddedObject );
    assertEquals( queue.take(), secondAddedObject );
    assertTrue( queue.isEmpty() );
  }

  @Test public void test07HeadReturnsFirstAddedObject() {
    Queue queue = new Queue();
    String firstAddedObject = FirstElement;

    queue.add( firstAddedObject );
    queue.add( secondElement );

    assertEquals( queue.head(), firstAddedObject );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
	Queue queue = addSomethingToNewQueue();
    assertEquals( 1, addSomethingToNewQueue().size() );
    queue.head();
    assertEquals( 1, addSomethingToNewQueue().size() );
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals( 2, new Queue().add( FirstElement ).add( secondElement ).size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    assertThrowsLike(() -> new Queue().take(), queueIsEmpty);
  }

  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = addSomethingToNewQueue();
    queue.take();
    
    assertThrowsLike(() -> queue.take(), queueIsEmpty);

  }

  @Test public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
    
    //assertEquals( queueIsEmpty, assertThrows(Error.class, () -> new Queue().head()).getMessage());
 
    assertThrowsLike(() -> new Queue().head(), queueIsEmpty);
  }
  
  private Queue addSomethingToNewQueue() {
		Queue queue = new Queue().add( element );
		return queue;
	}
  
  private void assertThrowsLike( Executable executable, String message ) {
	    assertEquals( message, 
	                  assertThrows( Error.class, executable ).getMessage() );
	  }

}