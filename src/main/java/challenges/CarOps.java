package challenges;

import domain.Car;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarOps {

    //21. Filter by Make: Filter the list of cars to only include cars with a specific make.
    public static List<Car> specificMake(List<Car> cars) {

        return cars.stream()
                .filter(car -> car.getMake().equalsIgnoreCase("Toyota"))
                .collect(Collectors.toList());
    }

    //31. Count Cars by Make: Count the number of cars for each make.

    public static Map<String, Long> countCarsByMake (List<Car> cars){
        return cars.stream()
                .collect(Collectors.groupingBy(Car::getMake, Collectors.counting()));
    }


    //32. Average Price: Calculate the average price of all cars.

    public static double avgPriceOfCars (List<Car> cars){
        OptionalDouble avg = cars.stream()
                .mapToDouble(Car::getPrice)
                .average();
                return avg.orElse(0);
    }

    //33. Sum of Prices: Calculate the sum of all car prices.

    public static double allCarPrices (List<Car> cars){
        return cars.stream()
                .mapToDouble(car -> (double) car.getPrice())
                .reduce(0, Double::sum);
    }

    //34. Any Car with Blue Color: Check if there's any car with a blue color.

    public static boolean blueColorCar(List<Car> cars){
        return cars.stream()
                .anyMatch(car -> car.getColor().equalsIgnoreCase("Blue"));
    }

    //35. All Cars are Expensive: Check if all cars are expensive (e.g., price > 50000).
    public static boolean expansiveCar(List<Car> cars){
        return cars.stream()
                .anyMatch(car -> car.getPrice() > 50000);
    }

    //36. None Match the Condition: Check if none of the cars match a specific condition.
    public static boolean conditionMatch(List<Car> cars){
        return cars.stream()
                .noneMatch(car -> car.getModel().equalsIgnoreCase("Toyota"));
    }

    //37. Skip First N Cars: Skip the first N cars from the list.
    public static List<Car> skipFirst3Cars (List<Car> cars, int n){
        return cars.stream()
                .skip(n)
                .collect(Collectors.toList());
    }

    //38. Limit to N Cars: Limit the list to the first N cars.
    public static List<Car> limitNCars (List<Car> cars, int n){
        return cars.stream()
                .limit(n)
                .collect(Collectors.toList());
    }

    //39. Distinct Colors: Get a list of distinct car colors.
    public static List<String> distinctCarColors(List<Car> cars){
        return cars.stream()
                .map(Car::getColor)
                .distinct()
                .collect(Collectors.toList());
    }

    //40. Concatenate Make and Model: Concatenate the make and model of each car.
    public static List<String> makeModelEachCar(List<Car> cars){
        return cars.stream()
                .map(car -> car.getModel()+ " " + car.getModel())
                .collect(Collectors.toList());
    }

    //41. Find First Car: Find the first car in the list.
    public static Optional<Car> fistCar(List<Car> cars){
//        fistCar().ifPresent(car -> System.out.prinln("first car " + car.getModel()));
        return cars.stream().findFirst();
    }

    //42. Find Any Car: Find any car in the list.

    public static Optional<Car> FindCarInList(List<Car> cars){
        return cars.stream()
                .findFirst();
    }

       return List.of();
    }

}
