/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;

/**
 *
 * @author KPeggy
 * LeetCode: 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public static void main(String[] args) {
        //Given nums = [2, 7, 11, 15], target = 9,
        int[] a = {2, 7, 11, 15};
        int t = 9;
        int ans[] = twoSum(a,t);
        String format = new String();
        format = "[";
        for(int i=0;i<ans.length;i++){
            
            format += ans[i];
            if(i==0) format += ",";
        }
        format += "]";
        System.out.println(format);
    }
    
     public static int[] twoSum(int[] nums, int target) {
        int q = 0;
        int[] ans = new int[2];
        int[] origin_num = new int[nums.length];
        System.arraycopy(nums, 0, origin_num, 0, nums.length);
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int first_num = nums[i];
            int second_num = target - first_num;
            q = Arrays.binarySearch(nums, second_num); 
            if(q!=-1) {
                for(int j=0;j< origin_num.length;j++){
                    if(first_num == origin_num[j]){
                        ans[0] = first_num;
                        first_num = -1;
                    }else if(second_num == origin_num[j]){
                        ans[1] = second_num;
                        second_num = -1;
                    }
                }
                if(first_num == -1 && second_num == -1) break;
            }
        }
        return ans;
    }
}
