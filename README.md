# querydsl_practice

### build.gradle 설정하기
[참고 블로그](https://velog.io/@juhyeon1114/Spring-QueryDsl-gradle-%EC%84%A4%EC%A0%95-Spring-boot-3.0-%EC%9D%B4%EC%83%81)

### 배운 내용 정리
1. `JPAQueryFactory` : 버전 4에 추가된 객체로서 쿼리를 생성하는데 도움을 준다.
2. `@QueryProjection` : dto 객체의 Q class 파일을 빌드하도록 선언하는 역할
3. `BooleanExpression` : where 조건에 사용하는 조건식을 표현한 객체로 메서드 체인을 이용한 조건 조립을 위해서 사용했음
4. `Predicate` : 조건식을 나타내는 인터페이스 타입으로 BooleanExpression이 해당 인터페이스를 상속하고 있다.
5. `JPAQuery<T>` : 쿼리를 나타내는 객체로 fetch() 관련 함수를 이용해서 쿼리를 동작시키거나 select, where, from 과 같은 메서드로 쿼리를 입력하는데 사용함.
6. `PageableExecutionUtils.getPage()` : Page<T> 타입을 리턴하기 위해서 사용하면 유용한 유틸 클래스
7. `BooleanBuilder` : where 조건에 쓰이는 조건을 동적으로 적용하기 위해서 사용하는 클래스
8. `JPAExpressions` : 서브쿼리를 이용하기 위해서 사용한 클래스
9. `CaseBuilder` : case when then 을 적용하기 위한 클래스
10. `Expressions.*constant()` : 상수를 표현하기 위한 방법*
11. `Expressions.*stringTemplate()` : sql function을 사용하기 위한 방법*

```java
Expressions.stringTemplate(
        "function('replace', {0}, {1}, {2})",
member.username, "member", "M"))
```

1. `Projections` 프로젝션을 dto로 표시할 때 사용함
    - 필드 주입 : field
    - setter 주입 : bean
    - 생성자 주입 : constructor
2. `ExpressionUtils` : 서브쿼리에 alias를 적용할 때 사용