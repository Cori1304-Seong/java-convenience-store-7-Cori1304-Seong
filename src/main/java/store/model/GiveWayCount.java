package store.model;

public class GiveWayCount {
    public final int paidItems;
    public final int totalGiveWayCount;
    public final int unmetCount;

    public GiveWayCount(int paidItems, int totalGiveWayCount, int unmetCount) {
        this.paidItems = paidItems;
        this.totalGiveWayCount = totalGiveWayCount;
        this.unmetCount = unmetCount;
    }
}
