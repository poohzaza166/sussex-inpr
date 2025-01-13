import java.util.ArrayList;
import java.util.List;

public class CheckSum {
    private String cardNo;
    public CheckSum(String cardNo) {
        this.cardNo = cardNo;
    }

    public boolean doCheckSum() {
        int[] digits = this.cardNo.chars().map(c -> c-'0').toArray();
        List<Integer> results = new ArrayList<Integer>();
        for (int i = 0; i <= digits.length - 1; i++){
            if (i % 2 == 0){
                int result = digits[i] * 2;
//                System.out.println(digits[i]);
                if ((int)(Math.log10(result)+1) > 1){
                    int[] res = Integer.toString(result).chars().map(c -> c-'0').toArray();
                    result = res[0] + res[1];
                }
                results.add(result);
            }
            else {
                results.add(digits[i]);
            }
        }
        int tmp = 0;
        for (Integer stuff : results){
//            System.out.println(stuff);
            if (tmp == 0){
                tmp = (int) stuff.intValue();
            }
            else {
                tmp = stuff.intValue() + tmp;
            }
        }
        System.out.println(tmp);
        if (tmp % 10 == 0){
            return true;
        }
        return false;
    }
}
