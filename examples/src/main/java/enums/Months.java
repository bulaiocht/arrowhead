package enums;

import java.time.LocalDate;

public enum Months {

    JAN(1, "January"){
        @Override
        public int getNumberOfDays() {
            return 31;
        }
    },
    FEB(2, "February"){
        @Override
        public int getNumberOfDays() {
            if (LocalDate.now().isLeapYear()) {
                return 29;
            }
            return 28;
        }
    },
    MAR(3, "March"){
        @Override
        public int getNumberOfDays() {
            return 31;
        }
    },
    APR(4, "April"){
        @Override
        public int getNumberOfDays() {
            return 30;
        }

        @Override
        public String toString() {
            return this.getMonthName();
        }
    },
    MAY(5, "May"){
        @Override
        public int getNumberOfDays() {
            return 31;
        }
    },
    JUN(6, "June"){
        @Override
        public int getNumberOfDays() {
            return 30;
        }
    },
    JUL(7, "July"){
        @Override
        public int getNumberOfDays() {
            return 31;
        }
    },
    AUG(8, "August"){
        @Override
        public int getNumberOfDays() {
            return 30;
        }
    },
    SEP(9, "September"){
        @Override
        public int getNumberOfDays() {
            return 31;
        }
    },
    OCT(10, "October"){
        @Override
        public int getNumberOfDays() {
            return 30;
        }
    },
    NOV(11, "November"){
        @Override
        public int getNumberOfDays() {
            return 31;
        }
    },
    DEC(12, "December"){
        @Override
        public int getNumberOfDays() {
            return 30;
        }
    };

    private int monthNum;
    private String monthName;

    Months(int monthNum, String monthName) {
        this.monthNum = monthNum;
        this.monthName = monthName;
    }

    public int getMonthNum() {
        return monthNum;
    }

    public String getMonthName() {
        return monthName;
    }

    public int getNumberOfDays() {
        return 0;
    }

    public static Months parse(String monthName) {
        if (monthName == null || monthName.isEmpty())
            throw new IllegalArgumentException("Must not be empty");
        for (Months value : Months.values()) {
            if (value.getMonthName().equalsIgnoreCase(monthName)){
                return value;
            }
        }
        throw new IllegalArgumentException("No such element: " + monthName);
    }
}
