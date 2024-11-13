package store;

import java.util.List;
import store.controller.MainController;

public class Application {
    static List<String> calculateAmountData = List.of(
            "사이다-5",
            "탄산수-2"
            ,"콜라-2"
    );

    static List<String> calculateAmountData1 = List.of(
            "비타민워터-3", "물-2", "정식도시락-2"
    );


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MainController controller = new MainController();
        controller.startBusiness();
        controller.workCustomerOrder(calculateAmountData);
        controller.mockShowPlannedPurchased();
    }
}
