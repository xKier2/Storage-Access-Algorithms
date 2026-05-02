public class Main {
    static void main() {
        int head = 50;

        int firstTrack = 0;
        int lastTrack = 300;

        FCFSDiskScheduling.FCFS(head, firstTrack, lastTrack);
        STFDiskScheduling.STF(head, firstTrack, lastTrack);
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