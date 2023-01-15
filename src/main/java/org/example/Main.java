package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
       Context context=new Context();
       Scanner scanner=new Scanner(System.in);
       Map<String,Strategy> strategyMap=new HashMap<>();
       Strategy strategy;
       while (true){
           System.out.println("Quelle stratégie?:");
           String str=scanner.nextLine();
           strategy=strategyMap.get(str);
           if (strategy == null) {
               System.out.println("Création d'un nouvel objet de StrategyIml"+str);
               strategy=(Strategy) Class.forName("org.example.StrategyImpl"+str).getConstructor().newInstance();
               strategyMap.put(str,strategy);
           }
           context.setStrategy(strategy);
           context.effectuerOperation();
       }
    }
}