
public class ExcelColumnTitle {
    public String convertToTitle(int A) {
        StringBuilder sb = new StringBuilder("");
        while(A > 0) {
            A -= 1;
            int rem = A % 26;
            sb.append((char)(rem+'A'));
            A /= 26;
        }
        return sb.reverse().toString();  
    }    
    public static void main(String[] args) {
        int num = 52;
        String res = new ExcelColumnTitle().convertToTitle(num);
        System.out.println(res);
    }
}
