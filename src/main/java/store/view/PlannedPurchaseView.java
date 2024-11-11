package store.view;

import camp.nextstep.edu.missionutils.Console;

public class PlannedPurchaseView {

    final String PROMOTION_PROMPT_MESSAGE = "현재 %s은(는) %d개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)";
    final String PROMOTION_WARING_MESSAGE = "\"현재 %s %d개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)";

    public boolean requestPromotionPrompt(String productName, int count) {
        while (true) {
            System.out.println(String.format(PROMOTION_PROMPT_MESSAGE, productName, count));
            try {
                return readYesOrNo();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean requestPromotionWaring(String productName, int count) {
        while (true) {
            System.out.println(String.format(PROMOTION_WARING_MESSAGE, productName, count));
            try {
                return readYesOrNo();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean readYesOrNo() {
        String input = Console.readLine();
        //TODO Y/N input 유용성 검사 시작
        if (input.equals("Y")) {
            return true;
        }
        return false;
    }


}


