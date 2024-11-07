package store.model;

import java.util.Date;

// TODO 필드 이름 promotions.md와 다르게 해도 되는지 고민
public class Promotion {
    String name;
    int buyCount;
    int getCount;
    Date startDate;
    Date endDate;

    public Promotion(String name, int buy, int get, Date startDate, Date endDate) {
        this.name = name;
        this.buyCount = buy;
        this.getCount = get;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public int getGetCount() {
        return buyCount;
    }

    public void setGetCount(int buy) {
        this.buyCount = buy;
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
        String result = "Name: " + name + ", Buy: " + buyCount + ", Get: " + getCount + ", start_date: " + startDate + "end_date:"
                + endDate;

        return result;

    }

}
