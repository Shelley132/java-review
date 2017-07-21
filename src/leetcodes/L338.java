package leetcodes;

public class L338 {

	public int[] countBits(int num) {
		int[] arrays = new int[num + 1];

		for (int i = 0; i <= num; i++) {
			int numbers = 0;
			int j = i;
			while (j > 0) {
				j = j & (j - 1);
				numbers++;
			}
			arrays[i] = numbers;
		}
		return arrays;
	}
	
	public int[] countBits2(int num){
		 /*--- varables declaration ---*/
        int[] result =  new int[num + 1];
        
        result[0] = 0;
        /*--- boundary conditions ---*/
        if (num == 0) return result;
        
        result[1] = 1;
        /*--- boundary conditions ---*/
        if (num == 1) return result;
        
        /*--- build our solutions ---*/
        for (int i = 2; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                result[i] = 1;
            } else {
                if (i % 2 == 0) {
                    result[i] = result[i / 2];
                } else {
                    result[i] = result[i - 1] + 1;
                }
            }
        }
        return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L338 obj = new L338();
		
		int[] arr = obj.countBits2(5);
		for (int i : arr) {
			System.out.println(i);
		}
	}

}
