package store.model;

import java.text.SimpleDateFormat;
import java.util.Date;

// TODO getCount, buyCount 이름 고민,
public class Promotion {
    String name;
    int buyCount;
    int getCount;
    Date startDate;
    Date endDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Promotion(String name, int buyCount, int getCount, Date startDate, Date endDate) {
        this.name = name;
        this.buyCount = buyCount;
        this.getCount = getCount;
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
        return getCount;
    }

    public void setGetCount(int getCount) {
        this.getCount = getCount;
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
        String result =
                "Name: " + name + ", Buy: " + buyCount + ", Get: " + getCount + ", Start_date: " + dateFormat.format(startDate)
                        + ", End_date: "
                        + dateFormat.format(endDate);

        return result;
    }
}
