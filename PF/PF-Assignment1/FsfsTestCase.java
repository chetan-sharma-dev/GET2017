package pfsession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FsfsTestCase {

	Fcfs scheduling;

	@Before
	public void setUp() {
		scheduling = new Fcfs();
	}

	/*
	 * positive test case where expected output is right so it should return
	 * true
	 */

	@Test
	public void fsfsTestCase1() {
		int[] arrival_time = { 1, 5, 9, 25 };
		int[] job_size = { 12, 7, 2, 5 };

		int[][] expected_output = { { 1, 0, 1, 12 }, { 5, 8, 13, 19 },
				{ 9, 11, 20, 21 }, { 25, 0, 25, 29 } };

		int[][] actual_output = scheduling.FCFS(arrival_time, job_size);
		System.out
				.println("Job\t Arrival Time\t Wait Time\t Start at\t Finish Time");
		int array_length = arrival_time.length;
		for (int row = 0; row < array_length; row++) {
			System.out.print((row + 1) + "\t\t");
			for (int column = 0; column < array_length; column++) {
				System.out.print(actual_output[row][column] + "\t\t");
			}
			System.out.println();
		}
		Assert.assertFalse(scheduling.isArrayEqual(expected_output,
				actual_output));
	}

	/*
	 * negative test case where expected output is not right so it should return
	 * false
	 */
	@Test
	public void fsfsTestCase2() {
		int[] arrival_time = { 0, 5, 8, 11, 15 };
		int[] job_size = { 12, 19, 21, 13, 15 };

		int[][] expected_output = { { 1, 0, 0, 1, 12 }, { 2, 5, 8, 13, 31 },
				{ 3, 8, 24, 32, 52 }, { 4, 11, 42, 53, 65 },
				{ 5, 15, 51, 66, 80 } };
		int[][] actual_output = scheduling.FCFS(arrival_time, job_size);
		System.out
				.println("Job\t Arrival Time\t Wait Time\t Start at\t Finish Time");
		int array_length = arrival_time.length;
		for (int row = 0; row < array_length; row++) {
			System.out.print((row + 1) + "\t\t");
			for (int column = 0; column < 4; column++) {
				System.out.print(actual_output[row][column] + "\t\t");
			}
			System.out.println();
		}
		Assert.assertFalse(scheduling.isArrayEqual(expected_output,
				actual_output));

	}
}
