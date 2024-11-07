package store.model;

import java.util.Date;

// TODO 필드 이름 promotions.md와 다르게 해도 되는지 고민
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public int getGet() {
        return buy;
    }

    public void setGet(int buy) {
        this.buy = buy;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEnd(Date endDate) {
        this.endDate = endDate;
    }

    // TODO 필드 이름 변경시 같이 변경
    public String toString() {
        String result = "Name: " + name + ", Buy: " + buy + ", Get: " + get + ", start_date: " + startDate + "end_date:"
                + endDate;

        return result;

    }

}
