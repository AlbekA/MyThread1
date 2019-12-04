import java.util.Arrays;

public class Main {

    final static int size = 10000000;
    final static int h = size/2;


    public static void main(String[] args) {
        System.out.println("Start");
        float[] arr1 = new float[size];
        float[] arr2 = new float[size];
        method1(arr1);
        method2(arr2);

    }
    public static void method1(float[] arr1) {
        System.out.println("M1");
        for (int i = 0; i < 10000000; i++) {
            arr1[i]=1; Arrays.fill(arr1, 1.0f);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        for(int i = 0; i < 10000000; i++){
            arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));}

        long a = System.currentTimeMillis();
        new Thread(() -> method1(arr1)).start();

        System.out.println("time metod 1: " + (System.currentTimeMillis()-a));

    }
    public static void method2(float[] arr2) {
        System.out.println("M2");

        long startTime = System.currentTimeMillis();
        Arrays.fill(arr2, 1.0f);
        long time1 = (System.currentTimeMillis() - startTime);

        float[] arr3 = new float[size];
        System.arraycopy(arr2, 0, arr3, 0, size);
        float[] arr4 = new float[size];
        System.arraycopy(arr2, size, arr4, 0, size);
        long splitTime = (System.currentTimeMillis() - startTime - time1);

        ThreadProcessing thread1 = new ThreadProcessing(arr3, 0);
        ThreadProcessing thread2 = new ThreadProcessing(arr4, h);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long processingTime = (System.currentTimeMillis() - startTime - time1 - splitTime);

        System.out.println(arr2[50021]);
        System.arraycopy(arr3, 0, arr2, 0, h);
        System.arraycopy(arr2, 0, arr2, h, h);
        long joinTime = (System.currentTimeMillis() - startTime - time1 - splitTime - processingTime);

        System.out.println("Операция выполнена за " + (System.currentTimeMillis() - startTime) + " мс\nРазбивка массива " +
                +splitTime + " мс\nОбработка формулой " + processingTime + " мс\nСклейка массива " + joinTime + " мс\n\n");

        for (int i = 0; i < 10000000; i++) {
            arr2[i]=1; Arrays.fill(arr2, 1.0f);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int i = 0; i < 10000000; i++){
            arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long a = System.currentTimeMillis();
        new Thread(() -> method2(arr2)).start();

        System.out.println("time metod 1: " + (System.currentTimeMillis()-a));
        System.out.println("M2");
    }

}
