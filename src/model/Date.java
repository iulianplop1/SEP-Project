package model;

import java.time.LocalDate;

public class Date {
  private int day;
  private int month;
  private int year;

  private int period;           //days
  private Date temp;

  private Village cloverville;

  public Date(Village village) {
    this.cloverville = village;
    this.day = today(village).getDay();
    this.month = today(village).getMonth();
    this.year = today(village).getYear();
  }
  public Date(Village village, int day, int month, int year) {
    this.cloverville = village;
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public void setPeriod(int period)
  {
    this.period = period;
  }

  public void checkDate(int day, int month, int year) {
    temp = new Date(cloverville, day, month, year);
    Date reset = temp.copy();
    reset.nextDay(period);

    if (today(cloverville).equals(reset)) {
      System.out.println("TODAY IS THE DAY OF THE RESET");
      cloverville.Reset();
    }
    else{
      System.out.println("RESET WILL HAPPEN ON: " + reset);
    }
    //idea: create an arraylist with the next x reset dates which would change everytime a new reset value is added --> nice for visibility
  }

  public static Date today(Village village) {
    LocalDate currentDate = LocalDate.now();
    int currentDay = currentDate.getDayOfMonth();
    int currentMonth = currentDate.getMonthValue();
    int currentYear = currentDate.getYear();
    Date today = new Date(village, currentDay, currentMonth, currentYear);
    return today;
  }

  public int getDay() {
    return this.day;
  }
  public int getMonth() {
    return this.month;
  }
  public int getYear() {
    return this.year;
  }
  public void setDay(int d) {
    this.day = d;
  }
  public void setMonth(int m) {
    this.month = m;
  }
  public void setYear(int y) {
    this.year = y;
  }

  public Date copy() {
    return new Date(cloverville, day, month, year);
  }
  public boolean equals(Object obj) {
    if (obj != null && this.getClass() == obj.getClass()) {
      Date other = (Date)obj;
      return this.day == other.day && this.month == other.month && this.year == other.year;
    } else {
      return false;
    }
  }

  public void nextDay(int increment) {
    this.day += increment;
    while(this.day > this.dayMonth()) {
      this.day -= this.dayMonth();
      if (this.month > 11) {
        this.month -= 11;
        ++this.year;
      } else {
        ++this.month;
      }
    }
  }

  public boolean isLeapYear() {
    if (this.year % 4 == 0) {
      if (this.year % 100 == 0) {
        return this.year % 400 == 0;
      } else {
        return true;
      }
    } else {
      return false;
    }
  }
  public int dayMonth() {
    return switch (this.month) {
      case 1, 3, 5, 7, 8, 10, 12 -> 31;
      case 4, 6, 9, 11 -> 30;
      case 2 -> this.isLeapYear() ? 29 : 28;
      default -> 0;
    };
  }

  public String toString() {
    return this.day + "/" + this.month + "/" + this.year;
  }
}

