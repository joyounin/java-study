package chapter03;

public class ArrayUtil {

	public static double[] intToDouble(int[] is) {
		double[] result = new double[is.length];

		for (int i = 0; i < is.length; i++) {
			result[i] = is[i];
		}
		return result;
	}

	public static int[] doubleToInt(double[] ds) {
		int[] result1 = new int[ds.length];

		for (int i = 0; i < ds.length; i++) {
			result1[i] = (int) ds[i];
		}
		return result1;
	}

	public static int[] concat(int[] is, int[] is2) {
		int destLength = is.length + is2.length;
		int[] dest = new int[destLength];
		System.arraycopy(is, 0, dest, 0, is.length);
		System.arraycopy(is2, 0, dest, is.length, is2.length);

		return dest;
	}

}
