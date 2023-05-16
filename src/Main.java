
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        String calc = scan.nextLine();
        String [] strings = calc.split(" ");

        if (strings.length != 3) {
            scan.close();
            throw new Exception();
        }
        String sign = strings[1];
        String[] romanNum = {
            "N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII",
            "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV",
            "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV",
            "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI",
            "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII",
            "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        String[] numbers = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        };
        String result = "";

        if (lineSearch( romanNum, strings[0]) != -1 & lineSearch( romanNum, strings[2]) != -1) {
            int num1 = lineSearch( romanNum, strings[0]); 
            int num2 = lineSearch( romanNum, strings[2]);
            if (num1 > 10 | num2 > 10){
                scan.close();
                throw new Exception(); // Исключение больших рим. чисел
            }
            switch(sign){

                case "+":
                    result = romanNum[(num1 + num2)];
                    break;

                case "-":
                    if(num1 < num2){
                        scan.close();
                        throw new Exception(); // Исключение отрицательного ответа среди римских чисел
                    }
                    result = romanNum[(num1 - num2)];
                    break;

                case "*":
                    result = romanNum[(num1 * num2)];
                    break;

                case "/":
                    result = romanNum[(num1 / num2)];
                    break;

                default:
                    scan.close();
                    throw new Exception(); // Если нет нужного знака
            }
        }
        else if(lineSearch( numbers, strings[0]) != -1 & lineSearch( numbers, strings[2]) != -1) {
            int num1 = Integer.parseInt(strings[0]);
            int num2 = Integer.parseInt(strings[2]);
            switch(sign){

                case "+":
                    result = Integer.toString(num1 + num2);
                    break;

                case "-":
                    result = Integer.toString(num1 - num2);
                    break;

                case "*":
                    result = Integer.toString(num1 * num2);
                    break;
                    
                case "/":
                    if (num2 == 0) {
                        scan.close();
                        throw new Exception(); // на 0 делить нельзя
                    }
                    result = Integer.toString(num1 / num2);
                    break;
                default:
                    scan.close();
                    throw new Exception(); // Если нет нужного знака
            }
        } else {
            scan.close();
            throw new Exception();
        }


        System.out.println(result);
        scan.close();
}
    // проверка нахождения элемента в списке, возвращает index элемента в списке или -1 если его нет.
    public static int lineSearch(String arr[], String elementToSearch) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i].equals(elementToSearch))
                return i;
        }
        return -1;
    }
}