/*
Given your favorite String array. Find the occurances of each in pie value of given size. 

*/

class PiExample {
    String piVal = "31415926535897932384626433832795028841971";
    String[] fav = {"314", "89793238462", "0288419", "3238", "5555555555", "14", "28841"};

    int length = piVal.length();
    int spaces = 0;
    Map<String, Boolean> favMap;
    int minSizeFav;

    void createMap(Map<String, Boolean> favMap) {
        minSizeFav = Integer.MAX_VALUE;
        for (String val : fav) {
            minSizeFav = Math.min(minSizeFav, val.length());
            favMap.put(val, false);
        }
    }

    public static void main(String args[]) {
        PiExample piExample = new PiExample();
        piExample.favMap = new LinkedHashMap<>();
        piExample.createMap(piExample.favMap);
        int[] visited = new int[piExample.length];
        for (int c = 0; c < visited.length; ++c) visited[c] = -1;
        System.out.println(piExample.checkVal(0, visited));
    }

    int checkVal(int pos, int[] visited) {
        if (pos == length) return 0;

        int ans = Integer.MAX_VALUE;

        String pref = "";
        for (int i = pos; i < length; ++i) {
            int j = length;
            while ((j > i) & (j - i >= minSizeFav)) {
                pref = piVal.substring(i, j);
                j--;
                if (exists(pref, i, j + 1, visited)) {
                    spaces++;
                    int other = Integer.MAX_VALUE;
                    other = checkVal(j + 1, visited);
                    {
                        ans = Math.min(spaces, other);
                    }
                }
            }
        }
        return ans;
    }

    boolean exists(String pref, int start, int end, int[] visited) {
        Boolean value_Val = favMap.containsKey(pref);
        Boolean value_Key = (value_Val != null) ? favMap.get(pref) : true;
        if (value_Val == false) return false;
        if (value_Key == true) return false;

        int tempStrat = start;
        while (end >= tempStrat) {
            if (visited[tempStrat] == 0)
                return false;
            tempStrat++;
        }
        favMap.replace(pref, true);
        while (end >= start) {
            visited[start] = 0;
            start++;
        }
        return true;
    }
}
