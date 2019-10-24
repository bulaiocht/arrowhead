package enums;

public class EnumExample {

    public static void main(String[] args) {
        Months apr = Months.APR;
//        final int numberOfDays = apr.getNumberOfDays();
//        System.out.println("April num of days: " + numberOfDays);
//        final String monthName = apr.getMonthName();
//        System.out.println(monthName);
//        final int monthNum = apr.getMonthNum();
//        System.out.println(monthNum);
//        System.out.println(apr.name());

        Months[] values = Months.values();
        for (final Months value : values) {
            System.out.println(value);
        }

        final int i = apr.compareTo(Months.AUG);
        System.out.println(i);

        System.out.println(apr.ordinal());

        Months month = Months.valueOf("APR");
        Months december = Months.parse("December");
        System.out.println(month);

        System.out.println(december);

        season(Months.DEC);

    }

    private static void season(Months month) {

        switch (month) {
            case MAR:
            case APR:
            case MAY:
                System.out.println("It's spring!");
                break;
            default:
                System.out.println("Not yet implemented!");
                break;
        }
    }
}
