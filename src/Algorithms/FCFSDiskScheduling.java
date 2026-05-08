package Algorithms;

public class FCFSDiskScheduling {
    public static void FCFS(int head, int[] myRequests) {
        System.out.println("Head: " + head);
        System.out.println();

        System.out.println("Move Numbers arranged in FCFS:");

        for (int i = 0; i < myRequests.length; i++) {
            System.out.print(myRequests[i]);

            if (i == myRequests.length - 2) {
                System.out.print(", and ");
            } else if (i < myRequests.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }
}