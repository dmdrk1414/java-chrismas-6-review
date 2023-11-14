package christmas.domain.benefit;

import christmas.domain.order.Orders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BenefitTest {
    private Benefit benefit;

    @BeforeEach
    void setUp() {
        String orderString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Orders orders = new Orders(orderString);
        benefit = new Benefit(3, orders);
    }

    @DisplayName("모든 해택에 관한 정보를 얻는다")
    @Test
    void getInformation() {
        // given
        String orderString = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Orders orders = new Orders(orderString);
        benefit = new Benefit(3, orders);

        // when
        Map<String, Integer> result = benefit.getInformation();

        // than
        assertThat(result.toString()).contains("{크리스마스 디데이 할인=1200, 평일 할인=4046, 특별 할인=1000, 증정 이벤트=25000}");
    }

    @DisplayName("모든 해택에 관한 정보를 얻는다_2")
    @Test
    void getInformation_2() {
        // given
        String orderString = "타파스-1,제로콜라-1";
        Orders orders = new Orders(orderString);
        benefit = new Benefit(3, orders);

        // when
        Map<String, Integer> result = benefit.getInformation();
        System.out.println(result);
        // than
        assertThat(result.toString()).contains("{}");
    }

    @Test
    void getTotalDiscount() {
    }

    @Test
    void getTotalBenefit() {
    }

    @Test
    void getBadgeName() {
    }

    @Test
    void getFreebieCount() {
    }
}