package alg;

import java.util.Arrays;

public class SortAlgs {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,1,5};
//        quickSort(nums, 0, nums.length-1);
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 快速排序
     * @param nums
     * @param start
     * @param end
     */
    public static void quickSort(int[] nums, int start, int end){
        if(nums == null || start>=end){
            return;
        }
        int key = nums[start]; // 为其找到排序后的位置
        int i = start;
        int j = end;
        while (i<j){
            while (i<j && key<=nums[j]){
                j--;
            }
            if(i<j){
                nums[i] = nums[j];
                nums[j] = key;
            }
            while (i<j && key>nums[i]){
                i++;
            }
            if(i<j){
                nums[j] = nums[i];
                nums[i] = key;
            }
        }
        quickSort(nums, start, i-1);
        quickSort(nums, j+1, end);
    }

    /**
     * 归并排序
     * @param nums
     * @param start
     * @param end
     */
    public static void mergeSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (end+start)/2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1, end);
        // start到mid、mid+1到end都是有序的了
        int l = start;
        int r = mid+1;
        int[] tmp = new int[end-start+1];      //  保存归并后的结果
        int count=0;                           //  记录归并到的位置
        while (l<=mid && r<=end){
            if(nums[l] <= nums[r]){
                tmp[count++] = nums[l++];
            }
            else{
                tmp[count++] = nums[r++];
            }
        }
        while(l<=mid){
            tmp[count++] = nums[l++];
        }
        while(r<=end){
            tmp[count++] = nums[r++];
        }
        for(int i=0; i<count; i++){
            nums[start++] = tmp[i];
        }
    }
}
