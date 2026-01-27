package interview_problems;

public class FindingResult {
    public static void main(String[] args) {
        hack_funct(44,3,3,22,48.5);
        hack_funct(new double[]{1, 2, 3});
    }

    private static void hack_funct(double ...numbers) {
        if(numbers.length == 0) {
            System.out.println("No Argument found");
        }
        double result = numbers[0];
        for (int i = 1; i< numbers.length; i++){
            if(numbers[i] > result) {
                result = numbers[i];
            }
        }
        System.out.println(result);
    }
}
