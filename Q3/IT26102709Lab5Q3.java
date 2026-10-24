import java.util.Scanner;

public class IT26102709Lab5Q3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final double ROOM_CHARGE_PER_DAY = 48000.00;
        final double DISCOUNT_3_TO_4_DAYS = 10.0;
        final double DISCOUNT_5_OR_MORE_DAYS = 20.0;

        System.out.print("Enter Start Date (1-31): ");
        int startDate = input.nextInt();

        System.out.print("Enter End Date (1-31): ");
        int endDate = input.nextInt();

        if (startDate < 1 || startDate > 31 ||
            endDate < 1 || endDate > 31) {

            System.out.println("Error: Days must be between 1 and 31");
            input.close();
            return;
        }

        if (startDate >= endDate) {
            System.out.println("Error: Start Date must be less than End Date");
            input.close();
            return;
        }

        int daysReserved = endDate - startDate;

        double discountRate;

        if (daysReserved < 3) {
            discountRate = 0;
        } else if (daysReserved <= 4) {
            discountRate = DISCOUNT_3_TO_4_DAYS;
        } else {
            discountRate = DISCOUNT_5_OR_MORE_DAYS;
        }

        double totalAmount = daysReserved * ROOM_CHARGE_PER_DAY;
        totalAmount = totalAmount - (totalAmount * discountRate / 100);

        System.out.println("Room Charge Per Day: Rs. " + ROOM_CHARGE_PER_DAY);
        System.out.println("Number of Days Reserved: " + daysReserved);
        System.out.println("Total Amount to be Paid: " + totalAmount);

        input.close();
    }
}