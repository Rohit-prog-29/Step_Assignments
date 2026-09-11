/**
 * Problem 5: Reverse Customer Name
 * Scenario: The Customer Identity Verification System
 * 
 * Reverses a given customer name character by character without modifying
 * the original string data.
 */
public class Problem5_ReverseCustomerName {

    /**
     * Reverses the given customer name.
     * 
     * @param customerName Customer name to reverse
     * @return Reversed customer name string
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] originalArray = customerName.toCharArray();
        char[] reversedArray = new char[originalArray.length];

        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[i] = originalArray[originalArray.length - 1 - i];
        }

        return new String(reversedArray);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   Customer Identity Verification System");
        System.out.println("==================================================");

        String[] sampleNames = {"Sunil", "Alexander", "Alice", "Rohit", "Developer"};

        for (String name : sampleNames) {
            String reversed = reverseCustomerName(name);
            System.out.println("Input:  \"" + name + "\"");
            System.out.println("Output: Original Name: " + name);
            System.out.println("        Reversed Name: " + reversed);
            System.out.println("--------------------------------------------------");
        }
        System.out.println("==================================================\n");
    }
}
