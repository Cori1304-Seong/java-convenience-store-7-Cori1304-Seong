package store.model;

import java.util.Date;

public class Promotion {
    String name;
    int buy;
    int get;
    Date startDate;
    Date endDate;

    public Promotion(String name, int buy, int get, Date startDate, Date endDate) {
        this.name = name;
        this.buy = buy;
        this.get = get;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
