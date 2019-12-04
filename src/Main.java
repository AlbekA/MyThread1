public class Main {
    /*public static void main(String[] args) {

        final int size = 10000000;
        final int h = size/2;
        float[] arr = new float[size];



        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
            if (i < 11)
                System.out.printf(" " + arr[i]);
        }

        System.out.printf("\n");

        long a = System.currentTimeMillis();
        new Thread(() -> metod1(arr)).start();

        System.out.println("time metod 1: " + (System.currentTimeMillis()-a));

        for (int i = 0; i < 10000000; i++) {
            arr[i] = 1;

            if (i < 10000000)
                System.out.printf(" " + arr[i]);

        }
        System.out.printf("\n");

        long a1 = System.currentTimeMillis();
        System.out.println("time metod 2: " + (System.currentTimeMillis()-a1));

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try{
            t1.join();
        }
        catch (InterruptedException e){
            System.out.println("Что-то пошло не так.");
        }

    }

    private static void metod1(float[] arr) {
    }

     */

    public static void main(String[] args) {
        Main e1 = new Main();
        System.out.println("Start");

        final int size = 10000000;
        final int h = size/2;
        float[] arr = new float[size];
        new Thread(() -> e1.method1()).start();
        new Thread(() -> e1.method2()).start();
    }
    public synchronized void method1(float[] arr) {
        System.out.println("M1");
        for (int i = 0; i < 10000000; i++) {
            arr[i]=1;
            System.out.println(i + " = " + arr[i]);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        long a = System.currentTimeMillis();
        new Thread(() -> method1(arr)).start();

        System.out.println("time metod 1: " + (System.currentTimeMillis()-a));

        System.out.println("M2");
    }
    public synchronized void method2(float[] arr) {
        System.out.println("M1");
        for (int i = 0; i < 10000000; i++) {
            arr[i]=1;
            System.out.println(i + " = " + arr[i]);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        long a = System.currentTimeMillis();
        new Thread(() -> method2(arr)).start();

        System.out.println("time metod 1: " + (System.currentTimeMillis()-a));
        System.out.println("M2");
    }

}
