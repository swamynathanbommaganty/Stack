import java.util.Scanner;


public class postfixev {


    Mapdas no = new Mapdas(true);
    void validateString(String s) {
        tack operhand = new tack(s.length());
        tack operator = new tack(s.length());
        for (int i = 0; i < s.length(); i++) {

            char hy = s.charAt(i);
            if (Character.isDigit(hy)) {
                operhand.push(hy);

            } else if ((no.containsKey(hy)) && (operator.isEmpty())) {

                 operator.push(hy);


            }

            else if(hy == ')'){
                int a = 0;
                while (a < operator.size()){

                    if(operator.arr[operator.top] == '(')
                    {

                        break;

                    }
                    else {


                        Integer result =   result(Character.getNumericValue(operhand.pop()),
                                Character.getNumericValue(operhand.pop())
                                ,operator.pop());


Character someChar = (char)Integer.parseInt(String.valueOf(result));

                        operhand.push(someChar);
                    }
                    a++;
                }}







            else if(((no.containsKey(hy))
                   && (!operator.isEmpty()) &&
                  (no.priorityno(hy) >
                 (no.priorityno(operator.arr[operator.top])))
                   ) || (hy == '('))
            {
                operator.push(hy);
            }

        else {
                operator.push(hy);

        }

        }

        System.out.println("result is"+operhand.pop());

    }





    int result(int num1, int num2, char oper){
        int sid = switch (oper) {
            case '+' ->  (num2 + num1);
            case '-' ->  (num2 - num1);
            case '*' ->  (num2 * num1);
            case '/' ->  (num2 / num1);
            default -> '0';
        };

        return  sid;

    }

    public static void main(String [] args)

    {
        postfixev yes = new postfixev();


        Scanner ds = new Scanner(System.in);
        System.out.println("enter the string ");
        String sc = ds.next();
        yes.validateString(sc);





    }

}
