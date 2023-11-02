package study.querydsl.problem;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import study.querydsl.entity.Member;
import study.querydsl.entity.Team;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import static com.querydsl.core.types.ExpressionUtils.count;
import static org.assertj.core.api.Assertions.assertThat;
import static study.querydsl.entity.QMember.member;
import static study.querydsl.entity.QTeam.team;

/**
 * querydsl을 연습하기 위해서 문제를 만들었습니다.
 * 정답은 AnswerTest를 참고하세요.
 */
@SpringBootTest
@DisplayName("멤버 팀 테이블 querydsl 문제 답")
public class MemberAnswerTest {

    @Autowired
    EntityManager em;
    @Autowired
    JPAQueryFactory query;

    @BeforeAll
    static void data(@Autowired DataSource dataSource) {
        try (Connection conn = dataSource.getConnection()) {
            // 자신의 script path 넣어주면 됨
            ScriptUtils.executeSqlScript(conn, new ClassPathResource("/data/practice/member_team.sql"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DisplayName("연습 문제 1 : Member 테이블을 전체 조회하는 쿼리 작성하기")
    @Test
    void answer1() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --
        var result = query
                .selectFrom(member)
                .fetch();
        // -- 끝 --
        System.out.println("\n-------result---------");
        for (var member : result) {
            System.out.println(member);
        }
    }

    @DisplayName("연습 문제 2 : 나이가 10살 이상인 Member 조회하기")
    @Test
    void answer2() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --
        var result = query
                .selectFrom(member)
                .where(member.age.goe(10))
                .fetch();
        // -- 끝 --
        System.out.println("\n-------result---------");
        for (var member : result) {
            System.out.println(member);
            assertThat(member.getAge()).isGreaterThanOrEqualTo(10);
        }
    }

    @DisplayName("연습 문제 3 : id가 1인 멤버 조회하기")
    @Test
    void problem3() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --
        var result = query
                .selectFrom(member)
                .where(member.id.eq(1L))
                .fetchOne();
        // -- 끝 --
        System.out.println(result);
        assertThat(result.getId()).isEqualTo(1L);
    }

    @DisplayName("연습 문제 4 : username에 'member'가 포함된 사람들을 조회하기")
    @Test
    void problem4() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --
        List<Member> result = query
                .selectFrom(member)
                .where(member.username.like("%member%"))
                .fetch();
        // -- 끝 --
        for (Member member : result) {
            System.out.println(member);
            assertThat(member.getUsername()).contains("member");
        }
    }

    @DisplayName("연습 문제 5 : 나이가 20살 이상이고 username에 'member'가 포함된 사람들 조회")
    @Test
    void problem5() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --
        List<Member> result = query
                .selectFrom(member)
                .where(
                        member.age.goe(20),
                        member.username.like("%member%")
                )
                .fetch();
        // -- 끝 --
        for (Member member : result) {
            System.out.println(member);
            assertThat(member.getUsername()).contains("member");
            assertThat(member.getAge()).isGreaterThanOrEqualTo(20);
        }
    }

    @DisplayName("연습 문제 6 : 20대인 사람들을 조회")
    @Test
    void problem6() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --
        List<Member> result = query
                .selectFrom(member)
                .where(member.age.between(20, 29))
                .fetch();
        // -- 끝 --
        for (Member member : result) {
            System.out.println(member);
            assertThat(member.getAge()).isBetween(20, 29);
        }
    }

    @DisplayName("연습 문제 7 : 20대 이거나 50대인 사람들을 조회")
    @Test
    void problem7() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --
        List<Member> result = query
                .selectFrom(member)
                .where(
                        member.age.between(20, 29).or(member.age.between(50, 59))
                )
                .fetch();
        // -- 끝 --
        for (Member member : result) {
            System.out.println(member);
            assertThat(member.getAge()).matches(age -> (age >= 20 && age <= 29) || (age >= 50 && age <= 59));
        }
    }

    @DisplayName("연습 문제 8 : 20대가 아닌 사람들을 조회")
    @Test
    void problem8() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --
        List<Member> result = query
                .selectFrom(member)
                .where(member.age.between(20, 29).not())
                .fetch();
        // -- 끝 --
        for (Member member : result) {
            System.out.println(member);
            assertThat(member.getAge()).matches(age -> age < 20 || age > 29);
        }
    }

    @DisplayName("연습 문제 9 : 나이순(asc)으로 정렬한 사람들 목록 조회")
    @Test
    void problem9() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --
        List<Member> result = query
                .selectFrom(member)
                .orderBy(member.age.asc())
                .fetch();
        // -- 끝 --
        for (Member member : result) {
            System.out.println(member);
        }
        assertThat(result).isSortedAccordingTo(Comparator.comparing(m -> m.getAge()));
    }

    @DisplayName("""
            연습 문제 10 
            * 오직 member 테이블만 사용해서 사람들이 속한 팀을 조회하기
            * 중복된 팀 id를 조회하지 않기
            """)
    @Test
    void problem10() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --
        List<Long> result = query
                .selectDistinct(member.team.id)
                .from(member)
                .fetch();
        // -- 끝 --
        for (Long teamId : result) {
            System.out.println(teamId);
        }
        assertThat(result.size()).isEqualTo(new HashSet<>(result).size());
    }

    /**
     * ExpressionUtils 활용
     */
    @DisplayName("연습 문제 11 : 사람들이 속한 팀의 id를 조회하고 각 팀에 소속된 사람들의 수를 구하라")
    @Test
    void problem11() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --
        List<Tuple> result = query
                .select(member.team.id, count(member.team))
                .from(member)
                .groupBy(member.team)
                .fetch();
        // -- 끝 --
        for (Tuple row : result) {
            System.out.println("team id : " + row.get(0, Long.class) + ", count : " + row.get(1, Long.class));
        }
    }

    @DisplayName("연습 문제 12 : 모든 사람들의 나이를 합한 것을 구하라")
    @Test
    void problem12() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --
        Integer sum = query
                .select(member.age.sum())
                .from(member)
                .fetchOne();
        // -- 끝 --
        System.out.println(sum);
    }

    @DisplayName("연습 문제 13 : 모든 사람들의 나이를 합한 것을 팀별로 구하라")
    @Test
    void problem13() {
        // 조건
        var query = new JPAQueryFactory(em);
        // -- 시작 --
        List<Tuple> result = query
                .select(member.age.sum(), member.team.id)
                .from(member)
                .groupBy(member.team)
                .fetch();
        // -- 끝 --
        for (Tuple row : result) {
            System.out.println("team id : " + row.get(1, Long.class) + ", sum : " + row.get(0, Long.class));
        }
    }


    @DisplayName("연습 문제 14 : 사람들의 평균 나이 구하기")
    @Test
    void problem14() {
        // -- 시작 --
        Double avg = query
                .select(member.age.avg())
                .from(member)
                .fetchOne();
        // -- 끝 --
        System.out.println(avg);
    }


    @DisplayName("연습 문제 15 : 사람들을 팀 정보를 포함해서 구하기")
    @Test
    void problem15() {
        // -- 시작 --
        List<Member> result = query
                .select(member)
                .from(member)
                .innerJoin(member.team, team)
                .fetchJoin()
                .fetch();
        // -- 끝 --
        for (Member member : result) {
            System.out.print(member + ", ");
            System.out.println(member.getTeam());
        }
    }

    @DisplayName("연습 문제 16 : 팀원 수가 3명 이상인 팀의 구성원을 구하기")
    @Test
    void problem16() {
        // -- 시작 --
        List<Member> result = query
                .select(member)
                .from(member)
                .where(member.team.id.in(
                        JPAExpressions
                                .select(team.id)
                                .from(member)
                                .innerJoin(member.team, team)
                                .groupBy(member.team)
                                .having(member.count().goe(3))
                ))
                .fetch();
        // -- 끝 --
        for (Member member : result) {
            System.out.println(member);
        }
    }

    @DisplayName("연습 문제 17 : 평균 나이가 30이하인 팀 구하기")
    @Test
    void problem() {
        // -- 시작 --
        List<Team> result = query
                .select(team)
                .from(member)
                .innerJoin(member.team, team)
                .groupBy(team)
                .having(member.age.avg().loe(30))
                .fetch();
        // -- 끝 --
        for (Team team : result) {
            System.out.println(team);
        }
    }
}
