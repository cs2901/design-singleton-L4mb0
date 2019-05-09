public class Singleton {
    private static volatile Singleton instance;

    private Singleton(){

        if (instance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static Singleton getInstance() {
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton instance1 = Singleton.getInstance();
                System.out.println("Instance 1 hash:" + instance1.hashCode());//testing
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton instance2 = Singleton.getInstance();
                System.out.println("Instance 2 hash:" + instance2.hashCode());//testing
            }
        });

        t1.start();
        t2.start();
    }
}
