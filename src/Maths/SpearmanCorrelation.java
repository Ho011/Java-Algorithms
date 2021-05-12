package Maths;

public class SpearmanCorrelation {
    public static void main (String[] args) {
        int[] x = new int[]{2,4,2,3};
        int[] y = new int[]{3,5,1,4};
        System.out.println(getSpearmanCorrelation(x , y));
    }
    public static double getSpearmanCorrelation(int[] x , int[] y){
        var x_rank = rank(x);
        var y_rank = rank(y);
        int n = x.length;
        double sigma_ds = 0.0;
        for (int i = 0; i < n; i++) {
            sigma_ds += Math.pow((x_rank[i] - y_rank[i]) , 2);
        }
        return 1 - ( (6 * sigma_ds) / ( Math.pow(n , 3) - n));
    }
    public static double[] rank(int[] nums){
        int r , s , size = nums.length;
        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            r = s = 1;
            for (int j = 0; j < size; j++) {
                if (i != j && nums[j] < nums[i])++r;
                if (i != j && nums[j] == nums[i])++s;
            }
            result[i] = r + (float)(s - 1) / (float) 2;
        }
        return result;
    }
}
