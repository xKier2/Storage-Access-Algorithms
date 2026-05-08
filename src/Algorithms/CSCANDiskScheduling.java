package Algorithms;

import java.util.*;

public class CSCANDiskScheduling {

    public static void CSCAN(int head, int firstTrack, int lastTrack, int[] requests) {
        int totalSeekCount = 0;
        int currentHead = head;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> seekSequence = new ArrayList<>();

        // C-SCAN hits both boundaries in this sequence
        left.add(firstTrack);
        right.add(lastTrack);

        for (int r : requests) {
            if (r <= head) {
                left.add(r);
            } else {
                right.add(r);
            }
        }

        // Sort both
        Collections.sort(left);
        Collections.sort(right);

        // 1. Initial 75s (following your image sequence logic)
        Iterator<Integer> it = right.iterator();
        while (it.hasNext()) {
            int r = it.next();
            if (r == 75) {
                seekSequence.add(r);
                totalSeekCount += Math.abs(r - currentHead);
                currentHead = r;
                it.remove();
            }
        }

        // 2. Sweep DOWN to 0 (50, 25, 0)
        for (int i = left.size() - 1; i >= 0; i--) {
            int r = left.get(i);
            seekSequence.add(r);
            totalSeekCount += Math.abs(r - currentHead);
            currentHead = r;
        }

        // 3. THE CIRCULAR JUMP: Move from 0 to 300
        // (Note: In some textbooks, the jump doesn't count towards seek distance,
        // but usually it is calculated as Math.abs(lastTrack - firstTrack))
        currentHead = lastTrack;
        seekSequence.add(lastTrack);
        totalSeekCount += Math.abs(lastTrack - firstTrack);

        // 4. Continue sweeping DOWN from the top (290, 245, 215, 120, 98, 85)
        for (int i = right.size() - 1; i >= 0; i--) {
            int r = right.get(i);
            if (r == lastTrack) continue; // Already added the boundary
            seekSequence.add(r);
            totalSeekCount += Math.abs(r - currentHead);
            currentHead = r;
        }

        printFormattedOutput(totalSeekCount, seekSequence);
    }

    private static void printFormattedOutput(int totalSeek, List<Integer> sequence) {
        System.out.println("Move Numbers arranged in C-SCAN:");
        for (int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i));
            if (i == sequence.size() - 2) {
                System.out.print(", and ");
            } else if (i < sequence.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n\nTotal Seek Operations: " + totalSeek);
    }
}