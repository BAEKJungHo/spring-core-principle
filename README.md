# 스프링 핵심 원리

> [인프런, 스프링 핵심 원리](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8)

## 스프링의 등장 배경

2000년대 초반에 EJB(Enterprise Java Beans)가 대세였는데 EJB의 장점은 현재 스프링이 지원하는 선언적 트랜잭션, JPA 기술 등 여러가지가 있었지만 복잡하고 비싸고 느리다는것이었다.

그래서 나타난게 스프링과 Hibernate 이다.

> EJB 엔티티빈 - Hibernate - JPA(표준 인터페이스) 
>
> JPA 구현체로는 Hibernate 가 80% 이상이다.

스프링은 `로드 존슨`이 2002년 출간한 책에 3만줄 이상되는 예제를 통해 현재 스프링의 기반이 되는 ApplicationContext, BeanFactory, DI 등의 기술을 사용하여 EJB 없이 프로젝트를 할 수 있다는 걸 보여줬고, 책 출간 직후 `유겐 휠러` 와 `얀 카로프` 가 로드 존슨에게 오픈소스를 제안한다.

## 스프링 릴리즈

- 2003년 스프링 프레임워크 1.0 출시 - XML
- 2006년 스프링 프레임워크 2.0 출시 - XML 편의 기능 지원
- 2009년 스프링 프레임워크 3.0 출시 - 자바 코드로 설정
- 2013년 스프링 프레임워크 4.0 출시 - 자바 8
- 2014년 스프링 부트 1.0 출시 
- 2017년 스프링 프레임워크 5.0, 스프링 부트 2.0 출시 - 리액티브 프로그래밍 지원
- 2020년 스프링 프레임워크 5.2.X, 스프링 부트 2.3.X 출시

## 스프링 핵심 컨셉

- 스프링은 자바 언어 기반 프레임워크
- 자바 언어의 가장 큰 특징 - `객체지향`
- 스프링은 `객체지향언어`가 가진 강력한 특징을 살려내는 프레임워크
- 스프링은 `좋은 객체 지향` 애플리케이션을 개발할 수 있도록 도와주는 프레임워크

## 좋은 객체지향 프로그래밍 이란?

- 객체 지향 프로그래밍은 컴퓨터 프로그램을 명령어의 목록으로 보는 시각에서 벗어나 여러개의 독립된 단위, 즉 "객체"들의 `모임`으로 파악하고자 하는 것이다. 각각의 객체는 `메시지`를 주고받고, 데이터를 처리할 수 있다. (`협력`)
- 객체 지향 프로그래밍은 프로그램을 `유연`하고 `변경`이 용이하게 만들기 때문에 대규모 소프트웨어 개발에 많이 사용된다.
  - 유연하고 변경에 용이하다는 것은? 
    - 컴퓨터 부품을 갈아 끼우듯이 컴포넌트를 쉽고 유연하게 변경하면서 개발할 수 있어야 한다.
    - 따라서 가장 중요한 객체지향의 특징은 `다형성(polymorphism)` 이다.
    
## 다형성(polymorphism) = 객체지향의 

### 역할(interface)과 구현(implementation)

- 역할(interface)과 구현(implementation)으로 구분
  - ex) 운전자(역할) - 자동차(역할) - 자동차(구현)
    - 운전자(클라이언트)는 자동차 역할에 의존하지 구현에 의존하지 않는다.
    - 핵심은 자동차가 많은 구현을 할 수 있다는 것이 아니라, `어떠한 자동차가 나와도 클라이언트에 영향을 주지않고 새로운 기능을 추가할 수 있다는 것이다`. 
  - ex) 로미오(역할) - 줄리엣(역할) ... 로미오(원빈, 장동건, 정우성 등), 줄리엣(송혜교, 김다미, 박소담 등)
    - 로미오와 줄리엣은 배우가 될 수도 있고, 어떤 다른 사람이 와도 상관없다. 즉, 대체 가능해야한다.
- 역할과 구현으로 세상을 구분했을 때의 장점
  - 클라이언트는 대상의 역할(인터페이스)만 알면 된다.
  - 클라이언트는 구현 대상의 내부 구조를 몰라도 된다.
  - 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향을 받지 않는다.
  - 클라이언트는 구현 대상 자체를 변경해도 영향을 받지 않는다.
- 객체를 설계할 때 `역할`과 `구현`을 명확하게 분리해야한다.
- 객체 설계 시 역할을 먼저 부여하고, 그 다음 그 역할을 수행하는 구현을 만든다.

### 객체의 협력이라는 관계부터 생각

- 혼자있는 객체는 없다.
  - 다형성을 공부하면서 이런 생각을 할 수가 있다. 부모(Interface)가 있고 그걸 구현한 구현체들이 있는데 클라이언트는 없네? 라고 생각할 수 있는데, 클라이언트는 요청하는 사람, 서버는 응답하는 사람이라고 생각할 수 있다.
- 클라이언트 : 요청, 서버: 응답
- 수 많은 클라이언트와 서버는 서로 협력 관계를 가진다.

### 오버라이딩

- 다형성으로 인터페이스를 구현한 객체를 실행 시점에서 유연하게 변경할 수 있다. 
  - ex) 추상 팩토리 패턴과 전략패턴을 사용한 경우
  
### 다형성의 본질
 
- 다형성으로 인터페이스를 구현한 객체를 실행 시점에서 유연하게 변경할 수 있다. 
  - 따라서 인터페이스를 잘 설계하는 것이 중요하다.
- 다형성의 본질을 이해하려면 `협력`이라는 객체 사이의 관계에서 시작해야한다.
- `클라이언트를 변경하지 않고 서버 기능을 유연하게 변경할 수 있다.`

```java
public class UserService {
  
  // private UserRepository userRepository = new UserJoinRepository();
  private UserRepository userRepository = new UserFindRepository();
  
}
``` 

위 코드에서 클라이언트는 UserService 가 되며, 서버는 UserRepository(역할) 가 된다. 구현은 UserJoinRepository 와 UserFindRepository 이다.

- MailService (역할)
  - sendMail() (추상메서드)
  - MailExternalService(외부망전용)
  - MailInternalService(내부망전용)
  
```java
public class MailVO {

  private String uniqueNo; // 사번 및 회원 ID
  private String title; // 제목
  private String content; // 내용
  
  // 생략
  
}
```

```java
@Controller
public class MailController {

  @PostMapping("/sendMail")
  public String sendMail(MailVO mailVO) {
      // 실행 시점에 클라이언트를 변경하지 않고 서버의 기능을 유연하게 변경할 수 있다.
      MailService mailService = MailServiceFactory.findMailService(mailVO);
      mailService.sendMail();
      // 생략
  }

}
```

여기서 클라이언트는 MailController 이며 역할은 MailService 구현은 MailExternalService 와 MailInternalService 이다. 추상 팩토리 패턴을 통해서 mailVO 안에 있는 uniqueId 를 통해서

MailServiceFactory.findMailService 내부에서는 findEmployee 메서드를 실행한다. (where uniqueId = #uniqueId#) 만약에 findEmployee 의 결과가 null 이면 외부망이고 null 이 아니면 내부망
이라고 판단해서 메일을 발송한다.

## 스프링과 다형성

- 스프링은 다형성을 극대화하여 이용할 수 있게 해준다.
- 스프링의 IoC, DI 는 다형성을 활용해서 역할과 구현을 편리하게 다룰 수 있도록 해준다.
- 스프링을 사용하면 구현을 편리하게 변경할 수 있다.

> 즉, 스프링의 핵심은 좋은객체지향 프로그래밍을 할 수 있게 도와주는 도구이며 객체지향의 꽃은 다형성이고, 따라서 스프링에서 가장 중요한 요소는 IoC, DI 이며, 스프링은 다형성을 편리하게 사용할 수 있도록 해주는 도구이다.
