public class FCFSDiskScheduling {
    public static void FCFS(int head, int firstTrack, int lastTrack) {
        System.out.println("First Cylinder Track: " + firstTrack);
        System.out.println("Last Cylinder Track: " + lastTrack);
        System.out.println("Head: " + head);
        System.out.println();

        int[] request = Main.requests();
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