package com.coderscampus.arraylist;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {

	//--> ADD
	// should successfully add items
	//--> REMOVE
	// should successfully remove item
	// should throw index out of bounds when index doesnt exist when tryig to remove an item
	// --> ADD AT INDEX
	// should successfully add item at index
	// should throw index out of bounds when index doesnt exist when trying to add an item at a speciic index
	// --> GET
	// should successfully get item
	// should throw index out of bounds error when trying to get an index that doesnt exist
	
	@Test
	void should_add_100_items() {
		CustomList<Integer> sut = new CustomArrayList<>();
		
		for (int i = 1; i <= 100; i++) {
			sut.add(i);
		}		
		for (int i = 0; i <= sut.getSize() - 1; i++) {
			assertEquals(i+1, sut.get(i));
		}
		assertEquals(100, sut.getSize());

	}
	
	@Test
	void should_remove_item_at_index() {
		CustomList<String> sut = new CustomArrayList<>();
		for(int i = 0; i < 8; i++) {
			sut.add("Item - " + i);
		}
		assertEquals(8, sut.getSize());
		assertEquals("Item - 1", sut.remove(1));
		assertEquals(7,sut.getSize());
		assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(11));
	}
	
	@Test
	void should_remove_item_at_index_and_return_empty_array() {
		CustomList<String> sut = new CustomArrayList<>();
		sut.add("Item - 1");
		assertEquals(1, sut.getSize());
		assertEquals("Item - 1", sut.remove(0));
		assertEquals(0,sut.getSize());
		assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(11));
	}
	
	@Test
	void should_add_item_at_index() {
		CustomList<String> sut = new CustomArrayList<>();
		for(int i = 0; i < 8; i++) {
			sut.add("Item - " + i);
		}
		sut.add(1, "Better make room!");
		assertEquals(9, sut.getSize());
		assertEquals("Better make room!", sut.get(1));
		assertNull(sut.get(9));
		assertThrows(IndexOutOfBoundsException.class, () -> sut.add(10, "Index doesnt exist yet"));
	}
	
	@Test
	void should_add_item_at_index_and_resize_backing_array() {
		CustomList<String> sut = new CustomArrayList<>();
		for(int i = 0; i < 10; i++) {
			sut.add("Item - " + i);
		}
		assertEquals(10, sut.getSize());
		sut.add(1, "Better make room!");
		assertEquals(11, sut.getSize());
		assertEquals("Better make room!", sut.get(1));
		assertNull(sut.get(15));
		assertThrows(IndexOutOfBoundsException.class, () -> sut.add(21, "Testing: Invalid get in backing array."));
	}
	
	@Test
	void should_get_item() {
		CustomList<String> sut = new CustomArrayList<>();
		for(int i = 0; i < 6; i++) {
			sut.add("Item - " + i);
		}
		assertEquals(6, sut.getSize());
		assertEquals("Item - 5", sut.get(5));
		assertNull(sut.get(6));
		assertThrows(IndexOutOfBoundsException.class, () -> sut.get(11));
	}
	
	
}
