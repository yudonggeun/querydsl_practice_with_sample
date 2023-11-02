package study.querydsl.problem.customerOrder;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
public class CustomerPracticeTest {
    @Autowired
    JPAQueryFactory query;

    @BeforeAll
    static void data(@Autowired DataSource dataSource) {
        try (Connection conn = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(conn, new ClassPathResource("/data/practice/member_team.sql"));
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

        // -- 끝 --
    }

}
