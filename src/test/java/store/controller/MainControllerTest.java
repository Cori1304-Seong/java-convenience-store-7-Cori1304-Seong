package store.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertNowTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import com.sun.tools.javac.Main;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.Application;
import store.util.CustomFormater;

class MainControllerTest extends NsTest {
    private MainController controller;

    Date START_DATE = CustomFormater.convertToDate("2024-01-01");
    Date END_DATE =  CustomFormater.convertToDate("2024-12-31");

    List<String> calculateAmountData = List.of(
          "사이다-5",
            "탄산수-2"
            ,"콜라-2"
    );

//    @BeforeEach
//    void set() {
//        this.controller = new MainController();
//        controller.startBusiness();
//    }




    @Test
    public  void storePromotionProductToPlannedPurchase(){

//        for (String i :calculateAmountData){
//            String[] split =i.split("-");
//            controller.storePromotionProductToPlannedPurchase(split[0], Integer.valueOf(split[1]));
//
//        }


        assertNowTest(() -> {
            run( "Y", "Y", "Y");
            controller.workCustomerOrder(calculateAmountData);
            controller.mockShowPlannedPurchased();
        }, LocalDate.of(2024, 2, 1).atStartOfDay());

    }



    @Override
    public void runMain() {
          controller = new MainController();
        controller.startBusiness();
    }
}