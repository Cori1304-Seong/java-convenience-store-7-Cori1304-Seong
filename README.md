# java-convenience-store-precourse


## 기능 리스트

### 입력 기능
1. - [ ] 상품과 행사 목록은 파일 입출력을 통해 불러온다.
   - products.md과 promotions.md 파일을 이용
   - 두 파일 모두 내용의 형식을 유지한다면 값은 수정 가능
2. - [ ] 구매할 상품과 수량을 입력 받는다. 
   - 상품명, 수량은 하이픈(-)
   - 개별 상품은 대괄호([])로 묶어 쉼표(,)로 구분.
     >ex) [콜라-10],[사이다-3]
3. - [ ] 프로모션 적용 상품을 고객이 해당 수량보다 적게 가져온 case
   - 그 수량만큼 추가 여부를 입력 받음
   - Y: 증정 받을 수 있는 상품을 추가
   - N: 증정 받을 수 있는 상품을 추가X => 프로모션 할인 6번 이동??
4. - [ ] 프로모션 재고 부족으 일부 수량 프로모션 혜택 없이 결제 case
   - 일부 수량에 대해 정가로 결제할지 여부를 입력 받음
   - Y: 일부 수량에 대해 정가로 결제
   - N: 정가로 결제해야하는 수량만큼 제외한 후 결제 진행
5. - [ ] 멤버십 할인 적용 여부를 입력 받음.
   - Y: 멤버십 할인을 적용
   - N: 멤버십 할인을 적용X
6. - [ ]추가 구매 여부를 입력 받음
   - Y: 재고가 업데이트된 상품 목록을 확인 후 추가로 구매를 진행
   - N: 구매를 종료
7. - [ ] 사용자가 잘못된 값을 입력 case
   - "[ERROR]"로 시작하는 오류 메시지와 함께 상황에 맞는 안내를 출력
   - 구매할 상품과 수량 형식이 올바르지 않은 경우: `[ERROR] 올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.`
   - 존재하지 않는 상품을 입력한 경우: `[ERROR] 존재하지 않는 상품입니다. 다시 입력해 주세요.`
   - 구매 수량이 재고 수량을 초과한 경우: `[ERROR] 재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요.`
   - 기타 잘못된 입력의 경우: `[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.`

### 출력 기능
1. - [ ] 환영 인사와 상품명, 가격, 프로모션 이름, 재고를 안내
   - 만약 재고가 0개라면 재고 없음을 출력
2. 프로모션 적용이 가능한 상품에 대해 고객이 해당 수량만큼 가져오지 안은 case, 
   - 혜택에 대한 안내 메시지를 출력한다.
        > ex) 
        > 현재 {상품명}은(는) 1개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)
3. - [ ] 프로모션 재고가 부족하여 일부 수량을 프로모션 혜택 없이 결제 case 
   - 일부 수량에 대해 정가로 결제할지 여부에 대한 안내 메시지를 출력.
       > ex)
       > 현재 {상품명} {수량}개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)
4. - [ ] 멤버십 할인 적용 여부를 확인하기 위해 안내 문구를 출력
        > 멤버십 할인을 받으시겠습니까? (Y/N)
5. - [ ] 구매 상품 내역, 증정 상품 내역, 금액 정보 출력 
   -  영수증 출력 ?? 
6. 추가 구매 여부를 확인하기 위해 안내 문구를 출력
        > 감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)




### 핵심 기능

### 프로모션 할인
1. - [ ] 초기 재고 정보 promotion.md 통해서 불러오기
   - Promotion관련 model class와 repository class 만들기
   - 불러온 데이터 저장할 collection 만들기
2. - [ ] 오늘 날짜가 프로모션 기간에 포함된 경우만 할인 적용
3. - [ ] Buy N Get 1 Free 
   - 프로모션은 N개 구매 시 1개 무료 증정.
   - 고객이 해당 수량보다 적게 가져온 경우, 필요한 수량을 추가로 가져오면 혜택을 받을 수 있음을 안내
4. - [ ] 프로모션 혜택은 프로모션 재고 내에서만 적용 가능
5. - [ ] 프로모션 기간 중이라면 프로모션 재고를 우선 차감
   - 프로모션 재고가 부족할 경우 => 일반 재고를 사용 가능
6. - [ ] 동일 상품에 여러 프로모션이 적용 안함
   - 동일 상품에 여러 프로모션이 적용되지 않는다.
   - 1+1 또는 2+1 프로모션이 각각 지정된 상품에 적용되며,
7. - [ ] 프로모션 상품 정가 구매 상황 안내
   - 프로모션 재고가 부족하여 일부 수량을 프로모션 혜택 없이 결제 하는 경우, 
   - 일부 수량에 대해 정가로 결제하게 됨을 안내.

    
### 멤버십 할인 
// TODO 멥버심 회원 여부 파악하는 법, 프로모션 미적용 금액 정의 파악
2. - [ ] 멤버십 회원은 프로모션 미적용 금액의 30%를 할인 받음.
3. - [ ] 프로모션 적용 후 남은 금액에 대해 멤버십 할인을 적용
4. - [ ] 멤버십 할인의 최대 한도는 8,000원

### 재고 관리 
> ### 기능 목적
> 1. 재고 차감함 항상 최신 재고 상태 유지, 
> 2. 다음 고객 구매시 정확한 재고 정보 제공

1. - [ ] 초기 재고 정보 products.md 통해서 불러오기 
   - Product관련 model class와 repository class 만들기
   - 불러온 데이터 저장할 collection 만들고 저장
2. - [ ] 각 상품의 재고 수량 파악 후,  결제 가능 여부 확인
  - 재고 없을시 =>   
  - 재고 있을 시 => 
3. - [ ] 항상 고객 결제 후 상품 재고 관리
  - 결제된 수량만큼 해당 상품 재고 차감
  - 구매된 수량만큼 차감 후 수량 관리 실행



### 영수증
> #### 기능 목적
> 1. 영수증은 고객의 구매 내역과 할인을 요약하여 출력
> 2. 영수증의 구성 요소를 보기 좋게 정렬하여 고객이 쉽게 금액과 수량을 확인할 수 있게 한다.

1. - [ ] 고객의 구매 내역과 할인을 요약하여 출력한다.
2. - [ ] 영수증 항목
   - 구매 상품 내역: 구매한 상품명, 수량, 가격
   - 증정 상품 내역: 프로모션에 따라 무료로 제공된 증정 상품의 목록
   - 금액 정보 (아래 참고)
     - 총구매액: 구매한 상품의 총 수량과 총 금액
     - 행사할인: 프로모션에 의해 할인된 금액
     - 멤버십할인: 멤버십에 의해 추가로 할인된 금액
     - 내실돈: 최종 결제 금액
     영수증의 구성 요소를 보기 좋게 정렬하여 고객이 쉽게 금액과 수량을 확인할 수 있게 한다.
3. - [ ] 가독성을 높게 만들어야함 