package model;

import java.time.LocalDate;
import java.io.Serializable;

/**
 * Date class for taking care of reset functionality and tracking the date
 * @author GaboraBrave
 */

public class Date implements Serializable
{
  private int day;
  private int month;
  private int year;

  /**
   * No argument constructor for Date class that just creates the date object of today using the static Date.today() method
   */
  public Date() {
    this.day = today().getDay();
    this.month = today().getMonth();
    this.year = today().getYear();
  }
  /**
   * 3 argument constructor for Date class that just creates the date object of the three given parameters
   * @param day integer of the day
   * @param month integer of the month
   * @param year integer of the year
   */
  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }
  /**
   * static Date.today() method which gets the date through the imported java.time.localDate
   * @return today is a Date object with the values of "today"'s date - the date of calling
   */
  public static Date today() {
    LocalDate currentDate = LocalDate.now();
    int currentDay = currentDate.getDayOfMonth();
    int currentMonth = currentDate.getMonthValue();
    int currentYear = currentDate.getYear();
    Date today = new Date(currentDay, currentMonth, currentYear);
    return today;
  }
  /**
   * @return this.day - the day field of the class
   */
  public int getDay()
  {
    return this.day;
  }
  /**
   * @return this.month - the month field of the class
   */
  public int getMonth()
  {
    return this.month;
  }
  /**
   * @return this.year - the year field of the class
   */
  public int getYear()
  {
    return this.year;
  }
  /**
   * @param d - day to set the day field to
   */
  public void setDay(int d)
  {
    this.day = d;
  }
  /**
   * @param m - day to set the month field to
   */
  public void setMonth(int m)
  {
    this.month = m;
  }
  /**
   * @param y - year to set the month field to
   */
  public void setYear(int y)
  {
    this.year = y;
  }

  /**
   * @param increment - (integer) by how much should it increment the Date object
   * takes into account dayMonth() to only increment to real date values
   */
  public void nextDay(int increment) {
    this.day += increment;
    while (this.day > this.dayMonth())
    {
      this.day -= this.dayMonth();
      if (this.month > 11)
      {
        this.month -= 11;
        ++this.year;
      }
      else
      {
        ++this.month;
      }
    }
  }

  /**
   * checks if the current year is leap or not
   */
  public boolean isLeapYear() {
    if (this.year % 4 == 0)
    {
      if (this.year % 100 == 0)
      {
        return this.year % 400 == 0;
      }
      else
      {
        return true;
      }
    }
    else
    {
      return false;
    }
  }

  /**
   * checks how many days the current month has
   */
  public int dayMonth() {
    return switch (this.month)
    {
      case 1, 3, 5, 7, 8, 10, 12 -> 31;
      case 4, 6, 9, 11 -> 30;
      case 2 -> this.isLeapYear() ? 29 : 28;
      default -> 0;
    };
  }

  /**
   * creates and returns an identical Date object
   * @return identical Date object
   */
  public Date copy()
  {
    return new Date(day, month, year);
  }

  /**
   * checks if two Date objects are the same or not
   * @return true or false
   */
  public boolean equals(Object obj) {
    if (obj != null && this.getClass() == obj.getClass())
    {
      Date other = (Date) obj;
      return this.day == other.day && this.month == other.month && this.year == other.year;
    }
    else
    {
      return false;
    }
  }

  /**
   * @return String value of the concatenated fields
   * return this.year + "." + this.month + "." + this.day
   */
  public String toString() {
    return this.year + "." + this.month + "." + this.day;
  }
}

