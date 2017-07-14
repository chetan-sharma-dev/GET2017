package pfsession;

/*
 * program for joining sorted arrays
 * 
 */
public class JoinSortedArrays {

	public int[] join(int a[], int asize, int b[], int bsize, int c[]) {
		int i = 0, j = 0, k = 0;
		/*
		 * here this following code is comparing both arrays and storing values
		 * in third array named as c
		 */

		while (i < asize && j < bsize) {
			if (a[i] < b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}
		/*
		 * when one of these both is traced fully ,we are coping as it is the
		 * remaining array elements
		 */
		if (i == asize && j != bsize) {
			while (j < bsize) {
				c[k++] = b[j++];
			}
		} else if (i != asize && j == bsize) {
			while (j < bsize) {
				c[k++] = a[i++];
			}

		}
		return c;
	}

}
