package Algorithms;

import java.util.*;

public class SCANDiskScheduling {

    public static void SCAN(int head, int firstTrack, int[] requests) {

        int totalSeekCount = 0;
        int currentHead = head;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> seekSequence = new ArrayList<>();

        left.add(firstTrack);

        for (int r : requests) {
            if (r < head) {
                left.add(r);
            } else {
                right.add(r);
            }
        }

        Collections.sort(left);
        Collections.sort(right);

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

        for (int i = left.size() - 1; i >= 0; i--) {
            int r = left.get(i);
            seekSequence.add(r);
            totalSeekCount += Math.abs(r - currentHead);
            currentHead = r;
        }

        for (int r : right) {
            seekSequence.add(r);
            totalSeekCount += Math.abs(r - currentHead);
            currentHead = r;
        }

        printFormattedOutput(totalSeekCount, seekSequence);
    }

    private static void printFormattedOutput(int totalSeek, List<Integer> sequence) {
        System.out.println("Move Numbers arranged in SCAN:");
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