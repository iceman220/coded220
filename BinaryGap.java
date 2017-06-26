/**
 * This class provides a solution for the binary gap problem in the Codility
 * code test. It finds the longest binary gap within the binary representation
 * of the given number.
 * 
 * A binary gap is defined as a number of 0s within 2 1's of a decimal number's
 * binary representation
 * 
 * @author I326494
 *
 */

public class BinaryGap {

	public int solution(int N) {
		return this.intToBinary(N);
	}

	/**
	 * This method returns the binary value of an integer.
	 * 
	 * @param n
	 * @return integer value of the number
	 */
	public int intToBinary(int n) {
		String bin = "";

		while (n > 0) {
			int x = n % 2;
			bin = bin + x;
			n = n / 2;
		}
		String result = new StringBuffer(bin).reverse().toString();
		return this.binaryGap(result);
	}

	/**
	 * This method returns the largest binary gap in a number.
	 * 
	 * @param n
	 * @return largest binary gap
	 */
	public int binaryGap(String n) {
		int largestBinGap = 0;
		for (int i = 0; i < n.length() - 1; i++) {
			if (n.charAt(i) == '1' && n.charAt(i + 1) == '0') {
				for (int j = i + 1; j < n.length(); j++) {
					if (n.charAt(j) == '1') {
						if (this.allZeros(n, i, j) == true
								&& j - i > largestBinGap) {
							largestBinGap = j - i - 1;
							break;
						}
					}
				}
			}
		}
		return largestBinGap;
	}

	/**
	 * This method checks if all the digits between i and j are zeros. if so
	 * then it returns true.
	 * 
	 * @param n
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean allZeros(String n, int i, int j) {
		for (int c = i + 1; c < j; c++) {
			if (n.charAt(c) != '0') {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		BinaryGap ob1 = new BinaryGap();
		System.out.println(ob1.solution(74901729));
		System.out.println(ob1.solution(1376796946));
		System.out.println(ob1.solution(561892));
	}
}
