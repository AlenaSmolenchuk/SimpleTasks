//You are given a sorted array consisting of only integers where every element appears exactly twice, 
//except for one element which appears exactly once.

//Return the single element that appears only once.



public class SingleElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,3,3,4,4,8,8};
        singleNonDuplicate(nums);
    }

    static void singleNonDuplicate(int[] nums){
      //1t solution
      int result = 0;
        for (int i = 0; i < nums.length;i++){
            result = result^nums[i];
        }
        System.out.println(result);
      
      //2nd solution
   /*     
        int result = 0;
        for (int i = 0; i < nums.length;i++){
           int count = 0;
           int value = nums[i];
           for (int j = 0; j < nums.length; j++)
               if (nums[j] == value) count++;
               if (count == 1){
                   System.out.println(value);
                   break;
               }
        }
    */
        
    }
}
