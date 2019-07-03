package enums;

public enum WeekDays {
    MON("Monday", 1){
        @Override
        public void sayPhrase() {
            System.out.println("I'm a Monday");
        }
    },
    TUE("Tuesday", 2){

    },
    WED("Wednesday", 3){

    },
    THU("Thursday", 4){

    },
    FRI("Friday", 5){

    },
    SAT("Saturday", 6){

    },
    SUN("Sunday", 7){

    };

    private String dayName;
    private int dayNumber;

    WeekDays(final String dayName, final int dayNumber) {
        this.dayName = dayName;
        this.dayNumber = dayNumber;
    }

    public void sayPhrase() {
        System.out.println("Hello");
    }

}
