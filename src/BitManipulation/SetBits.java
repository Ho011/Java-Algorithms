package BitManipulation;

public class SetBits {
    public static int setIthBit(int n , int i){
        if (i <= 0 || i > 32){
            throw new IllegalArgumentException("The position must be between 1 and 32");
        }
        // ith bit of n is being cleared by this operation.
        return n | (1 << i -1);
    }
    public static int setIthBitTo0(int n , int i){
        if (i <= 0 || i > 32){
            throw new IllegalArgumentException("The position must be between 1 and 32");
        }
        return n & ~(1 << i - 1);
    }
    public static void main (String[] args) {
        System.out.println(setIthBit(1,7));
        System.out.println(setIthBitTo0(65,7));
    }
}
