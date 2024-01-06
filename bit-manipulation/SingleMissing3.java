public class SingleMissing3 {
    public int[] solve(int[] A) {
        int xor = 0;
        for(int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }

        int firstSetIndex = 0;
        for(int i = 0; i < 32; i++) {
            if((xor & (1 << i)) != 0) {
                firstSetIndex = i;
                break;
            }
        }

        int[] arr = new int[2];

        int xor1 = 0;
        int xor2 = 0;
        for(int i = 0; i < A.length; i++) {
            if((A[i] & ( 1 << firstSetIndex)) != 0) {
                xor1 ^= A[i];
            }
            else {
                xor2 ^= A[i];
            }
        }

        arr[0] = xor1 > xor2 ? xor2 : xor1;
        arr[1] = xor1 > xor2 ? xor1 : xor2;
        return arr;
    }
}
