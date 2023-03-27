package helpers;

public class CarsFilterUrlParams {
    String params;


    public CarsFilterUrlParams(String urlParams, String queryStringParams) {
        this.params = urlParams + queryStringParams;
    }


    public String getParams() {
        return params;
    }
}



