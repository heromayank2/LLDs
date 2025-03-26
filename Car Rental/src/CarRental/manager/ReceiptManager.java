package CarRental.manager;

import CarRental.entities.Receipt;
import CarRental.entities.User;
import CarRental.entities.Vehicle;
import CarRental.builder.ReceiptBuilder;
import CarRental.enums.ReceiptStatus;
import CarRental.enums.VehicleType;
import CarRental.exceptions.ReceiptDoesNotExists;
import CarRental.exceptions.VehicleNotSupported;
import CarRental.strategy.PricingStrategy.BikePricingStrategy;
import CarRental.strategy.PricingStrategy.CarPricingStrategy;
import CarRental.strategy.PricingStrategy.PricingStrategy;

import java.util.*;

public class ReceiptManager {
    Map<ReceiptStatus, List<Receipt>> receiptStatusListMap;
    ReceiptBuilder receiptBuilder;
    PaymentHandler paymentHandler;

    public ReceiptManager(){
        receiptStatusListMap = new HashMap<>();
        receiptStatusListMap.put(ReceiptStatus.PENDING, new ArrayList<>());
        receiptStatusListMap.put(ReceiptStatus.COMPLETED, new ArrayList<>());
        receiptStatusListMap.put(ReceiptStatus.CANCELLED, new ArrayList<>());
        receiptBuilder = new ReceiptBuilder();
        paymentHandler = new PaymentHandler();
    }

    public Receipt bookVehicle(Vehicle vehicle, User user, Integer days) throws VehicleNotSupported {
        System.out.println("Creating a booking for Vehicle "+ vehicle.getNumber()+" for user "+user.getName());
        PricingStrategy strategy;
        if(vehicle.getVehicleType().equals(VehicleType.CAR)){
            strategy = new CarPricingStrategy();
        }else if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
            strategy = new BikePricingStrategy();
        }else{
            throw new VehicleNotSupported("Vehicle type not supported");
        }
        Receipt receipt = receiptBuilder
                .setVehicle(vehicle)
                .setUser(user).setDays(days)
                .setStatus(ReceiptStatus.PENDING)
                .setPricingStrategy(strategy)
                .build();
        receiptStatusListMap.get(ReceiptStatus.PENDING).add(receipt);
        return receipt;
    }

    public void cancelBooking(Receipt receipt) throws ReceiptDoesNotExists {
        System.out.println("Cancelling the booking against vehicle "+receipt.getVehicle().getNumber());
        if(!receiptStatusListMap.get(receipt.getStatus()).contains(receipt)){
            throw new ReceiptDoesNotExists("Receipt does not exists");
        }
        receiptStatusListMap.get(receipt.getStatus()).remove(receipt);
        receiptStatusListMap.get(ReceiptStatus.CANCELLED).add(receipt);
    }

    public List<Receipt> getPendingReceiptList(){
        return receiptStatusListMap.get(ReceiptStatus.PENDING);
    }

    public void completeBooking(Receipt receipt) throws ReceiptDoesNotExists {
        if(!receiptStatusListMap.get(receipt.getStatus()).contains(receipt)){
            throw new ReceiptDoesNotExists("Receipt does not exists");
        }
        System.out.println("Completing the booking against vehicle "+receipt.getVehicle().getNumber());
        receiptStatusListMap.get(ReceiptStatus.PENDING).remove(receipt);
        receipt.setStatus(ReceiptStatus.COMPLETED);
        receiptStatusListMap.get(ReceiptStatus.COMPLETED).add(receipt);
        Double amount = receipt.getPricingStrategy().calculatePrice(receipt);
        System.out.println("Amount to be paid: "+amount);
        paymentHandler.processPayment(amount);

    }
}
