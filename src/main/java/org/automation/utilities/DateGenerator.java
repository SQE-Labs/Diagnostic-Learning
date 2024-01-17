

package org.automation.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateGenerator {

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        return date1;
    }
    public static  String dateTimeGenerator(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        String date1 = dateFormat.format(date);
        System.out.println("generated Date is ======   " + date1);
        return date1;
    }

    public static  String getCurrentDateFromSystem()
    {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        String formattedDate = currentDate.format(formatter);
        System.out.println("generated Date is ======   " + formattedDate);
        return formattedDate;
    }
    public static String getDateWithDays(String format, int dayToAdd) {

        LocalDate todayDate = LocalDate.now();
        LocalDate date = LocalDate.parse(todayDate.toString());
        LocalDate date2 = date.plusDays(dayToAdd);
        System.out.println("Date generated  " + date2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return formatter.format(date2);
    }
    public static boolean isDateWithinRange(LocalDate startDate, LocalDate endDate, LocalDate dateToCheck) {
        return (dateToCheck.isAfter(startDate) || dateToCheck.isBefore(endDate));
    }
   public static String  getMonthAndYear(){
       LocalDate currentDate = LocalDate.now();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
       return currentDate.format(formatter);

   }
    public static String getCurrentMonthFormat() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM");
        return currentDate.format(formatter);
    }


}