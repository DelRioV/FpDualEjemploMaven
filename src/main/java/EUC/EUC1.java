package EUC;

public class EUC1 {

	public EUC1() {}

	public boolean comprobar1(int[] nums) {
		boolean kk = false;
		if (nums[0] == 6 || nums[nums.length - 1] == 6) {
			kk = true;
		}
		return kk;
	}

	public static void main(String[] args) {
		EUC1 cl = new EUC1();
		System.out.println(cl.comprobar1(new int[] { 1, 2, 3, 4, 5, 6 }));
	}

}
