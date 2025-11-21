import java.util.Scanner;

public class leap_year {
    public static void main(String[] args){
double year;

Scanner scanner = new Scanner(System.in);

System.out.print("put a year to check if it was a leapyear: ");
 year = scanner.nextInt();

System.out.println(LeapYear(year));
 

 

}
    public static boolean LeapYear(double year){
        
        
        if(year % 100 == 0){
            if (year % 400 == 0) {
            return true;
        }
        }
        else if(year % 4 == 0){
            return true;
        }
        return false;
    }

}
