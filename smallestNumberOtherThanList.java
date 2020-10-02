/*
Write a function:

    class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
Given A = [1, 2, 3], the function should return 4.
Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−1,000,000..1,000,000].
*/

import java.util.HashMap;
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
    HashMap<Integer, Integer> map = new HashMap<>(A.length); //O(n) space
    for (int i : A) // O(N)
    {
        if (!map.containsKey(i))
        {
            map.put(i, i);
        }
    }
    int smallestPositive = 1;
    for (int i = 1; i < 1000001; i++) // ~O(N)
    {
        if (map.containsKey(i)) {
            if (map.get(i) <= smallestPositive)
                smallestPositive = map.get(i) + 1;
        }
        else return smallestPositive;
    }
    return smallestPositive;
    }
}
