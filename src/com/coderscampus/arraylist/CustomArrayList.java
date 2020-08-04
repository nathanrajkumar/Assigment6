package com.coderscampus.arraylist;

public class CustomArrayList<T> implements CustomList<T> {
	int size = 10;
	Object[] items = new Object[size];
	int itemCounter = 0;

	@Override
	public boolean add(T item) {
		if (itemCounter == items.length) {
			items = extendArray();
		}		
		items[itemCounter++] = item;
		return true;
	}

	private Object[] extendArray() {
		size = items.length * 2;
//		System.out.println("Extend Array: " + size);
		Object[] newArray = new Object[size];
		for(int i = 0; i < items.length; i++) {
			newArray[i] = items[i];
		}
		return newArray;
	}

	@Override
	public int getSize() {
		return itemCounter;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		return (T)items[index];
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		items = addAndResizeBackingArray(index, item);
		itemCounter++;
		return true;
	}

	private Object[] addAndResizeBackingArray(int index, T item) {
		if (itemCounter == items.length) {
			items = extendArray();
		}
		Object[] resizedArray = new Object[size];
		resizedArray[index] = item;
		int counter = 0;
		for (int i = 0; i < items.length; i++) {
			if (resizedArray[i] == null) {
				resizedArray[i] = items[counter++];
			}
		}
		return resizedArray;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {	
		T itemToRemove = (T) items[index];
		items = removeItemFromBackingArray(index);
		itemCounter--;
		return itemToRemove;
	}

	private Object[] removeItemFromBackingArray(int index) {
		Object[] resizedArray = new Object[size];
		int counter = 0;
		for(int i = 0 ; i < this.getSize(); i++) {
			if (!items[i].equals(items[index])) {
				resizedArray[counter++] = items[i];
			};
		}
		return resizedArray;
	}
	
}
