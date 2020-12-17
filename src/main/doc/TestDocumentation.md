# Test Code 작성 방법

* 테스트는 Junit5 로 단위테스트
* @SpringBootTest 는 스프링 라이브러리가 많아질 수록 속도가 느리다
* Junit 단위테스트는 순수한 자바로 테스트하는 것이기 때문에 속도가 빠르다.

* 메서드명 위에 alt+insert 를 입력하면 Test 메서드를 만들 수 있다. (Junit5 선택)

* 테스트는 성공 테스트도 중요 하지만 실패 테스트도 중요하다.

* @DisplayName("VIP 는 10% 할인이 적용되어야 한다.") vs @DisplayName("VIP 가 아니면 할인이 적용되지 않아야 한다.")
* @DisplayName 을 통해서 내가 어떠한 테스트를 했는지 한눈에 볼 수 있다.

* 테스트는 `given / when / then` 형식으로 하면 편하다. (`given, when, then 은 스폭(spock)의 블록 레이블이다.`)
  * Junit 은 부분적으로 분리된 표현 방법이 없기 때문에 spock 에 비해서 가독성이 떨어진다. 이 문제를 해결하기 위해서 JUnit 에서도 스폭의 레이블을 참고해서 테스트를 작성한다.
  * http://spockframework.org/spock/docs/1.1/spock_primer.html
  * setup(given 은 별칭) : ~ 환경이 주어졌을 때 (테스트의 전제 조건인 데이터베이스의 상태 등을 작성한다.)
  * when : ~ 이렇게 했을 때 (테스트 대상의 메서드를 호출하는 위치 등 테스트에 대한 작용을 작성한다.)
  * then : ~ 이렇게 된다 (테스트 대상의 메서드를 호출한 결과의 어설션(assertion, 표명)을 작성한다.)

* Assertions
* Assertions.assertThat(member).isEqualTo(findMember); 처럼 쓰는 것보단 static 을 import 해서 아래 처럼 사용하는게 낫다.
* import static org.assertj.core.api.Assertions.assertThat;
* assertThat(discount).isEqualTo(1000);

* BeforeEach 는 @Test 를 실행하기 전에 무조건 실행한다.
