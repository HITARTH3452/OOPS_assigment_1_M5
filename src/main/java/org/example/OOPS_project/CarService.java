package org.example.OOPS_project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

  class CarService {
    private Map<String,Integer> hatchbackPrices;
    private Map<String,Integer> suvPrices;
    private Map<String,Integer> sedanPrices;

    public void carService(){
       hatchbackPrices = new HashMap<>();
       hatchbackPrices.put("BS01", 2000);
       hatchbackPrices.put("EF01", 5000);
       hatchbackPrices.put("CF01", 2000);
       hatchbackPrices.put("BF01", 1000);
       hatchbackPrices.put("GF01", 3000);

       sedanPrices = new HashMap<>();
       sedanPrices.put("BS01", 4000);
       sedanPrices.put("EF01", 8000);
       sedanPrices.put("CF01", 4000);
       sedanPrices.put("BF01", 1500);
       sedanPrices.put("GF01", 6000);

       suvPrices = new HashMap<>();
       suvPrices.put("BS01", 5000);
       suvPrices.put("EF01", 10000);
       suvPrices.put("CF01", 6000);
       suvPrices.put("BF01", 2500);
       suvPrices.put("GF01", 8000);
    }

    public int totalBill(String carType, List<String> serviceCodes){
        Map<String,Integer> carPrices = getCarPrices(carType);
        int totalBill = 0;

        for(String code : serviceCodes){
            if(carPrices.containsKey(code)){
                totalBill += carPrices.get(code);
            }
        }
        return totalBill;
    }

      private Map<String, Integer> getCarPrices(String carType) {
        if(carType.equals(("Hatchback"))){
            return hatchbackPrices;
        }else if(carType.equals("Sedan")){
            return sedanPrices;
        }else if(carType.equals("SUV")){
            return suvPrices;
        }else{
            throw new IllegalArgumentException("Invalid car");
        }
      }

      public void billGeneration(String carType, List<String> serviceCodes){
        int totalBill = totalBill(carType,serviceCodes);

          System.out.println("Car type : "+carType);
          System.out.println("Service Code : "+serviceCodes);

          for(String code : serviceCodes){
              Map<String, Integer> carPrices = getCarPrices(carType);
              if(carPrices.containsKey(code)){
                  int price = carPrices.get(code);
                  System.out.println("cost for "+getServiceName(code)+ price+ ": rupees");
              }
              System.out.println("Total cost : "+ totalBill);

              if(totalBill>10000){
                  System.out.println("free cleaning included");
              }
          }
      }

      private String getServiceName(String code) {
        if(code.equals("BS01")){
            return "Basic Servicing";
        }else if(code.equals("EF01")){
            return "Engine Fixing";
        }else if(code.equals("CF01")){
            return "Clutch Fixing";
        } else if (code.equals("BF01")) {
            return "Brake Fixing";
        } else if (code.equals("GF01")) {
            return "Gear Fixing";
        }else{
            throw new IllegalArgumentException("Service code not present");
        }
      }
  }
