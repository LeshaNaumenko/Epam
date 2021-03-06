package practice8.task2;

public class Runner {
    public static Integer value = 0;

    public static boolean flag = false;

    public void run() {
        new Thread(() -> {
            synchronized (this) {
                for (int i = 0; i < 1000; i++) {
                    while (Runner.flag) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    value++;
                    Runner.flag = true;
                    notify();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (this) {
                for (int i = 0; i < 1000; i++) {
                    while (!Runner.flag) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.println(value);
                    Runner.flag = false;
                    notify();
                }
            }
        }).start();
    }
}
