package helpers;


public class CarsFilterUrlParamsBuilder {
    String model = "";
    String mark = "";
    String generation = "";
    String minYear = "";
    String fuelType = "";
    String unSold = "";
    String minMileage = "";


    public CarsFilterUrlParamsBuilder setModel(String model) {
        this.model = model + "/";
        return this;
    }

    public CarsFilterUrlParamsBuilder setMark(String mark) {
        this.mark = mark + "/";
        return this;
    }

    public CarsFilterUrlParamsBuilder setGeneration(String generation) {
        this.generation = generation + "/";
        return this;
    }

    public CarsFilterUrlParamsBuilder setMinYear(String minYear) {
        this.minYear = "minyear=" + minYear + "&";
        return this;
    }

    public CarsFilterUrlParamsBuilder setFuelType(String fuelType) {
        this.fuelType = "fueltype=" + fuelType + "&";
        return this;
    }

    public CarsFilterUrlParamsBuilder setMinMileage(String minMileage) {
        this.minMileage = "minprobeg=" + minMileage + "&";
        return this;
    }

    public CarsFilterUrlParamsBuilder setUnsold(String unsold) {
        this.unSold = "unsold=" + unsold + "&";
        return this;
    }

    private String generateUrlParams() {
        return this.model + this.mark + this.generation;
    }

    private String generateQueryStringParams() {
        return "?" + this.minYear + this.fuelType + this.unSold + this.minMileage;
    }

    public CarsFilterUrlParams build() {
        String urlParams = generateUrlParams();
        String queryStringParams = generateQueryStringParams();
        return new CarsFilterUrlParams(urlParams, queryStringParams);
    }

}
