package org.example;

import java.util.*;

public class Main {
    static Map<Character, Integer> ori = new HashMap<>();
    static Map<Character, Integer> cnt = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        for(int i=0; i<t.length(); i++){
            int num = ori.getOrDefault(t.charAt(i), 0);
            ori.put(t.charAt(i), num+1);
        }
        int L = 0;
        int R = 0;
        int newL = -1;
        int newR = -1;
        int len = Integer.MAX_VALUE;
        while(R<s.length()){
            if(ori.containsKey(s.charAt(R))){
                cnt.put(s.charAt(R), cnt.getOrDefault(s.charAt(R), 0)+1);
            }
            while(check()){
                if(R-L+1<len){
                    newL=L;
                    newR=R;
                    len = R-L+1;
                }
                cnt.put(s.charAt(L), cnt.getOrDefault(s.charAt(L), 0)-1);
                L++;
            }
            R++;
        }
        return newL==-1?"" : s.substring(newL, newR+1);
    }

    public static boolean check() {
        for(Map.Entry entry : ori.entrySet()){
            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if(cnt.getOrDefault(key, 0) < value){
                return false;
            }
        }
        return true;
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> result = new ArrayList<int[]>();
        for(int i=0; i< intervals.length; i++){
            if(i==0){
                result.add(intervals[0]);
                continue;
            }
            int L = intervals[i][0];
            int R = intervals[i][1];
            if(L <= result.get(result.size()-1)[1]){
                int[] combine = new int[]{result.get(i-1)[0], Math.max(R, result.get(result.size()-1)[1])};
                result.set(i-1, combine);
            }
            else {
                int[] ele = intervals[i][1] > result.get(result.size()-1)[1]? new int[]{L, intervals[i][1]} : new int[]{L, result.get(result.size()-1)[1]};
                result.add(ele);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static int getKthNumber(int[] nums1, int[] nums2, int k){
        int index1 = 0;
        int index2 = 0;
        int half = k/2;
        while(true){
            if(index1 == nums1.length){
                return nums2[index2 + k -1];
            }
            if(index2 == nums2.length){
                return nums1[index1 + k -1];
            }
            if(k==1){
                return Math.min(nums1[index1], nums2[index2]);
            }

            int newIndex1 = Math.min(index1+half, nums1.length) - 1;
            int newIndex2 = Math.min(index2+half, nums2.length) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            if(pivot1 <= pivot2){
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }
            else{
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
            half = k/2;
        }
    }
}