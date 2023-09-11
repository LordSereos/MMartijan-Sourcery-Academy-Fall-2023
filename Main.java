public class Main {
    public static void main(String[] args) {
        printBonusDatesBetween(2010, 2015);
    }

    public static void printBonusDatesBetween(int fromYear, int toYear){
        for (int i=fromYear; i<=toYear; i++){

            // Extracting possible month for the year which are the last two digits in reverse

            String firstDigitOfTheMonth = Integer.toString(i%10);
            String secondDigitOfTheMonth = Integer.toString(i%100/10);
            String possibleMonth = firstDigitOfTheMonth+secondDigitOfTheMonth;

            // Extracting possible day for the year which are the first two digits in revers

            String firstDigitOfTheDay = Integer.toString(i%1000/100);
            String secondDigitOfTheDay = Integer.toString(i/1000);
            String possibleDay = firstDigitOfTheDay+secondDigitOfTheDay;

            // Forming a possible BonusDate

            String possibleBonusDate = Integer.toString(i)+"-"+possibleMonth+"-"+possibleDay;

            // Checking if the formed BonusDate is a valid sane date
            if (DateIsValid(Integer.parseInt(possibleMonth), Integer.parseInt(possibleDay), i)) {

                Integer possibleDate = Integer.parseInt(secondDigitOfTheDay+firstDigitOfTheDay+secondDigitOfTheMonth+firstDigitOfTheMonth);
                if (possibleDate==i){
                    System.out.println(possibleBonusDate);
                }
            }
        }
    }

    public static boolean DateIsValid(int m, int d, int y) {
        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (d <= 31) {
                    return true;
                }
                break;
            case 2:
                if (y % 4 == 0) { // If year is a leap year
                    if (d <= 29) {
                        return true;
                    }
                } else {
                    if (d <= 28) {
                        return true;
                    }
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (d <= 30) {
                    return true;
                }
                break;
        }
        return false;
    }

}
