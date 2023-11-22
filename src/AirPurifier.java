import javax.swing.*;
import java.util.LinkedList;
import java.util.Scanner;

public class AirPurifier {
    String make;
    String model;
    double price;
    String mode = "auto";
    boolean power;
    int fanSpeed = 50;
    void turnOn(){
        power = true;
        System.out.println("Power On");
    };
    void turnOff(){
        power = false;
        System.out.println("Power Off");
    };
    void setMode(String mode){
        if(mode.equalsIgnoreCase("auto")){
            fanSpeed = 50;
        }else if(mode.equalsIgnoreCase("night")){
            fanSpeed = 20;
        }else if(mode.equalsIgnoreCase("self")){
            Scanner s = new Scanner(System.in);
            System.out.println("Enter Fan Speed (0 - 100): ");
            fanSpeed = s.nextInt();
        }
        System.out.println("Current Fan Speed: " + fanSpeed);
    };

    AirPurifier(String make, String model, double price){
        this.make = make;
        this.model = model;
        this.price = price;
        if(allModel.isEmpty()) {
            allModel.add(model);
            modelCount.add(1);
        } else {
            if(!allModel.contains(model)) {
                allModel.add(model);
                modelCount.add(1);
            }else{
                int index = allModel.indexOf(model);
                modelCount.set(index,modelCount.get(index)+1);
            }
        }

    }

    static LinkedList<Integer> modelCount;
//    static  double profit;
    static LinkedList<String> allModel;
    static String mostPopularModel(){
        int max = Integer.MIN_VALUE;
        int i = 0;
        while (i < modelCount.size())
        {
            if (max < modelCount.get(i))
                max = modelCount.get(i);
            i++;
        }
        return allModel.get(modelCount.indexOf(max));
    }

    static void airpurifierCount(){
        int i = 0;
        int count = 0;
        while (i < modelCount.size())
        {
            count += modelCount.get(i);
            i++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        modelCount = new LinkedList<Integer>();
        allModel = new LinkedList<String>();
        // check mostPopularModel()
        AirPurifier a1 = new AirPurifier("xiaomi", "x1", 2000);
        AirPurifier a2 = new AirPurifier("xiaomi", "x2", 200);
        AirPurifier a3 = new AirPurifier("xiaomi", "x1", 2000);
        AirPurifier a4 = new AirPurifier("xiaomi", "x2", 200);
        AirPurifier a5 = new AirPurifier("xiaomi", "x1", 2000);
        System.out.println(mostPopularModel());

        // check setMode()
        AirPurifier a6 = new AirPurifier("xiaomi", "x2", 2000);
        a6.setMode("self");

        // check turnOn() and turnOff()
        AirPurifier a7 = new AirPurifier("xiaomi", "x2", 2000);
        a7.turnOn();
        a7.turnOff();

        System.out.println(mostPopularModel());


        // check airpurifierCount()
        airpurifierCount();
    }
}
