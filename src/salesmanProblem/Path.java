package salesmanProblem;

public class Path {

    private City firstCity;
    private City secondCity;
    private double cost;

    public Path(City first, City second) {
        this.firstCity = first;
        this.secondCity = second;
        this.cost = Math.sqrt(Math.pow((firstCity.getPosX() - secondCity.getPosX()), 2)
                              + Math.pow((firstCity.getPosY() - secondCity.getPosY()), 2));
    }

    public City getFirstCity() {
        return firstCity;
    }

    public void setFirstCity(City firstCity) {
        this.firstCity = firstCity;
    }

    public City getSecondCity() {
        return secondCity;
    }

    public void setSecondCity(City secondCity) {
        this.secondCity = secondCity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
