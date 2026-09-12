package week_1.assignment_problems;

/**
 * Week 1 Assignment - Problem 4: The Warehouse Inventory Balancer
 * Scenario: Warehouse stock monitoring across Section A and Section B.
 * 
 * Computes totals for both sections, verifies balance, and identifies highest item quantity.
 */
public class Problem4_WarehouseInventory {

    /**
     * Analyzes inventory across Section A and Section B.
     * 
     * @param sectionA Quantities in Section A
     * @param sectionB Quantities in Section B
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null || sectionA.length != sectionB.length) {
            System.out.println("Invalid inventory input data.");
            return;
        }

        int totalA = 0;
        int totalB = 0;

        for (int qty : sectionA) totalA += qty;
        for (int qty : sectionB) totalB += qty;

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int maxQty = Integer.MIN_VALUE;
        String maxLoc = "";

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                maxLoc = "Section A, Item " + (i + 1);
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                maxLoc = "Section B, Item " + (i + 1);
            }
        }

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s)%n",
                totalA, totalB, status, maxQty, maxLoc);
    }

    public static void main(String[] args) {
        System.out.println("==================================================================================");
        System.out.println("   Warehouse Inventory Balancer");
        System.out.println("==================================================================================");

        int[] secA = {20, 15, 30};
        int[] secB = {25, 10, 30};

        System.out.println("Input:  sectionA={20, 15, 30}, sectionB={25, 10, 30}");
        System.out.print("Output: ");
        analyzeInventory(secA, secB);

        System.out.println("==================================================================================\n");
    }
}
