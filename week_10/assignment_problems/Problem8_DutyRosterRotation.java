import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Category C · Coding Assignment
 * Problem 8: Duty Roster Rotation
 *
 * TASK:
 * A hostel rotates its cleaning duty roster every week by moving each name k
 * places to the right; names that go past the end wrap around to the front.
 *
 * Implement a function rotateRoster(names, k) that returns the roster after
 * rotating it to the right by k places. k may be larger than the number of names.
 *
 * CONSTRAINTS:
 * - 1 <= length of names <= 100
 * - 0 <= k <= 10^9
 *
 * COMPLEXITY REQUIREMENTS:
 * - Why 1-by-1 rotation is slow: Rotating one step at a time k times takes
 *   O(k * n) operations. When k can be up to 10^9, this requires ~10^11 operations,
 *   causing Time Limit Exceeded (TLE).
 * - Optimal Complexity: By applying the modulo operation k % n, full cycles
 *   are eliminated in O(1) time. The rotation is performed in O(n) time and
 *   O(n) auxiliary space (or O(1) auxiliary space via in-place reversal).
 */
public class Problem8_DutyRosterRotation {

    /**
     * Rotates names array k positions to the right in O(n) time.
     *
     * @param names array of roster names
     * @param k number of places to rotate right (can be up to 10^9)
     * @return rotated array
     */
    public static String[] rotateRoster(String[] names, long k) {
        if (names == null || names.length <= 1) {
            return names;
        }

        int n = names.length;
        int effectiveK = (int) (k % n);
        if (effectiveK == 0) {
            return names.clone();
        }

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            int newIndex = (i + effectiveK) % n;
            rotated[newIndex] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> nameList = new ArrayList<>();
        Long kVal = null;

        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.contains("names")) {
                int start = line.indexOf('[');
                int end = line.indexOf(']');
                if (start != -1 && end != -1) {
                    String[] tokens = line.substring(start + 1, end).split("[,\\s]+");
                    for (String t : tokens) {
                        if (!t.isEmpty()) nameList.add(t);
                    }
                }
                if (line.contains("k")) {
                    String afterK = line.substring(line.indexOf("k"));
                    Scanner s = new Scanner(afterK.replaceAll("[^0-9]", " "));
                    if (s.hasNextLong()) kVal = s.nextLong();
                    s.close();
                }
            } else {
                String[] tokens = line.replace("[", "").replace("]", "").split("[,\\s]+");
                for (String t : tokens) {
                    if (!t.isEmpty()) nameList.add(t);
                }
                if (scanner.hasNextLong()) {
                    kVal = scanner.nextLong();
                }
            }
        }

        if (!nameList.isEmpty() && kVal != null) {
            String[] names = nameList.toArray(new String[0]);
            System.out.println(Arrays.toString(rotateRoster(names, kVal)));
        } else {
            // Default sample demonstration:
            // Sample 1: names = [A, B, C, D, E], k = 2 -> [D, E, A, B, C]
            // Sample 2: names = [A, B, C, D, E], k = 7 -> [D, E, A, B, C]
            String[] sampleNames = {"A", "B", "C", "D", "E"};
            System.out.println("Sample 1 (k=2): " + Arrays.toString(rotateRoster(sampleNames, 2)));
            System.out.println("Sample 2 (k=7): " + Arrays.toString(rotateRoster(sampleNames, 7)));
        }

        scanner.close();
    }
}
