import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> romanList = Arrays.asList("N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C");
        String[] str;
        if ((str = (new Scanner(System.in)).nextLine().split(" ")).length != 3) throw new Exception("Incorrect input format");
        if (new Scanner(str[0]).hasNextInt() && new Scanner(str[2]).hasNextInt()) {
            System.out.println(calc(Integer.parseInt(str[0]), Integer.parseInt(str[2]), str[1]));
        } else if (romanList.contains(str[0]) && romanList.contains(str[2])) {
            System.out.println(romanList.get(calc(romanList.indexOf(str[0]), romanList.indexOf(str[2]), str[1])));
        } else {
            throw new Exception("Incorrect input format");
        }
    }

    public static int calc(int num1, int num2, String oper) throws Exception {
        if ((0 >= num1 || num1 > 10) || (0 >= num2 || num2 > 10)) throw new Exception("input range of (1, 10) or (I, X)");
        return switch (oper) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "/" -> num1 / num2;
            case "*" -> num1 * num2;
            default -> throw new Exception("Operation not found");
        };
    }
}
