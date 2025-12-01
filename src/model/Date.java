package model;

import java.time.LocalDate;

public class Date {
  private int day;
  private int month;
  private int year;
  private int period;           //days
  private Date temp;

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

  public Date(Date obj) {
    this.day = obj.day;
    this.month = obj.month;
    this.year = obj.year;
  }

  public static Date today() {
    LocalDate currentDate = LocalDate.now();
    int currentDay = currentDate.getDayOfMonth();
    int currentMonth = currentDate.getMonthValue();
    int currentYear = currentDate.getYear();
    Date today = new Date(currentDay, currentMonth, currentYear);
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
    return new Date(this.day, this.month, this.year);
  }

  public boolean equals(Object obj) {
    if (obj != null && this.getClass() == obj.getClass()) {
      Date other = (Date)obj;
      return this.day == other.day && this.month == other.month && this.year == other.year;
    } else {
      return false;
    }
  }

  public boolean isBefore(Date date2) {
    if (this.year < date2.year) {
      return true;
    } else if (this.year > date2.year) {
      return false;
    } else if (this.month < date2.month) {
      return true;
    } else if (this.month > date2.month) {
      return false;
    } else {
      return this.day < date2.day;
    }
  }

//  public void nextDay() {
//    if (this.month == 12) {
//      if (this.day < this.dayMonth()) {
//        ++this.day;
//      } else {
//        this.day = 1;
//        this.month = 1;
//        ++this.year;
//      }
//    } else if (this.day < this.dayMonth()) {
//      ++this.day;
//    } else {
//      this.day = 1;
//      ++this.month;
//    }
//  }

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

//  public void nextDayEasy(int increment) {
//    for(int i = 0; i < increment; ++i) {
//      this.nextDay();
//    }
//  }

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

  public String dayofweek() {
    int m;
    int y;
    if (this.month == 1) {
      m = 13;
      y = this.year - 1;
    } else if (this.month == 2) {
      m = 14;
      y = this.year - 1;
    } else {
      m = this.month;
      y = this.year;
    }

    int q = this.day;
    int k = y % 100;
    int j = y / 100;
    int result = (q + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;
    switch (result) {
      case 0 -> {
        return "Saturday";
      }
      case 1 -> {
        return "Sunday";
      }
      case 2 -> {
        return "Monday";
      }
      case 3 -> {
        return "Tuesday";
      }
      case 4 -> {
        return "Wednesday";
      }
      case 5 -> {
        return "Thursday";
      }
      case 6 -> {
        return "Friday";
      }
      default -> {
        return "get out";
      }
    }
  }

  public int dayMonth() {
    if (!this.isLeapYear()) {
      switch (this.month) {
        case 1 -> {
          return 31;
        }
        case 2 -> {
          return 28;
        }
        case 3 -> {
          return 31;
        }
        case 4 -> {
          return 30;
        }
        case 5 -> {
          return 31;
        }
        case 6 -> {
          return 30;
        }
        case 7 -> {
          return 31;
        }
        case 8 -> {
          return 31;
        }
        case 9 -> {
          return 30;
        }
        case 10 -> {
          return 31;
        }
        case 11 -> {
          return 30;
        }
        case 12 -> {
          return 31;
        }
        default -> {
          return 0;
        }
      }
    } else {
      switch (this.month) {
        case 1 -> {
          return 31;
        }
        case 2 -> {
          return 29;
        }
        case 3 -> {
          return 31;
        }
        case 4 -> {
          return 30;
        }
        case 5 -> {
          return 31;
        }
        case 6 -> {
          return 30;
        }
        case 7 -> {
          return 31;
        }
        case 8 -> {
          return 31;
        }
        case 9 -> {
          return 30;
        }
        case 10 -> {
          return 31;
        }
        case 11 -> {
          return 30;
        }
        case 12 -> {
          return 31;
        }
        default -> {
          return 0;
        }
      }
    }
  }

  public String getMonthName() {
    switch (this.month) {
      case 1 -> {
        return "January";
      }
      case 2 -> {
        return "February";
      }
      case 3 -> {
        return "March";
      }
      case 4 -> {
        return "April";
      }
      case 5 -> {
        return "May";
      }
      case 6 -> {
        return "June";
      }
      case 7 -> {
        return "July";
      }
      case 8 -> {
        return "August";
      }
      case 9 -> {
        return "September";
      }
      case 10 -> {
        return "October";
      }
      case 11 -> {
        return "November";
      }
      case 12 -> {
        return "December";
      }
      default -> {
        return "Invalid month";
      }
    }
  }

  public String toString() {
    return this.day + "/" + this.month + "/" + this.year;
  }
}

