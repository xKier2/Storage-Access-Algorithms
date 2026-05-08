import Algorithms.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] myRequests;
        int head = 50;
        int firstTrack = 0;
        int lastTrack = 300;

        System.out.print("Enter an Algorithm: \n1. FCFS\n2. STF\n3. SCAN\n4. C-SCAN\n5. C-LOOK\n: ");
        String algorithm = input.nextLine().toLowerCase();

        System.out.println("\nFirst Cylinder Track: " + firstTrack);
        System.out.println("Last Cylinder Track: " + lastTrack + "\n");

        switch(algorithm) {
            case "fcfs":
            case "1":
                myRequests = requests();
                System.out.println("\n");

                FCFSDiskScheduling.FCFS(head, myRequests);

                break;

            case "stf":
            case "2":
                myRequests = requests();
                System.out.println("\n");

                STFDiskScheduling.STF(head, myRequests);

                break;

            case "scan":
            case "3":
                myRequests = requests();
                System.out.println("\n");

                SCANDiskScheduling.SCAN(head, firstTrack, myRequests);

                break;

            case "c-scan":
            case "4":
                myRequests = requests();
                System.out.println("\n");

                CSCANDiskScheduling.CSCAN(head, firstTrack, lastTrack, myRequests);

                break;

            case "c-look":
            case "5":
                myRequests = requests();
                System.out.println("\n");

                CLOOKDiskScheduling.CLOOK(head, firstTrack, lastTrack, myRequests);

                break;
            case "default":
                System.out.print("Enter a valid choice!");
                break;
        }
    }

    public static int[] requests() {
        int[] request = {75, 25, 290, 215, 50, 75, 120, 85, 245, 98};

        System.out.print("Sample Move Numbers: \n");
        for (int i = 0; i < request.length; i++) {
            System.out.print(request[i]);

            if (i == request.length - 2) {
                System.out.print(", and ");
            } else if (i < request.length - 1) {
                System.out.print(", ");
            }
        }
        return request;
    }
}