// -------------------------------------------------------------------------
/**
 *  This class contains only two static methods that search for points on the
 *  same line in three arrays of integers. 
 *
 *  @author  duffyow@tcd.ie
 *  @version 03/10/16 17:10:35
 */
class Collinear
{
	public static final int Y1=1;
	public static final int Y2=2;
	public static final int Y3=3;


	// ----------------------------------------------------------
	/**
	 * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
	 * This method is static, thus it can be called as Collinear.countCollinear(a1,a2,a3)
	 * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
	 * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
	 * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
	 * @return the number of points which are collinear and do not lie on a horizontal line.
	 *
	 * Array a1, a2 and a3 contain points on the horizontal line y=1, y=2 and y=3, respectively.
	 * A non-horizontal line will have to cross all three of these lines. Thus
	 * we are looking for 3 points, each in a1, a2, a3 which lie on the same
	 * line.
	 *
	 * Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if
	 * 
	 * x1*(y2−y3) + x2*(y3−y1) + x3*(y1−y2)=0 
	 *
	 * In our case y1=1, y2=2, y3=3.
	 *
	 * You should implement this using a BRUTE FORCE approach (check all possible combinations of numbers from a1, a2, a3)
	 *
	 * ----------------------------------------------------------
	 *
	 * Experimental Performance:
	 * -------------------------
	 *  Write the running time of the algorithm when run with the following input sizes
	 *  
	 *  Input Size N      Running Time (sec)
	 *  ------------------------------------
	 *  1000              TODO
	 *  2000              TODO
	 *  4000              TODO
	 *
	 *  Assuming that the running time of your algorithm is of the form aN^b,
	 *  estimate 'b' and 'a' by fitting a line to the experimental points:
	 *
	 *  b = TODO
	 *  a = TODO
	 *
	 *  What running time do you predict using your results for input size 5000?
	 *  What is the actual running time you get with such an input?
	 *  What is the error in percentage?
	 *
	 *  Error = ( (Actual time) - (Predicted time) ) * 100 / (Predicted time)
	 *
	 *  Input Size N      Predicted Running Time (sec)        Actual Running Time (sec)       Error (%)
	 *  ------------------------------------------------------------------------------------------------
	 *  5000              TODO                                TODO                            TODO
	 * 
	 *  Order of Growth
	 *  -------------------------
	 *
	 *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
	 *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
	 *
	 *  Order of growth: TODO
	 *
	 *  Explanation: TODO
	 */
	static int countCollinear(int[] a1, int[] a2, int[] a3)
	{
		//TODO: implement this method
		//x1*(y2−y3) + x2*(y3−y1) + x3*(y1−y2)=0
		int numCollinear=0;
		for(int x1: a1)
			for(int x2: a2)
				for(int x3: a3)
				{
					if(x1*(Y2-Y3) + x2*(Y3-Y1) + x3*(Y1-Y2)==0)
						numCollinear++;
				}
		return numCollinear;
	}

	// ----------------------------------------------------------
	/**
	 * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
	 * This method is static, thus it can be called as Collinear.countCollinearFast(a1,a2,a3)
	 * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
	 * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
	 * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
	 * @return the number of points which are collinear and do not lie on a horizontal line.
	 *
	 * In this implementation you should make non-trivial use of InsertionSort and Binary Search.
	 * The performance of this method should be much better than that of the above method.
	 *
	 * Experimental Performance:
	 * -------------------------
	 *  Measure the running time of the algorithm when run with the following input sizes
	 *  
	 *  Input Size N      Running Time (sec)
	 *  ------------------------------------
	 *  1000              TODO
	 *  2000              TODO
	 *  4000              TODO
	 *  5000              TODO
	 *
	 *
	 *  Compare Implementations:
	 *  ------------------------
	 *  Show the sppedup achieved by this method, using the times you got from your experiments.
	 *
	 *  Input Size N      Speedup = (time of countCollinear)/(time of countCollinearFast)
	 *  ---------------------------------------------------------------------------------
	 *  1000              TODO
	 *  2000              TODO
	 *  4000              TODO
	 *  5000              TODO
	 *
	 *
	 *  Order of Growth
	 *  -------------------------
	 *
	 *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
	 *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
	 *
	 *  Order of Growth: TODO
	 *
	 *  Explanation: TODO
	 *
	 *
	 */
	static int countCollinearFast(int[] a1, int[] a2, int[] a3)
	{
		sort(a1);
		sort(a2);
		sort(a3);
		int numCollinear=0;
		for(int x1: a1)
		{
			for(int x2: a2)
			{
				//				for(int x3: a3)
				//				{
				//					if(x1*(Y2-Y3) + x2*(Y3-Y1) + x3*(Y1-Y2)==0)
				//						numCollinear++;
				//				}
				int key=(((x1*(Y2-Y3) + x2*(Y3-Y1))*-1) /(Y1-Y2) );
				if(binarySearch(a3,key))
				{
					numCollinear++;
				}
			}
		}
		return numCollinear;

	}

	// ----------------------------------------------------------
	/**
	 * Sorts an array of integers according to InsertionSort.
	 * This method is static, thus it can be called as Collinear.sort(a)
	 * @param a: An UNSORTED array of integers. 
	 * @return after the method returns, the array must be in ascending sorted order.
	 *
	 * ----------------------------------------------------------
	 *
	 * Approximate Mathematical Performance:
	 * -------------------------------------
	 *  Using an appropriate cost model, give the performance of your algorithm.
	 *  Explain your answer.
	 *
	 *  Performance: TODO
	 *
	 *  Explanation: TODO
	 *
	 */
	static void sort(int[] a)
	{
		for(int i=1; i<a.length; i++)
		{
			int j=i;
			int x=a[i];
			while(j>0 && x<a[j-1])
			{
				a[j]=a[j-1];
				j--;
			}
			a[j]=x;
		}
		return;
	}

	// ----------------------------------------------------------
	/**
	 * Searches for an integer inside an array of integers.
	 * This method is static, thus it can be called as Collinear.binarySearch(a,x)
	 * @param a: A array of integers SORTED in ascending order.
	 * @param x: An integer.
	 * @return true if 'x' is contained in 'a'; false otherwise.
	 *
	 * ----------------------------------------------------------
	 *
	 * Approximate Mathematical Performance:
	 * -------------------------------------
	 *  Using an appropriate cost model, give the performance of your algorithm.
	 *  Explain your answer.
	 *
	 *  Performance: TODO
	 *
	 *  Explanation: TODO
	 *
	 */
	static boolean binarySearch(int[] a, int x)
	{
		//TODO: implement this method
		int left=0;
		int right=a.length-1;
		while(left<=right)
		{
			int middle=(int) Math.floor((left+right)/2);
			if(a[middle]>x)
			{
				right=middle-1;
			}
			else if(a[middle]<x)
			{
				left=middle+1;
			}
			else
			{
				return true;
			}
		}
		return false;
	}


}
