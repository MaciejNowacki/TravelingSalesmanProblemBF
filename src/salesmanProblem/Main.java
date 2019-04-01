package salesmanProblem;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static ArrayList<City> listOfCities = new ArrayList<City>();
    @SuppressWarnings("unused")
    private static ArrayList<City> bestOfRoute = new ArrayList<City>();
    private static City startPoint;
    private static double minDistance = Double.MAX_VALUE;

    public static void main(String[] args) {
        startPoint = new City(0, 0, "Pabianice");
        listOfCities.add(new City(1, 1, "Lodz"));
        listOfCities.add(new City(0, -2, "Belchatow"));
        listOfCities.add(new City(-2, 0, "Lask"));
        generate(listOfCities.size());
        //printAllCities();
        //System.out.println(": " + minDistance);
    }

    public static void generate(int k) {
        if (k == 1) {
            double currentDistance = calculateRoute();
            if (currentDistance < minDistance) {
                bestOfRoute = listOfCities;
                minDistance = currentDistance;
            }
            printAllCities();
            System.out.println(": " + currentDistance);
        } else {
            generate(k - 1);
            for (int i = 0; i < k - 1; i++) {
                if ((k % 2) == 0) {
                    Collections.swap(listOfCities, i, k - 1);
                } else {
                    Collections.swap(listOfCities, 0, k - 1);
                }
                generate(k - 1);
            }
        }
    }

    public static double calculateRoute() {
        double route = getDist(startPoint, listOfCities.get(0));
        for (int i = 0; i < listOfCities.size() - 1; i++) {
            route += getDist(listOfCities.get(i), listOfCities.get(i + 1));
        }
        route += getDist(listOfCities.get(listOfCities.size() - 1), startPoint);
        return route;
    }

    public static void printAllCities() {
        System.out.print(startPoint.getName() + " => ");
        for (City city : listOfCities) {
            System.out.print(city.getName() + " => ");
        }
        System.out.print(startPoint.getName());
    }

    public static double getDist(City firstCity, City secondCity) {
        return Math.sqrt(Math.pow((firstCity.getPosX() - secondCity.getPosX()), 2)
                         + Math.pow((firstCity.getPosY() - secondCity.getPosY()), 2));
    }
}
