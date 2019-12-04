public class ThreadProcessing extends Thread {
    private float[] arr;
    private int startIndex;

    public ThreadProcessing(float[] arr, int startIndex) {
        this.arr = arr;
        this.startIndex = startIndex;
    }

    @Override
    public void run() {
        for (int element = 0; element < this.arr.length; element++) {
            this.arr[element] = (float) (this.arr[element] * Math.sin(0.2f + (element + startIndex) / 5) * Math.cos(0.2f + (element + startIndex) / 5) * Math.cos(0.4f + (element + startIndex) / 2));
        }
    }
}
