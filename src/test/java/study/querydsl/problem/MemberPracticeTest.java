package study.querydsl.problem;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * querydsl을 연습하기 위해서 문제를 만들었습니다.
 * 정답은 AnswerTest를 참고하세요.
 */
@SpringBootTest
@DisplayName("멤버 팀 테이블 querydsl 문제")
public class MemberPracticeTest {

    @Autowired
    EntityManager em;
    @Autowired
    JPAQueryFactory query;

    @DisplayName("연습 문제 1 : Member 테이블을 전체 조회하는 쿼리 작성하기")
    @Test
    void problem1() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --

        // -- 끝 --
    }

    @DisplayName("연습 문제 2 : 나이가 10살 이상인 Member 조회하기")
    @Test
    void problem2() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --

        // -- 끝 --
    }

    @DisplayName("연습 문제 3 : id가 1인 멤버 조회하기")
    @Test
    void problem3() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --

        // -- 끝 --
    }

    @DisplayName("연습 문제 4 : username 에 'member'가 포함된 사람들을 조회하기")
    @Test
    void problem4() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --

        // -- 끝 --
    }

    @DisplayName("연습 문제 5 : 나이가 20살 이상이고 username에 'member'가 포함된 사람들 조회")
    @Test
    void problem5() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --

        // -- 끝 --
    }

    @DisplayName("연습 문제 6 : 20대인 사람들을 조회")
    @Test
    void problem6() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --

        // -- 끝 --
    }

    @DisplayName("연습 문제 7 : 20대 이거나 50대인 사람들을 조회")
    @Test
    void problem7() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --

        // -- 끝 --
    }

    @DisplayName("연습 문제 8 : 20대가 아닌 사람들을 조회")
    @Test
    void problem8() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --

        // -- 끝 --
    }

    @DisplayName("연습 문제 9 : 나이순(asc)으로 정렬한 사람들 목록 조회")
    @Test
    void problem9() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --

        // -- 끝 --
    }

    @DisplayName("""
            연습 문제 10 
            * 오직 member 테이블만 사용해서 사람들이 속한 팀의 id를 조회하기
            * 중복된 팀 id를 조회하지 않기
            """)
    @Test
    void problem10() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --

        // -- 끝 --
    }

    @DisplayName("연습 문제 11 : 사람들이 속한 팀의 id를 조회하고 각 팀에 소속된 사람들의 수를 구하라")
    @Test
    void problem11() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --

        // -- 끝 --
    }

    @DisplayName("연습 문제 12 : 모든 사람들의 나이를 합한 것을 구하라")
    @Test
    void problem12() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --

        // -- 끝 --
    }


    @DisplayName("연습 문제 13 : 모든 사람들의 나이를 합한 것을 팀별로 구하라")
    @Test
    void problem13() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --

        // -- 끝 --
    }

    @DisplayName("연습 문제 14 : 사람들의 평균 나이 구하기")
    @Test
    void problem14() {
        // -- 시작 --

        // -- 끝 --
    }

    @DisplayName("연습 문제 15 : 사람들을 팀 정보를 포함해서 구하기")
    @Test
    void problem15() {
        // -- 시작 --

        // -- 끝 --
    }

    @DisplayName("연습 문제 16 : 팀원 수가 3명 이상인 팀의 구성원을 구하기")
    @Test
    void problem16() {
        // -- 시작 --

        // -- 끝 --
    }

    @DisplayName("연습 문제 17 : 평균 나이가 30이하인 팀 구하기")
    @Test
    void problem() {
        // -- 시작 --

        // -- 끝 --
    }


}