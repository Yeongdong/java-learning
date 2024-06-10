package sample.cafekiosk.spring.domain.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import sample.cafekiosk.spring.IntegrationTestSupport;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static sample.cafekiosk.spring.domain.product.ProductSellingStatus.SELLING;
import static sample.cafekiosk.spring.domain.product.ProductType.HANDMADE;

@Transactional
class OrderRepositoryTest extends IntegrationTestSupport {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @DisplayName("지정한 날짜에 주문한 상품 리스트를 반환한다.")
    @Test
    void findOrdersBy() {
        // given
        LocalDateTime now = LocalDateTime.of(2023, 3, 5, 0, 0);

        List<Product> product = List.of(
                createProduct("001", 1000),
                createProduct("002", 2000),
                createProduct("003", 3000),
                createProduct("004", 5000)
        );
        List<Product> products = productRepository.saveAll(product);

        Order order1 = createPaymentCompletedOrder(LocalDateTime.of(2023, 3, 4, 23, 59, 59), products);
        Order order2 = createPaymentCompletedOrder(now, products);
        Order order3 = createPaymentCompletedOrder(LocalDateTime.of(2023, 3, 5, 23, 59, 59), products);
        Order order4 = createPaymentCompletedOrder(LocalDateTime.of(2023, 3, 6, 0, 0), products);

        // when
        List<Order> orders = orderRepository.findOrdersBy(
                LocalDateTime.of(2023, 3, 5, 0, 0),
                LocalDateTime.of(2023, 3, 6, 0, 0),
                OrderStatus.PAYMENT_COMPLETED);

        assertThat(orders).hasSize(2)
                .extracting("orderStatus")
                .contains(OrderStatus.PAYMENT_COMPLETED);
    }

    private Product createProduct(String productNumber, int price) {
        return Product.builder()
                .productNumber(productNumber)
                .type(HANDMADE)
                .price(price)
                .sellingStatus(SELLING)
                .name("메뉴 이름")
                .build();
    }

    private Order createPaymentCompletedOrder(LocalDateTime now, List<Product> products) {
        Order order = Order.builder()
                .products(products)
                .orderStatus(OrderStatus.PAYMENT_COMPLETED)
                .registeredDateTime(now)
                .build();

        return orderRepository.save(order);
    }
}