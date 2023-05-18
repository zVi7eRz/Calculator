import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String calc = scan.nextLine();
        scan.close();

        String [] strings = calc.split(" "); // scan = "2 + 4" : string = ["2","+","4"]

        if (strings.length != 3) {
            throw new Exception(); // выдаст ошибку, если количество символов больше 3
        }
        String sign = strings[1], result = "";
        String[] romanNum = {
            "N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII",
            "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV",
            "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV",
            "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI",
            "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII",
            "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C" };
        String[] numbers = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        if (lineSearch( romanNum, strings[0]) != -1 & lineSearch( romanNum, strings[2]) != -1) { // проверяем являются ли цифры римскими
            int num1 = lineSearch( romanNum, strings[0]), num2 = lineSearch( romanNum, strings[2]);
            if (num1 > 10 | num2 > 10){throw new Exception();} // Исключение больших рим. чисел
            int i = switchSign(num1, num2, sign) ;
            if (i < -1) {throw new Exception();}
            result = romanNum[i];
        }
        else if(lineSearch( numbers, strings[0]) != -1 & lineSearch( numbers, strings[2]) != -1) {
            int num1 = Integer.parseInt(strings[0]), num2 = Integer.parseInt(strings[2]);
            result = Integer.toString( switchSign(num1, num2, sign) );
        } else { throw new Exception();}
        System.out.println(result);
    }
    public static int lineSearch(String arr[], String elementToSearch) { // проверка нахождения элемента в списке, возвращает index элемента в списке или -1 если его нет.
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i].equals(elementToSearch))
                return i;}
        return -1;}
    public static int switchSign(int num1, int num2, String sign) {
        switch (sign){
            case "+": return (num1 + num2); 
            case "-": return (num1 - num2);        
            case "*": return (num1 * num2);
            case "/": if (num2 == 0) { return -999;} return num1 / num2;      
            default: return -999; } }
}