package model;

import java.time.LocalDate;
import java.io.Serializable;

public class Date implements Serializable
{
  private int day;
  private int month;
  private int year;

  public Date() {
    this.day = today().getDay();
    this.month = today().getMonth();
    this.year = today().getYear();
  }
  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public static Date today() {
    LocalDate currentDate = LocalDate.now();
    int currentDay = currentDate.getDayOfMonth();
    int currentMonth = currentDate.getMonthValue();
    int currentYear = currentDate.getYear();
    Date today = new Date(currentDay, currentMonth, currentYear);
    return today;
  }

  public int getDay()
  {
    return this.day;
  }
  public int getMonth()
  {
    return this.month;
  }
  public int getYear()
  {
    return this.year;
  }
  public void setDay(int d)
  {
    this.day = d;
  }
  public void setMonth(int m)
  {
    this.month = m;
  }
  public void setYear(int y)
  {
    this.year = y;
  }

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
  public int dayMonth() {
    return switch (this.month)
    {
      case 1, 3, 5, 7, 8, 10, 12 -> 31;
      case 4, 6, 9, 11 -> 30;
      case 2 -> this.isLeapYear() ? 29 : 28;
      default -> 0;
    };
  }

  public Date copy()
  {
    return new Date(day, month, year);
  }
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
  public String toString() {
    return this.year + "." + this.month + "." + this.day;
  }
}

