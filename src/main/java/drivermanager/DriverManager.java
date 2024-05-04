package drivermanager;

public final class DriverManager {
    public static final ThreadLocal<Driver> threadlocal = new ThreadLocal<Driver>();

    public static Driver getDriver(){
        return threadlocal.get();
    }

    public static void setDriver(Driver driver){
        threadlocal.set(driver);
    }

    public static void removeDriver(){
        threadlocal.get().quit();
        threadlocal.remove();
    }
}
