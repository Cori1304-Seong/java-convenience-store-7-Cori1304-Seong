package store.util;

import consts.StringConstants;

// TODO 적용할 곳 찾기
public class SplitLogic {

    private SplitLogic() {

    }

    static public String[] splitPurchaseFormat(String text) {

        return text.split(StringConstants.HYPHEN);
    }
}
