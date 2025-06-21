import java.util.*;

public class Exercise1 {
    public static void main(String[] args){
        new Test().runTests();
    }
}

class Test{
    public void runTests(){
        Logger l1=Logger.getLogger();
        System.out.println("l1 hashcode: "+l1.hashCode());
        Logger l2=Logger.getLogger();
        System.out.println("l2 hashcode: "+l2.hashCode());
    }
}

class Logger{
    private static Logger logger;
    private Logger(){
        if(logger!=null){
            throw new RuntimeException("Doesn't follow Singleton pattern");
        }
    }
    public synchronized static Logger getLogger(){
        if(logger==null){
            synchronized (Logger.class){
                if(logger==null){
                    logger=new Logger();
                }
            }
        }
        return logger;
    }
}
