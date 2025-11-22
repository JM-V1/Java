
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Calendar {
    //private variables
private Calendar calender;
private int years;
private int months;

//creating instantces
    LocalDate localDate =  LocalDate.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    YearMonth yearMonth = YearMonth.now();
    int daysInMonth = yearMonth.lengthOfMonth();

//no arg constructor
public Calendar(){
    years = 0;
    months = 0;
    this.calender = this;
}

//getter methods, Calander, years, months
public Calendar getCalendar(){
return calender;
}

public int getYears(){
    return years;
}

public int getMonth(int monthInput, int yearInput){
 
        System.out.println("\nCurrent date: " + localDate.format(dateFormatter));//displays current date

    //switch statement to convert number of month to month name i.e january = 1
    switch (monthInput) {
        case 1 :     System.out.println("Calendar for January " + yearInput + "\n"
             + "Sun Mon Tue Wed Thu Fri Sat"); 
            
         break;

        case 2 :     System.out.println("Calendar for Febuary " + yearInput + "\n"
            + "Sun Mon Tue Wed Thu Fri Sat"); 
            
         break;

        case 3 :     System.out.println("Calendar for March " + yearInput + "\n"
            + "Sun Mon Tue Wed Thu Fri Sat"); 
            
         break;

        case 4 :     System.out.println("Calendar for April " + yearInput + "\n"
            + "Sun Mon Tue Wed Thu Fri Sat"); 
            
         break;    

        case 5 :     System.out.println("Calendar for May " + yearInput + "\n"
            + "Sun Mon Tue Wed Thu Fri Sat"); 
            
         break;     
        case 6 :     System.out.println("Calendar for June " + yearInput + "\n"
            + "Sun Mon Tue Wed Thu Fri Sat"); 
            
         break;
         
        case 7 :     System.out.println("Calendar for July " + yearInput + "\n"
            + "Sun Mon Tue Wed Thu Fri Sat"); 
            
         break;

        case 8 :     System.out.println("Calendar for August " + yearInput + "\n"
            + "Sun Mon Tue Wed Thu Fri Sat"); 
            
         break;

        case 9 :     System.out.println("Calendar for September " + yearInput + "\n"
            + "Sun Mon Tue Wed Thu Fri Sat"); 
            
         break;

        case 10 :     System.out.println("Calendar for October " + yearInput + "\n"
            + "Sun Mon Tue Wed Thu Fri Sat"); 
            
         break;

        case 11 :     System.out.println("Calendar for November " + yearInput + "\n"
            + "Sun Mon Tue Wed Thu Fri Sat"); 
            
         break;

        case 12 :     System.out.println("Calendar for December " + yearInput + "\n"
            + "Sun Mon Tue Wed Thu Fri Sat"); 
            
         break;
        default:
        System.out.println("not a valid number");
        
    }
    
    return months;
}

//setter methods Calender, years, months
public void setCalendar(Calendar calender1){
    this.calender = calender1;
}

public void setYears(int year){
    this.years = year;
}

public void setMonth(int month1){
    this.months = month1;
}

//method to check for for 31 or 30 days or 28/29 days
public void checkDaysInMonth(int month, int year){
    
    LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
    int firstDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue() % 7; 

    // determine number of days in month
    boolean isLeap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    int daysInRequestedMonth;

    if (month == 2) daysInRequestedMonth = isLeap ? 29 : 28;
    else if (month == 4 || month == 6 || month == 9 || month == 11) daysInRequestedMonth = 30;
    else daysInRequestedMonth = 31;

    // print initial spaces
    for (int i = 0; i < firstDayOfWeek; i++) {
        System.out.print("    ");
    }

    // Print all days of the month
    for (int day = 1; day <= daysInRequestedMonth; day++) {
        System.out.printf("%3d ", day);
        // break line after Saturday
        if ((day + firstDayOfWeek) % 7 == 0) {
            System.out.println();
        }
    }
    System.out.println();
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Calendar calendar = new Calendar();

    System.out.print("Enter Month (1-12): ");
    int month = scanner.nextInt();

    System.out.print("\nEnter year: ");
    int year = scanner.nextInt();
    
    calendar.getMonth(month, year);
    calendar.checkDaysInMonth(month, year);

    scanner.close();
}

}

