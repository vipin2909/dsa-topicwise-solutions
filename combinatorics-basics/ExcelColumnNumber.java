
public class ExcelColumnNumber {
    int titleToNumber(String A) {
        int[] arr = new int[27];
        for(int i = 1; i <= 26; i++) arr[i] = i;
        char[] charArr = A.toCharArray();
        int res = arr[charArr[0]-'A'+1];
        for(int i = 1; i < charArr.length; i++) {
           res = arr[charArr[i]-'A'+1]+26*res;
        }
        return res;
    }    
}
