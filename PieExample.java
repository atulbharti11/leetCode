/*
Given your favorite String array. Find the occurances of each in pie value of given size.
*/

class PiExample {
    String piVal = "31415926535897932384626433832795028841971";
    char[] piValCharArr = piVal.toCharArray();
    String [] fav = {"314", "89793238462", "0288419", "3383", "5555555555"};
    
    int length = piVal.length();
    int spaces = 0;
    Map<String, Boolean> favMap;
    int minSizeFav;

    void createMap(Map<String, Boolean> favMap) {
        minSizeFav = Integer.MAX_VALUE;
        for(String val: fav) {
            minSizeFav = Math.min(minSizeFav, val.length());
            favMap.put(val, false);
        }
    }

    public static void main(String args[]) {
        PiExample piExample = new PiExample();
        piExample.favMap = new TreeMap<>();
        piExample.createMap(piExample.favMap);
        System.out.println(piExample.checkVal (0));
    }

    int checkVal (int pos) {
        if (pos == length) return 0;

        int ans = Integer.MAX_VALUE;

        String pref = "";
        for (int i = pos; i < length; ++i) { //char c: piValCharArr) {
            int j = length;
            while ((j > i) & (j-i+1 > minSizeFav)) {
                pref = piVal.substring(i,j);
                j--;
                if (exists(pref)) {
                    spaces++;
                    int other = Integer.MAX_VALUE;
                    other = checkVal(i + 1);
                    {
                        ans = Math.min(spaces, other);
                    }
                }
            }
        }
        return ans;
    }

    boolean exists(String pref) {
        Boolean value_Val = favMap.get(pref);
        Boolean value_Key = favMap.containsKey(pref);
        if(value_Val == null) return false;

        if(value_Key &  (value_Val == false)) {
            favMap.replace(pref, true);
            return true;
        }
        return false;
    }
}
