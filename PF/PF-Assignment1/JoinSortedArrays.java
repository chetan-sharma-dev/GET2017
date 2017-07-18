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
		     when one of these both is traced fully ,we are coping as it is
			 the remaining array elements
			 
		 */
		if (asize > 0 && bsize > 0) {
			if (asize < 2 && bsize < 2) {
				if (a[0] > b[0]) {
					c[0] = b[0];
					c[1] = a[0];
				} else {
					c[0] = a[0];
					c[1] = b[0];
				}

			}  else {
				if ((a.length>=2&&a[0] < a[1])||(b.length>=2&&b[0] < b[1])) {
					while (i < asize && j < bsize) {
						if (a[i] < b[j]) {
							c[k++] = a[i++];
						} else {
							c[k++] = b[j++];
						}
					}
					if (i == asize && j != bsize) {
						while (j < bsize) {
							c[k++] = b[j++];
						}
					} else if (i != asize && j == bsize) {
						while (j < bsize) {
							c[k++] = a[i++];
						}

					}
				} else {
					while (i < asize && j < bsize) {
						if (a[i] > b[j]) {
							c[k++] = a[i++];
						} else {
							c[k++] = b[j++];
						}
					}
					if (i == asize && j != bsize) {
						while (j < bsize) {
							c[k++] = b[j++];
						}
					} else if (i != asize && j == bsize) {
						while (j < bsize) {
							c[k++] = a[i++];
						}

					}
				}
			}
			

		}
		return c;
	}

}
