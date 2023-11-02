package study.querydsl.problem.customerOrder;

import com.querydsl.core.types.dsl.*;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import study.querydsl.customerOrder.QCustomer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

import static study.querydsl.customerOrder.QCustomer.customer;
import static study.querydsl.customerOrder.QOrders.orders;

@SpringBootTest
public class CustomerAnswerTest {
    @Autowired
    JPAQueryFactory query;

    @BeforeAll
    static void data(@Autowired DataSource dataSource) {
        try (Connection conn = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(conn, new ClassPathResource("/data/practice/customer_order.sql"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/131534#
    @DisplayName("""
            연습 문제 1 : 
            가입한 전체 회원들 중 상품을 구매한 회원수와 상품을 
            구매한 회원의 비율(=2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)을 
            년, 월 별로 출력하는 SQL문을 작성해주세요. 
            상품을 구매한 회원의 비율은 소수점 두번째자리에서 반올림하고, 
            전체 결과는 년을 기준으로 오름차순 정렬해주시고 년이 같다면 월을 기준으로 오름차순 정렬해주세요.
            """)
    @Test
    void problem1() {
        // -- 시작 --
        QCustomer c2 = new QCustomer("c2");
        List<?> result = query
                .select(
                        orders.salesDate.year(),
                        orders.salesDate.month(),
                        customer.countDistinct(),
                        MathExpressions.round(
                                customer.countDistinct().doubleValue()
                                        .divide(
                                                JPAExpressions
                                                        .select(c2.countDistinct())
                                                        .from(c2)
                                                        .where(c2.joined.year().eq(2021))
                                        ),1
                        )
                )
                .from(orders)
                .innerJoin(customer)
                .on(orders.customer.eq(customer))
                .where(customer.joined.year().eq(2021))
                .groupBy(
                        orders.salesDate.year(),
                        orders.salesDate.month()
                )
                .orderBy(
                        orders.salesDate.year().asc(),
                        Expressions.stringTemplate("function('month', {0})", orders.salesDate).asc()
                )
                .fetch();
        // -- 끝 --
        System.out.println("\nYEAR, MONTH, PUCHASED_USERS, PUCHASED_RATIO");
        for (var row : result) {
            System.out.println(row);
        }
    }
}
