

public class Singleton {
    private static volatile Singleton instance;
    private static Object mutex = new Object();

    private Singleton() {

        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static Singleton getInstance() {
        Singleton result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = result = new Singleton();
                    System.out.println("thread enviado");
                }
            }
        }
        else{
            System.out.println("thread regresado");
        }
        return result;

    }








}
