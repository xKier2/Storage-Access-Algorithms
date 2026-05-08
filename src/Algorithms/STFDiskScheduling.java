package Algorithms;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class STFDiskScheduling {
    public static void STF(int head, int[] request) {

        ArrayList<Integer> stfOrder = getIntegers(head, request);

        System.out.println("\nMove Numbers arranged in STF:");
        for (int i = 0; i < stfOrder.size(); i++) {
            System.out.print(stfOrder.get(i));
            if (i == stfOrder.size() - 2) {
                System.out.print(", and ");
            } else if (i < stfOrder.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }

    @NotNull
    private static ArrayList<Integer> getIntegers(int head, int[] request) {
        ArrayList<Integer> requestList = new ArrayList<>();
        for (int req : request) {
            requestList.add(req);
        }

        ArrayList<Integer> stfOrder = new ArrayList<>();
        int currentPos = head;

        while (!requestList.isEmpty()) {
            int closestIndex = 0;

            int minDistance = Math.abs(requestList.get(0) - currentPos);

            for (int i = 1; i < requestList.size(); i++) {
                int distance = Math.abs(requestList.get(i) - currentPos);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestIndex = i;
                }
            }

            int target = requestList.remove(closestIndex);
            stfOrder.add(target);
            currentPos = target;
        }
        return stfOrder;

    }
}