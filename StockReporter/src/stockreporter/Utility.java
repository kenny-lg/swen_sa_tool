package stockreporter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Herve Tchoufong
 */
public class Utility {
    public static BigDecimal convertStringCurrency(String stringCurrency){
        double doubleCurrency = 0;
        if (Character.isLetter(stringCurrency.charAt(stringCurrency.length()-1))){
            char letter = stringCurrency.charAt(stringCurrency.length()-1);
            double thousands = getThousands(letter);
            stringCurrency = stringCurrency.substring(0, stringCurrency.length()-1);
            doubleCurrency  = getDoubleCurrency(stringCurrency);
            doubleCurrency*= thousands;
        }else{
            doubleCurrency  = getDoubleCurrency(stringCurrency);
        }
        return BigDecimal.valueOf(doubleCurrency);
    }
    
    public static double getThousands(char letter){
        if (letter == 'M')
            return 1000000;
        else if (letter == 'B')
            return 1000000000;
        return 1;
    }
    
    public static double getDoubleCurrency(String stringCurrency){
        try {
            return NumberFormat.getNumberInstance(java.util.Locale.US).parse(stringCurrency).doubleValue();
        } catch (ParseException ex) {
            Logger.getLogger(StockReporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
    
    public static String[] getRangeMinAndMax(String range){
        return range.split("-");
    }
    public static String[] getNumeratorAndDenominator(String fraction){
        return fraction.trim().equals("-")?new String[]{"0","0"}:fraction.split("/");
    }
    
    public static String computeStringValues(String str){
        String[] operands = str.split("x");
        double operand1 = convertStringCurrency(operands[0]).doubleValue(); 
        double operand2 = Double.parseDouble(operands[1]); 
        double result = operand1 * operand2;
        return String.valueOf(result);
    }
    
    public static String getNumberBeforeParantheses(String str){
        return str.trim().equals("-")?"0":(str.split("\\(")[0]).trim();
    }
    
    public static String formatDateString(String dateString){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(dateString);
            dateString = format.format(date);
        } catch (ParseException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dateString;
    }
    
    public static boolean isBlank(String str){
        return str.equals("-") || str.equals("N/A");
    }
}
