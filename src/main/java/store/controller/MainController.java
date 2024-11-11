package store.controller;

import java.util.List;
import java.util.Map;
import store.model.GiveWayCount;
import store.model.Order;
import store.model.PlannedPurchase;
import store.model.Product;
import store.model.Promotion;
import store.view.InputView;

/**
 * 1. 구매할 품목 정리
 * 2. 1차 품목 장바구니에 추가 => 프로모션 상품 중에서 추가
 * 3. 2차 품목 장바구니에 추가 => 일반 상품 중에서 추가
 */

public class MainController {
    ProductController productController;
    PromotionController promotionController;
    PlannedPurchaseController plannedPurchaseController;
    OrderController orderController;
    //    Map<String, Integer> orderGroup = new HashMap<>();
    InputView inputView;

    public MainController() {
        this.inputView = new InputView();
        this.productController = new ProductController();
        this.promotionController = new PromotionController();
        this.plannedPurchaseController = new PlannedPurchaseController();
        this.orderController = new OrderController();
    }

    public void startBusiness() {
        // TODO  전체 목록 보여주기 & inputView 로직
        productController.init();


    }

    //TODO 모든 주문건은 다 합쳐서 하기 ex) => 콜라-1. 콜라-1. 콜라-1 이런게 들어오면 콜라-3으로 계산되게
    public void workCustomerOrder(List<String> orders) {
        // TODO input View 집어 넣기
        orderController.buildOrderData(orders);
        storePlannedPurchase();
//        // 1. 주문 데이터화
//        for (String order : orders) {
//            String[] splitData = SplitLogic.splitPurchaseFormat(order);
//            setOrderGroup(splitData[0], Integer.valueOf(splitData[1]));
//
////            String name = splitData[0];
////            int quantity = Integer.valueOf(splitData[0]);
//
//        }
//        // 2. 주문 유용성 검사
//        Set<String> productNames = orderGroup.keySet();
//        for (String name : productNames) {
//            checkContainsProduct(name);
//            checkOrderPossible(name, orderGroup.get(name));
//        }
        // 3. 주문 장바구니 넣기 1차 => 프로모션 제품
        // 4. 남은 주문 장바구니 넣기 2차 => 일반 제품

    }

    public void mockShowPlannedPurchased() {
        List<PlannedPurchase> data = plannedPurchaseController.getPlannedPurchases();
        for (PlannedPurchase plannedPurchase : data) {

            System.out.println(plannedPurchase.toString());
        }
    }

//    private void setOrderGroup(String name, int count) {
//        if (orderGroup.containsKey(name)) {
//            orderGroup.replace(name, count);
//            return;
//        }
//        orderGroup.put(name, count);
//    }


    private void checkContainsProduct(String productName) {
        boolean isContainsPromotionProduct = productController.isContainsPromotionProductByName(productName);
        boolean isContainsProduct = productController.isContainsPromotionProductByName(productName);

        if (!isContainsPromotionProduct && !isContainsProduct) {
            throw new RuntimeException("재고 중에 " + productName + " 제품은 없습니다. "); //TODO 하드코딩 수정
        }
    }

    private void checkOrderPossible(String productName, int requestQuantity) {
        int quantity1 = getPromotionPromotionProductQuantity(productName);
        int quantity2 = getPromotionProductQuantity(productName);

        if (quantity1 + quantity2 - requestQuantity < 0) {
            throw new IllegalArgumentException("[ERROR] 재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요");
        }
    }

    // TODO 반홚값 필요 할지 고민
    private void storePlannedPurchase() {
        saveFirstOrder(orderController.orders);

        saveSecondOrder(orderController.orders);
    }

    private void saveFirstOrder(List<Order> orders) {
        for (Order order : orders) { // 1차 주문 저장
            if (!productController.isContainsPromotionProductByName(order.name) || order.getCount() == 0) {
                return;
            }
            storePromotionProductToPlannedPurchase(order.name, order.getCount());
        }
    }

    private void saveSecondOrder(List<Order> orders) {
        for (Order order : orders) { // 1차 주문 저장
            if (!productController.isContainsProductByName(order.name) || order.getCount() == 0) {
                return;
            }
            storeProductToPlannedPurchase(order.name, order.getCount());
        }
    }

    /**
     * 1. 프로모션 상품인지 확인
     * 2. 주문 양에 프로모션 적용 가능한지 확인
     * 1) 프로모션 적용 가능하면 Y/N 안내 보류
     * 2) 프로모션 수량이 가능한지 파악 후 불가능하면 일반 결재 안내
     * 3) 프로모션 수량 부족시 1) 번 출력 x, 안 부족시 1)번 출력
     * 3. 주문량(2번 수행한 값)을 장바니에 추가 [전체 값이 가능한지 맨 앞에서 화인했으니 그냥 담으면 됨]
     * 1) 이미 넣어둔 물품이면 옆에 "-N" 이라고 붙이고 수량 추가
     * 4) 넣어둔 주문을 하나씩 꺼내면서 결과 출력
     */
    // TODO private으로 변경 예정
//    public void storePromotionProductToPlannedPurchase(String productName, int requestQuantity) {
//        if (!productController.isContainsPromotionProductByName(productName)) {
//            return;
//        }
//        Product product = productController.getPromotionProductGroup().get(productName);
//        Promotion promotion = promotionController.findPromotionByName(product.getPromotion());
//        GiveWayCount giveawayCount = promotionController.calculatePromotionAmount(requestQuantity,
//                promotion.getBuyCount(),
//                promotion.getGetCount());
//
//        // 프로모션  추가구매? (Y/N)
//        if (giveawayCount.unmetCount > product.getQuantity() - requestQuantity) {
//            plannedPurchaseController.requestPromotionPrompt(productName, giveawayCount.unmetCount);
//            plannedPurchaseController.addPlannedPurchase(
//                    new PlannedPurchase(product, true, giveawayCount.paidItems,
//                            giveawayCount.totalGiveWayCount - giveawayCount.paidItems));
//            return;
//        }
//        // 할인이 적용되지 않습니다. 그래도 구매? (Y/N)
//        if (giveawayCount.unmetCount > 0) {
//            if (giveawayCount.unmetCount + requestQuantity <= product.getQuantity()) {
//                plannedPurchaseController.requestPromotionPrompt(productName, giveawayCount.unmetCount);
//            }
//        }
//        plannedPurchaseController.addPlannedPurchase(
//                new PlannedPurchase(product, true, giveawayCount.paidItems, giveawayCount.totalGiveWayCount));
//    }
    public void storePromotionProductToPlannedPurchase(String productName, int requestQuantity) {
        Product product = productController.getPromotionProductGroup().get(productName);
        GiveWayCount giveawayCount = getGiveawayByProductAndQuantity(product, requestQuantity);

        if (handelStoringPromotionException(product, giveawayCount, requestQuantity)) {
            addPlannedPurchase(product, giveawayCount, true);
        }
    }

    private boolean handelStoringPromotionException(Product product, GiveWayCount giveawayCount, int requestQuantity) {
        if (requestQuantity > product.getQuantity()) {
            handleNonDiscountedPurchase(product.getName(), giveawayCount, product);
            return false;
        }
        if (isAdditionalPurchaseRequired(giveawayCount, product, requestQuantity)) {
            handleAdditionalPurchase(product.getName(), product, giveawayCount);
        }
        return true;
    }

    private GiveWayCount getGiveawayByProductAndQuantity(Product product, int quantity) {
        Promotion promotion = promotionController.findPromotionByName(product.getPromotion());
        GiveWayCount giveawayCount = calculateGiveawayCount(quantity, promotion);

        return giveawayCount;
    }

    private GiveWayCount calculateGiveawayCount(int requestQuantity, Promotion promotion) {
        return promotionController.calculatePromotionAmount(
                requestQuantity, promotion.getBuyCount(), promotion.getGetCount());
    }

    private boolean isAdditionalPurchaseRequired(GiveWayCount giveawayCount, Product product, int requestQuantity) {
        return giveawayCount.unmetCount < product.getQuantity() - requestQuantity;
    }

    private void handleAdditionalPurchase(String productName, Product product, GiveWayCount giveawayCount) {
        boolean isAdd = plannedPurchaseController.requestPromotionPrompt(productName, giveawayCount.unmetCount);
        if (isAdd) {
            addPlannedPurchase(product, giveawayCount, true);
        }

    }

    private void handleNonDiscountedPurchase(String productName, GiveWayCount giveawayCount, Product product) {
        boolean isOkayPromotion = plannedPurchaseController.requestPromotionWaring(productName,
                giveawayCount.unmetCount);
        if (!isOkayPromotion) {
            throw new RuntimeException("실행중 다시 구매로 돌아가기"); // 확인 테스트
        }
    }

    private void addPlannedPurchase(Product product, GiveWayCount giveawayCount, boolean isPromotion) {
        plannedPurchaseController.addPlannedPurchase(
                new PlannedPurchase(product, isPromotion, giveawayCount.paidItems, giveawayCount.totalGiveWayCount));
        orderController.minusOrderCount(product.getName(), giveawayCount.paidItems + giveawayCount.totalGiveWayCount);
    }


    private void storeProductToPlannedPurchase(String productName, int requestQuantity) {
        if (!productController.isContainsProductByName(productName) || requestQuantity == 0) {
            return;
        }
        Product product = productController.getProductGroup().get(productName);

        plannedPurchaseController.addPlannedPurchase(
                new PlannedPurchase(product, false, requestQuantity, 0));
    }

//    // TODO
//    private void checkOrderPossible(String productName, int quantity) {
//        boolean isContainsPromotionProduct = productController.isContainsPromotionProductByName(productName);
//        int remainQuantity = productController.getRemainingPromotionProductQuantity(productName, quantity);
//        if (remainQuantity < 0) {
//            int _remainQuantity = productController.getRemainingProductQuantity(productName, remainQuantity);
//            if (_remainQuantity < 0) { //TODO 하드 코딩 제거
//                throw new IllegalArgumentException("[ERROR] 재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요");
//            }
//        }
//    }


    private Promotion getCurrentPromotion(String productName) {
        Map<String, Product> group = productController.getPromotionProductGroup();

        Promotion result = promotionController.findPromotionByName(
                group.get(productName).getPromotion()); // TODO 가독성 상승
        return result;
    }


    private int getPromotionProductQuantity(String productName) {
        boolean isContains = productController.isContainsProductByName(productName);
        if (!isContains) {
            return 0;
        }
        Product product = productController.getProductGroup().get(productName);

        return product.getQuantity();
    }

    private int getPromotionPromotionProductQuantity(String productName) {
        boolean isContains = productController.isContainsPromotionProductByName(productName);
        if (!isContains) {
            return 0;
        }
        Product promotionProduct = productController.getPromotionProductGroup().get(productName);

        return promotionProduct.getQuantity();
    }
}
