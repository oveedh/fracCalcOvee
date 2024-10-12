import java.util.*;
public class FracCalc
{

    public static void main(String[] args) 
    {
        Scanner answer = new Scanner(System.in);
        System.out.print("Enter your equation (q to quit): ");
        String input = answer.nextLine();
        while (!input.equals("quit")){
            System.out.print(produceAnswer(input));
            input = answer.nextLine();
        }
    }
    /**
     * This method takes the user's input and determines whether they are integers, mixed fractions, fractions, or invalid
     *     then moving to the next method accordingly
     * @param equation
     * @return
     */
public static String produceAnswer(String input){
    if(input.length() < 5){
        System.out.println("Invalid Expression\n");
    }
    else if(input.indexOf("/") == input.lastIndexOf("/"))
        {
            System.out.println(input);
            return toMixNumber(input); 
        }
    else if(input.indexOf(" ") < 1){
        System.out.println("Invalid Expression");
    }
    else if(!input.contains("/") && !input.contains("_"))
    {
        String lNum = input.substring(0, input.indexOf(" ")); 
        String operator = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2); 
        String rNum = input.substring(input.indexOf(" ") + 3, input.length()); 
        int operand1 = Integer.parseInt(lNum); 
        int operand2 = Integer.parseInt(rNum); 
        //2System.out.println("Ok, now calling calcInt");
        return calcInt(operand1, operand2, operator); 
        //System.out.print("Please enter your equation (quit to quit): ");
        //return null;    
    }
    else if(input.contains("_"))
    { 
        String operator = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2);
        return toFracNumber(input);
        //System.out.print("Please enter your equation (quit to quit): ");
        //return null;
    }
    else if(!input.contains("_") && input.contains("/") ) 
    {
        //System.out.println("Ok, now calling toFracNumber");

        return toFracNumber(input);
        //System.out.print("Please enter your equation (quit to quit): ");
    }
    return null;
}
            
public static String calcInt(int operand1, int operand2, String operator){ 
    if (operator.equals("+")){ 
        //System.out.println("Reached calcInt");
        //System.out.println("" + (operand1 + operand2));
        return Integer.toString(operand1 + operand2);
    }
    else if(operator.equals("-")){
        return Integer.toString(operand1 - operand2);
    }
    else if(operator.equals("/")){
        if (operand2 == 0){
            return ("Undefined");
        }
        else{
        return Integer.toString(operand1 / operand2);
        }
    }
    else if(operator.equals("*")){
        return Integer.toString(operand1 * operand2);
    } 
    else if(operator.equals("^")){
        return Double.toString(Math.pow(operand1, operand2));
    }
    else if (operator.equals("%")){
        return Integer.toString(operand1 % operand2);
    } 
    else {
        //return "Invalid Expression";
    }
    } 

/**
 * This method takes mixed numbers and turns them into improper fractions
 *  then moving down to the produceAnswer method
 * @param equation
 * @return
 */
    public static String toFracNumber(String input)
    {
        String frac1 = input.substring(0, input.indexOf(" "));
        String frac2 = input.substring(input.indexOf(" ") + 3, input.length());
        String operator = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2);
        String fracNum1 = "";
        String fracNum2 = "";
        String equation2 = "";
        String resultFrac = "";
        int impNum1 = 0;
        int impNum2 = 0;
        System.out.println("frac1 " + frac1 + " frac2 " + frac2);

        if(frac1.contains("_") && frac2.contains("_"))
        {
            
            String mixed1 = frac1.substring(0, frac1.indexOf("_"));
            String num1 = frac1.substring(frac1.indexOf("_") + 1, frac1.indexOf("/"));
            String den1 = frac1.substring(frac1.indexOf("/") + 1, frac1.length());
            String mixed2 = frac2.substring(0, frac2.indexOf("_"));
            String num2 = frac2.substring(frac2.indexOf("_") + 1, frac2.indexOf("/"));
            String den2 = frac2.substring(frac2.indexOf("/") + 1, frac2.length());
            int mixedNumber1 = Integer.parseInt(mixed1); 
            System.out.println("mixed num1" + mixedNumber1);
            int numerator1 = Integer.parseInt(num1); 
            int denominator1 = Integer.parseInt(den1); 
            System.out.println("numerator1 " + numerator1 + "denominator1 " + denominator1);
            if (mixedNumber1 >= 0) {
               impNum1 = (mixedNumber1 * denominator1) + numerator1; 
               
            } else 
            {
                impNum1 = (mixedNumber1 * denominator1) - numerator1; 
            }
            System.out.println("impNum1" + impNum1);

            
            int mixedNumber2 = Integer.parseInt(mixed2); 
            System.out.println("mixed num2" + mixedNumber2);
            
            int numerator2 = Integer.parseInt(num2); 
            int denominator2 = Integer.parseInt(den2); 
            System.out.println("numerator2 " + numerator2 + "denominator2 " + denominator2);

            
            if (mixedNumber2 >= 0) {
               impNum2 = (mixedNumber2 * denominator2) + numerator2; 
            } else 
            {
                impNum2 = (mixedNumber2 * denominator2) - numerator2; 
            }
            System.out.println("impNum2" + impNum2);

            
            fracNum1 = impNum1 + "/" + denominator1;
            fracNum2 = impNum2 + "/" + denominator2;
            equation2 = fracNum1 + " " + operator + " " + fracNum2;
            System.out.println("equation 2" + equation2);
            return calculateFrac(operator, equation2);
            }
        else if(frac1.contains("_") && !frac2.contains("_"))
        {
            String mixed1 = frac1.substring(0, frac1.indexOf("_"));
            String num1 = frac1.substring(frac1.indexOf("_") + 1, frac1.indexOf("/"));
            String den1 = frac1.substring(frac1.indexOf("/") + 1, frac1.length());
            int mixedNumber1 = Integer.parseInt(mixed1); 
            int numerator1 = Integer.parseInt(num1); 
            int denominator1 = Integer.parseInt(den1); 
            impNum1 = (mixedNumber1 * denominator1) + numerator1;
          
            fracNum1 = impNum1+ "/" + denominator1;
            equation2 = fracNum1 + " " + operator + " " + frac2;
            return calculateFrac(operator, equation2);

            }
        else if(!frac1.contains("_") && frac2.contains("_")){
            String mixed2 = frac2.substring(0, frac2.indexOf("_"));
            String num2 = frac2.substring(frac2.indexOf("_") + 1, frac2.indexOf("/"));
            String den2 = frac2.substring(frac2.indexOf("/") + 1, frac2.length());
            int mixedNumber2 = Integer.parseInt(mixed2); 
            int numerator2 = Integer.parseInt(num2); 
            int denominator2 = Integer.parseInt(den2); 
            impNum2 = (mixedNumber2 * denominator2) + numerator2;
            
            fracNum2 = impNum2+ "/" + denominator2;
            equation2 = frac1 + " " + operator + " " + fracNum2;
            return (calculateFrac(operator, equation2));
        }
        else{
            equation2 = frac1 + " " + operator + " " + frac2;
            return calculateFrac(operator, equation2);
        }
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //         e.g. input ==> "1/2 + 3/4"
    //          
    // The function should return the result of the fraction after it has been calculated
    //         e.g. return ==> "1_1/4"
    //
    
    /**
     * This method takes and calculates the improper/regular fractions
     *     then moving to the simpFrac method
     * @param operator
     * @param equation2
     * @return
     */
    public static String calculateFrac(String operator, String equation2)
    { 
        String frac1 = equation2.substring(0, equation2.indexOf(" "));
        String frac2 = equation2.substring(equation2.indexOf(" ") + 3, equation2.length());
        if(frac1.contains("/") && frac2.contains("/"))
        {
            String num1 = frac1.substring(0,frac1.indexOf("/"));
            String den1 = frac1.substring(frac1.indexOf("/") + 1, frac1.length());
            String num2 = frac2.substring(0,frac2.indexOf("/"));
            String den2 = frac2.substring(frac2.indexOf("/") + 1, frac2.length());
            int numerator1 = Integer.parseInt(num1); 
            int denominator1 = Integer.parseInt(den1); 
            int numerator2 = Integer.parseInt(num2); 
            int denominator2 = Integer.parseInt(den2); 
            if(operator.equals("+"))
                { 
                    int numerator3 = (numerator1 * denominator2) + (numerator2 * denominator1);
                    int denominator3 = (denominator1 * denominator2);
                    String frac3 =(numerator3 + "/" + denominator3);
                    return simpFrac(frac3, operator);
                }
                else if(operator.equals("-")){
                    int numerator3 = (numerator1 * denominator2) - (numerator2 * denominator1);
                    int denominator3 = (denominator1 * denominator2);
                    String frac3 = (numerator3 + "/" + denominator3);
                    return simpFrac(frac3, operator);
                }
                else if(operator.equals("*")){
                    int numerator3 = (numerator1 * numerator2);
                    int denominator3 = (denominator1 * denominator2);
                    String frac3 = (numerator3 + "/" + denominator3);
                    return simpFrac(frac3, operator);
                }
                else if (operator.equals("/")){
                    if(denominator1==-1)
                    {
                        return Integer.toString((-1)*(numerator1));
                    }
                    int numerator3 = (numerator1 * denominator2);
                    int denominator3 = (denominator1 * numerator2);
                    String frac3 = (numerator3 + "/" + denominator3);
                    return simpFrac(frac3, operator);
                    
                }
        }
        if(!frac1.contains("/") && frac2.contains("/")) {
            String num1 = frac1.substring(0,frac1.length());
            String num2 = frac2.substring(0,frac2.indexOf("/"));
            String den2 = frac2.substring(frac2.indexOf("/") + 1, frac2.length());
            int numerator1 = Integer.parseInt(num1); 
            int numerator2 = Integer.parseInt(num2); 
            int denominator2 = Integer.parseInt(den2);
            int denominator1 = 1; 
            if(operator.equals("+"))
                { 
                    int numerator3 = (numerator1 * denominator2) + (numerator2 * denominator1);
                    int denominator3 = (denominator1 * denominator2);
                    String frac3 =(numerator3 + "/" + denominator3);
                    return simpFrac(frac3, operator);
                }
                else if(operator.equals("-")){
                    int numerator3 = (numerator1 * denominator2) - (numerator2 * denominator1);
                    int denominator3 = (denominator1 * denominator2);
                    String frac3 = (numerator3 + "/" + denominator3);
                    return simpFrac(frac3, operator);
                }
                else if(operator.equals("*")){
                    int numerator3 = (numerator1 * numerator2);
                    int denominator3 = (denominator1 * denominator2);
                    String frac3 = (numerator3 + "/" + denominator3);
                    return simpFrac(frac3, operator);
                }
                else if (operator.equals("/")){
                    int numerator3 = (numerator1 * denominator2);
                    int denominator3 = (denominator1 * numerator2);
                    String frac3 = (numerator3 + "/" + denominator3);
                    return simpFrac(frac3, operator);
                }
        }
        if(frac1.contains("/") && !frac2.contains("/"))
        {
            String num1 = frac1.substring(0,frac1.indexOf("/"));
            String den1 = frac1.substring(frac1.indexOf("/") + 1, frac1.length());
            String num2 = frac2.substring(0, frac2.length());
            int numerator1 = Integer.parseInt(num1); 
            int denominator1 = Integer.parseInt(den1); 
            int numerator2 = Integer.parseInt(num2); 
            int denominator2 = 1; 
            if(operator.equals("+"))
                { 
                    int numerator3 = (numerator1 * denominator2) + (numerator2 * denominator1);
                    int denominator3 = (denominator1 * denominator2);
                    String frac3 =(numerator3 + "/" + denominator3);
                    return simpFrac(frac3, operator);
                }
                else if(operator.equals("-")){
                    int numerator3 = (numerator1 * denominator2) - (numerator2 * denominator1);
                    int denominator3 = (denominator1 * denominator2);
                    String frac3 = (numerator3 + "/" + denominator3);
                    return simpFrac(frac3, operator);
                }
                else if(operator.equals("*")){
                    int numerator3 = (numerator1 * numerator2);
                    int denominator3 = (denominator1 * denominator2);
                    String frac3 = (numerator3 + "/" + denominator3);
                    return simpFrac(frac3, operator);
                }
                else if (operator.equals("/"))
                {
                    int numerator3 = (numerator1 * denominator2);
                    int denominator3 = (denominator1 * numerator2);
                    String frac3 = (numerator3 + "/" + denominator3);
                    //check if denom is 0
                    return simpFrac(frac3, operator);
                }
        }
        if(!frac1.contains("/") && !frac2.contains("/")){
            int operand1 = Integer.parseInt(frac1);
            int operand2 = Integer.parseInt(frac2);
            return calcInt(operand1, operand2, operator);
        }
    }
    
    
    /**
     * This method takes the simplified calculated fraction and turns it into a mixed number if needed
     *     then printing out the resultant
     * @param frac4
     * @param operator
     * @return
     */
    public static String toMixNumber(String frac4){
        String num4 = "";
        String den4 = "";
        num4 = frac4.substring(0, frac4.indexOf(" /"));
        den4 = frac4.substring(frac4.indexOf("/") + 1, frac4.length());
        int numerator4 = Integer.parseInt(num4); 
        int denominator4 = Integer.parseInt(den4); 
        int numerator5 = numerator4 % denominator4;
        int denominator5 = denominator4;
        int mixed2 = (numerator4 - numerator5) / denominator4;
        numerator5 = Math.abs(numerator5);
        denominator5 = Math.abs(denominator5);
        if((frac4.indexOf("/") == frac4.lastIndexOf("/")) && numerator4 >= 0)
        {
            int num7 = numerator4/denominator4;
            int num8 = numerator4 - (denominator4*num7);
            return Integer.toString(num7) + "_" + Integer.toString(num8) + "/" + den4;
        }
        else if((frac4.indexOf("/") == frac4.lastIndexOf("/")))
        {
            int num7 = numerator4/denominator4;
            int num8 = numerator4 + (denominator4*num7);
            // what does num7 and 8 do?
            return Integer.toString(num7) + "_" + Integer.toString(num8) + "/" + den4;
        }
        if(mixed2 == 0){
            return Integer.toString(numerator5) + "/" + Integer.toString(denominator5);
        }
        else if(numerator5 == 0){
            return Integer.toString(mixed2);
        }
        else{
        String result = mixed2 + "_" + numerator5 + "/" + denominator5;
        //System.out.println(mixed2 + "_" + numerator5 + "/" + denominator5);
        return result;
        }
    }
    
    /**
     * This method takes the calculated fraction and simplifies it 
     *     then moving to the toMixNumber method
     * @param frac3
     * @param operator
     * @return
     */
    public static String simpFrac(String frac3, String operator){
        String num3 = frac3.substring(0, frac3.indexOf("/"));
        System.out.println(frac3);
        String den3 = frac3.substring(frac3.indexOf("/") + 1, frac3.length());
        int numerator3 = Integer.parseInt(num3); 
        int denominator3 = Integer.parseInt(den3); 
        int temp1 = numerator3;
        int temp2 = denominator3; 
        boolean numeratorIsNegative = false;
        boolean denominatorIsNegative = false;
        System.out.println("frac3" + frac3);
        if(!(numerator3 == 0) && !(denominator3 == 0))
        {
            numerator3 = Math.abs(numerator3);
            denominator3 = Math.abs(denominator3);
            
            if (numerator3 == denominator3) 
            {
                //System.out.println("reached 1");
                return Integer.toString(1);
            }
            
            if (numerator3 < 0) {
                numeratorIsNegative = true;
                numerator3 = Math.abs(numerator3);
            }
            
            //if (denominator3 < 0)
            //{
            //    return (numerator3/denominator3)*-1;
            //}
            
            while (numerator3 != denominator3)
            {
                if(Math.abs(numerator3) > denominator3) 
                {    
                    numerator3 = numerator3 - denominator3;
                } else {
                    denominator3 = denominator3 - numerator3;
                }
            }
            int n3 = temp1 / numerator3 ;
            //print temp??
            if (numeratorIsNegative) {
                n3 = n3 * (-1);
            }
            int n4 = temp2 / numerator3 ;
            String frac4 = n3 + "/" + n4;
            System.out.println(frac4);
            return toMixNumber(frac4);
        }
        else if(numerator3 == 0 && denominator3 != 0){
            return Integer.toString(0);
        }
        else if(numerator3 !=0 && denominator3 == 0){
            return "undefined";
        }
        else if(numerator3 == 0 && denominator3 == 0){
            return Integer.toString(0);
        }
        return null;
    }
}
