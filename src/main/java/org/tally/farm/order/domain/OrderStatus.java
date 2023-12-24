package org.tally.farm.order.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {

    INIT("주문 생성"),
    READY("상품준비중"),
    COMPLETED("처리 완료"),

    PAYMENT_COMPLETED("결제 완료"),
    PAYMENT_FAILED("결제 실패"),

    CANCELD("주문 취소"),
    RECEIVED("주문 접수"),

    DELIVERY("배송중"),
    DELAY("배송 지연")
    ;

    private final String description;


}
