import java.util.*;

public class Exercise3 {
    public static void main(String[] args){
        new BuilderTest().runTests();
    }
}

class BuilderTest{
    void runTests(){
        Computer c=new Computer.CompBuilder()
                .setCpu("Intel i5")
                .setRam("8GB")
                .setStorage("512GB SSD")
                .build();
        System.out.println(c);

        Computer c2=new Computer.CompBuilder()
                .setCpu("AMD Ryzen 5")
                .setStorage("1TB HDD")
                .build();
        System.out.println(c2);
    }
}

class Computer{
    private String cpu;
    private String ram;
    private String storage;

    private Computer(CompBuilder builder){
        this.cpu=builder.cpu;
        this.ram=builder.ram;
        this.storage= builder.storage;
    }

    public String getCpu(){
        return cpu;
    }
    public String getRam(){
        return ram;
    }
    public String getStorage(){
        return storage;
    }

    @Override
    public String toString(){
        return this.cpu+" : "+this.ram+" : "+this.storage;
    }

    static class CompBuilder{
        private String cpu;
        private String ram;
        private String storage;
        public CompBuilder(){

        }
        public CompBuilder setCpu(String cpu){
            this.cpu=cpu;
            return this;
        }
        public CompBuilder setRam(String ram){
            this.ram=ram;
            return this;
        }
        public CompBuilder setStorage(String storage){
            this.storage=storage;
            return this;
        }
        public Computer build(){
            Computer computer=new Computer(this);
            return computer;
        }
    }

}
