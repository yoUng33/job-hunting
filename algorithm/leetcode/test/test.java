class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null || nums.length == 0) return nums;
        int numsR = nums.length, numsC = nums[0].length;
        if(r*c != numsR*numsC) return nums;

        int[][] res = new int[r][c];

        int ni = 0, nj = 0;
        for(int i = 0; i<numsR; i++){
            for(int j = 0; j<numsC; j++){
                if(nj >= c){
                    ni++; nj=0;
                }
                res[ni][nj] = nums[i][j];
                ni++; nj++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] input = {{1,2},{3,4}};
        Solution so = new Solution();
        so.matrixReshape(input, 1, 4);
    }
}