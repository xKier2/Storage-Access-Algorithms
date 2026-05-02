public class Main {
    static void main() {
        int head = 50;

        int firstTrack = 0;
        int lastTrack = 300;

        FCFSDiskScheduling.FCFS(head, firstTrack, lastTrack);
    }

    public static int[] requests() {
        return new int[]{75, 25, 290, 215, 50, 75, 120, 85, 245, 98};
    }
}