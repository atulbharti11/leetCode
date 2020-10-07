/*
Given a string a consists of upper/lowercase alphabet characters and empty space characters '',
return the length of the last word in the string.
If the last word doesn't exist, return 0.
/*

class Solutionnn {

    public static int countLength(String s){
        if(s.substring(s.length()-1).equals(" ") ) return 0;
        if(s.length() == 0 || s.isEmpty()){
            return 0;
        }
        String[] arr = s.split(" ");
        int strLen = arr.length;
        int lastWordLength = arr[strLen-1].length();
        return lastWordLength;
    }

    public static void main(String[] args) {
        String s = "Interview test for xxx company";
        System.out.println(countLength(s));
    }
}
