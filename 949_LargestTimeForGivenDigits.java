/*
949 - Largest Time for Given Digits

Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.
24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.
Return the latest 24-hour time in "HH:MM" format.  If no valid time can be made, return an empty string.

Example 1:

Input: A = [1,2,3,4]
Output: "23:41"
Explanation: The valid 24-hour times are "12:34", "12:43", "13:24", "13:42", "14:23", "14:32", "21:34", "21:43", "23:14", and "23:41". Of these times, "23:41" is the latest.

Example 2:

Input: A = [5,5,5,5]
Output: ""
Explanation: There are no valid 24-hour times as "55:55" is not valid.

Example 3:

Input: A = [0,0,0,0]
Output: "00:00"

Example 4:

Input: A = [0,0,1,0]
Output: "10:00"


Constraints:

    arr.length == 4
    0 <= arr[i] <= 9

*/


class Solution {

    private int max_time = -1;
    
    public String largestTimeFromDigits(int[] arr) {
        
        this.max_time = -1;
        
        for (int i1 = 0; i1 < arr.length; ++i1)
            for (int i2 = 0; i2 < arr.length; ++i2)
                for (int i3 = 0; i3 < arr.length; ++i3) {
                    // skip duplicate elements
                    if (i1 == i2 || i2 == i3 || i1 == i3)
                        continue;
                    // the total sum of indices is 0 + 1 + 2 + 3 = 6.
                    int i4 = 6 - i1 - i2 - i3;
                    int [] perm = {arr[i1], arr[i2], arr[i3], arr[i4]};
                    // check if the permutation can form a time
                    validateTime(perm);
                }
        
        if (this.max_time == -1)
            return "";
        else
            return String.format("%02d:%02d", max_time / 60, max_time % 60);
        
    }
    
    protected void validateTime(int[] perm) {
        int hour = perm[0] * 10 + perm[1];
        int minute = perm[2] * 10 + perm[3];
        if (hour < 24 && minute < 60)
            this.max_time = Math.max(this.max_time, hour*60 + minute);
    }
    
}
