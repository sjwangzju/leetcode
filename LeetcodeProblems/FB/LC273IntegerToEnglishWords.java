package FB;

public class LC273IntegerToEnglishWords {

    String[] belowTen = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    String[] belowTwenty = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] belowHundred = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return getWord(num);
    }

    public String getWord(int n) {
        String res;
        if (n < 10) return belowTen[n];
        else if (n < 20) res =  belowTwenty[n - 10];
        else if (n < 100) res =  belowHundred[n / 10] + " " + getWord(n % 10);
        else if (n < 1000) res = getWord(n / 100) + " Hundred " + getWord(n % 100);
        else if (n < 1000000) res = getWord(n / 1000) + " Thousand " + getWord(n % 1000);
        else if (n < 1000000000) res = getWord(n / 1000000) + " Million " + getWord(n % 1000000);
        else res = getWord(n / 1000000000) + " Billion " + getWord(n % 1000000000);
        return res.trim();
    }

    public static void main(String[] args) {
        String s = new LC273IntegerToEnglishWords().numberToWords(123455);
        System.out.println(s);
    }
}
