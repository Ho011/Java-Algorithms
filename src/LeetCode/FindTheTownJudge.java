package LeetCode;

/**
 * In a town, there are n people labelled from 1 to n.
 * There is a rumor that one of these people is secretly the town judge.
 * If the town judge exists, then:
 *
 * 1-The town judge trusts nobody.
 * 2-Everybody (except for the town judge) trusts the town judge.
 *
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b]
 * representing that the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified,
 * return the label of the town judge.  Otherwise, return -1.
 *
 *
 * Example 1:
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 *
 * Example 2:
 * Input: n = 3, trust = [[1,3],[2,3]]
 * Output: 3
 *
 * Example 3:
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 *
 * Example 4:
 * Input: n = 3, trust = [[1,2],[2,3]]
 * Output: -1
 *
 * Example 5:
 * Input: n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 *
 * Constraints:
 * 1 <= n <= 1000
 * 0 <= trust.length <= 104
 * trust[i].length == 2
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= n
 */
public class FindTheTownJudge {
    public static int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;
        int [] outDegree =  new int [n+1];
        int [] inDegree  = new int[n+1];
        for (int[] arr : trust){
            outDegree[arr[0]] += 1;
            inDegree[arr[1]] += 1;
        }
        for(int i = 1; i <= n; ++i){
            if(outDegree[i] == 0 && inDegree[i] == n - 1)
                return i;
        }
        return -1;
    }

    public static int findJudgeV2(int n, int[][] trust) {
        int[] visited = new int[n + 1];
        for (int[] arr : trust){
            visited[arr[0]]--; // out going edge
            visited[arr[1]]++; // incoming edge
        }
        for(int i = 1; i <= n; ++i){
            if (visited[i] == n - 1)
                return i;
        }
        return -1;
    }
    public static void main (String[] args) {
        int [][] trust = new int[][]{
                {1 , 3} ,
                {2 , 3} ,
                {4 , 2} ,
                {4 , 3}
        };
        System.out.println(findJudge(4 , trust));
    }
}
