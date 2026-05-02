public class FCFSDiskScheduling {
    public static void FCFS(int head, int firstTrack, int lastTrack) {
        System.out.println("First Cylinder Track: " + firstTrack);
        System.out.println("Last Cylinder Track: " + lastTrack);
        System.out.println("Head: " + head);
        System.out.println();

        System.out.print("Sample Move Numbers: \n");
        int[] request = Main.requests();

        for (int i = 0; i < request.length; i++) {
            System.out.print(request[i]);

            if (i == request.length - 2) {
                System.out.print(", and ");
            } else if (i < request.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");

        System.out.println("Move Numbers arranged in FCFS:");
        for (int i = 0; i < request.length; i++) {
            System.out.print(request[i]);
            if (i < request.length - 2) {
                System.out.print(", ");
            } else if (i == request.length - 2) {
                System.out.print(", and ");
            }
        }
        System.out.println("\n");
    }
}