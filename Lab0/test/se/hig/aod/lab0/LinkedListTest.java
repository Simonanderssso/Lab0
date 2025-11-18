package se.hig.aod.lab0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class LinkedListTest {

	private LinkedList<Integer> listUnderTest;
	private final int[] fixture = {1, 2, 3, 4, 5};

	/**
	 * Resets list to a new empty LinkedList-instance
	 * before each test method is executed.
	 *
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		listUnderTest = new LinkedList<Integer>();
	}

	/**
	 * Sets list to null after each test method is executed.
	 *
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		listUnderTest = null;
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#isEmpty()}.
	 */
	@Test
	public void testEmptyListIsEmpty() {
		assertTrue(listUnderTest.isEmpty(), "An empty list instance should not contain any item");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#isEmpty()}.
	 */
	@Test
	public void testInitializedListIsNotEmpty() {
		initializeList();
		assertFalse(listUnderTest.isEmpty(), "A list instance containing elements should not be empty");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#clear()}.
	 */
	@Test
	public void testClearOnEmptyList() {
		listUnderTest.clear();
		assertTrue(listUnderTest.isEmpty(), "An empty list instance that is cleared should not contain any item");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#clear()}.
	 */
	@Test
	public void testClearOnInitializedList() {
		listUnderTest.insertLast(1);
		listUnderTest.insertLast(2);
		listUnderTest.insertLast(3);

		listUnderTest.clear();

		assertTrue(listUnderTest.isEmpty(), "List should be empty after clear");
		assertEquals(0, listUnderTest.numberOfElements(), "List should contain zero elements after clear");
		assertThrows(ListEmptyException.class, () -> listUnderTest.getFirst(), "After clear(), getFirst should throw ListEmptyException");
	}


	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#getFirst()}.
	 */
	@Test
	public void testGetFirstOnEmptyList() {
		assertThrows(ListEmptyException.class, () -> listUnderTest.getFirst(), "GetFirst() on empty list should throw ListEmptyException");
	}

	/**
	 * Test method for {@link LinkedList#numberOfElements()}.
	 */
	@Test
	public void testNumberOfElementsOnEmptyList() {
		assertEquals(0, listUnderTest.numberOfElements(), "Empty list sould have zero elements");
	}


	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#getFirst()}.
	 */
	@Test
	public void testGetFirstOnInitializedList() {
		initializeList();
		assertEquals(1, listUnderTest.getFirst(), "GetFirst() should return first element in list");
	}

	/**
	 * Test method for {@link LinkedList#numberOfElements()}.
	 */
	@Test
	public void testNumberOfElementsAfterInsert() {
		listUnderTest.insertFirst(10);

		assertEquals(1, listUnderTest.numberOfElements(), "List should contain one element after insert");
	}

	/**
	 * Test method for {@link LinkedList#numberOfElements()}.
	 */
	@Test
	public void testNumberOfElementsAfterMultipleInserts() {
		listUnderTest.insertLast(1);
		listUnderTest.insertLast(2);
		listUnderTest.insertLast(3);

		assertEquals(3, listUnderTest.numberOfElements(), "List should contain 3 elements after 3 inserts");
	}

	/**
	 * Test method for {@link LinkedList#insertFirst(Object)}.
	 */
	@Test
	public void testInsertFirstOnEmptyList() {
		listUnderTest.insertFirst(10);

		assertEquals(10, listUnderTest.getFirst(), "First element should be the one inserted");
		assertFalse(listUnderTest.isEmpty(), "List should not be empty after insertFirst");
		assertEquals(1, listUnderTest.numberOfElements(), "List should have 1 element after one insertFirst");
	}

	/**
	 * Test method for {@link LinkedList#insertFirst(Object)}.
	 */
	@Test
	public void testInsertFirstOnInitializedList() {
		initializeList();

		listUnderTest.insertFirst(99);

		assertEquals(99, listUnderTest.getFirst(), "insertFirst should place new element first");
		assertEquals(6, listUnderTest.numberOfElements(), "List should grow by 1 after insertFirst");
	}

	/**
	 * Test method for {@link LinkedList#insertLast(Object)}.
	 */
	@Test
	public void testInsertLastOnEmptyList() {
		listUnderTest.insertLast(10);

		assertEquals(10, listUnderTest.getFirst(), "insertLast on empty list should place the element first");
		assertFalse(listUnderTest.isEmpty(), "List should not be empty after insertLast");
		assertEquals(1, listUnderTest.numberOfElements(), "List should have 1 element after insertLast on empty list");
	}

	/**
	 * Test method for {@link LinkedList#insertLast(Object)}.
	 */
	@Test
	public void testInsertLastOnInitializedList() {
		initializeList();

		listUnderTest.insertLast(99);

		assertEquals(99, listUnderTest.getLast(), "insertLast should place new element last in the list");
		assertEquals(6, listUnderTest.numberOfElements(), "List should grow by 1 after insertLast");
	}

	/**
	 * Test method for {@link LinkedList#removeFirst()}.
	 */
	@Test
	public void testRemoveFirstOnEmptyList() {
		assertThrows(ListEmptyException.class, () -> listUnderTest.removeFirst(), "removeFirst on empty list should throw ListEmptyException");
	}

	/**
	 * Test method for {@link LinkedList#removeFirst()}.
	 */
	@Test
	public void testRemoveFirstOnInitializedList() {
		initializeList(); // {1,2,3,4,5}

		int removed = listUnderTest.removeFirst();

		assertEquals(1, removed, "removeFirst should return the first element");
		assertEquals(2, listUnderTest.getFirst(), "After removing first, new first should be the previous second element");
		assertEquals(4, listUnderTest.numberOfElements(), "List size should decrease by 1 after removeFirst");
	}

	/**
	 * Test method for {@link LinkedList#removeLast()}.
	 */
	@Test
	public void testRemoveLastOnEmptyList() {
		assertThrows(ListEmptyException.class,
				() -> listUnderTest.removeLast(),
				"removeLast on empty list should throw ListEmptyException");
	}

	/**
	 * Test method for {@link LinkedList#removeLast()}.
	 */
	@Test
	public void testRemoveLastOnInitializedList() {
		initializeList(); // {1,2,3,4,5}

		int removed = listUnderTest.removeLast();

		assertEquals(5, removed, "removeLast should return the last element");
		assertEquals(4, listUnderTest.getLast(), "After removing last, new last should be the previous second last element");
		assertEquals(4, listUnderTest.numberOfElements(), "List size should decrease by 1 after removeLast");
	}

	private void initializeList() {
		for (int i = 0; i < fixture.length; i++) {
			listUnderTest.insertLast(fixture[i]);
		}
	}

}
