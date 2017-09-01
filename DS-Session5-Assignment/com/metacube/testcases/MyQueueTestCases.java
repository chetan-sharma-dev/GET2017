package com.metacube.testcases;

import static org.junit.Assert.assertEquals;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;
import com.metacube.queue.MyQueue;

public class MyQueueTestCases {

	MyQueue<Integer> queue;

	@Before
	public void setUpObject() {
		queue = new MyQueue<Integer>();
	}

	@Test
	public void addElemeentPoaitiveTestCase() {
		boolean actualOutput = queue.add(10);
		assertEquals(true, actualOutput);
	}

	@Test
	public void peekPositiveTestCase() {
		queue.add(10);
		queue.add(20);
		int actualOutput = queue.peek();
		assertEquals(10, actualOutput);
	}

	@Test
	public void emptyQueueCasePeekTestCase() {
		assertEquals(null, queue.peek());
	}

	@Test
	public void elementMethodTestCase() {
		queue.add(10);
		queue.add(20);
		int actualOutput = queue.element();
		assertEquals(10, actualOutput);
	}

	@Test(expected = NoSuchElementException.class)
	public void elementMethodExceptionTestCase() {
		queue.element();
	}

	@Test
	public void pollMethodtestCase() {
		queue.add(10);
		queue.add(20);
		int actualOutput = queue.poll();
		assertEquals(10, actualOutput);
	}

	@Test
	public void pollMethodNullTestCase() {
		assertEquals(null, queue.poll());
	}

	@Test
	public void removeMethodTestCase() {
		queue.add(10);
		queue.add(20);
		int actualOutput = queue.remove();
		assertEquals(10, actualOutput);
	}

	@Test(expected = NoSuchElementException.class)
	public void removeMethodExceptionTestCase() {
		queue.remove();
	}

	@Test
	public void isEmptyMethodTestCase() {
		queue.add(10);
		boolean actualOutput = queue.isEmpty();
		assertEquals(false, actualOutput);
	}

	@Test
	public void isEmptyTrueTestCase() {
		boolean actualOutput = queue.isEmpty();
		assertEquals(true, actualOutput);
	}

	@Test
	public void clearMethodTestCase() {
		queue.add(10);
		queue.clear();
		boolean actualOutput = queue.isEmpty();
		assertEquals(true, actualOutput);
	}
}
