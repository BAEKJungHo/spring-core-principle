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
    
## 다형성(polymorphism) = 객체지향의 꽃 

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
위 코드는 다형성을 제대로 활용하지 못한 사례이다. Repository 구현체를 바꾸기 위해서는 클라이언트의 코드를 수정해야한다.

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

> 즉, 스프링의 핵심은 좋은 객체지향 프로그래밍을 할 수 있게 도와주는 도구이며 객체지향의 꽃은 다형성이고, 따라서 스프링에서 가장 중요한 요소는 IoC, DI 이며, 스프링은 다형성을 편리하게 사용할 수 있도록 해주는 도구이다.

## 좋은 객체 지향 설계 원칙 : SOLID

- SRP(Single Resposibility Principle, 단일 책임 원칙)
- OCP(Open/Closed Principle, 개방 폐쇄 원칙) : 가장 중요한 원칙 1.
- LSP(Liskov Substitution Principle, 리스코프 치환 원칙)
- ISP(Interface Segregation Principle, 인터페이스 분리 원칙)
- DIP(Dependency Inversion Principle, 의존관계 역전 원칙) : 가장 중요한 원칙 2.

### SRP

- 한 클래스는 하나의 책임만 져야 한다.
- 하나의 책임이라는 것은 모호하다. (문맥과 상황에 따라 다르다.)
- `중요한 기준은 변경`이다. 변경이 있을때 파급 효과가 작으면 단일 책임 원칙을 잘 따른 것.
- ex) UI 변경, 객체의 생성과 사용을 분리

### OCP

- 소프트웨어 요소는 `확장(새로운 기능 추가)에는 열려` 있어야 하며, `변경(기존 코드의 변경)에는 닫혀` 있어야 한다.
  - 즉, 기존 코드의 변경 없이 새로운 기능을 추가
  - 인터페이스를 구현한 새로운 클래스를 만들어 새로운 기능을 구현
- 다형성 활용
- UserService 클라이언트가 구현 클래스를 직접 선택
  - 기존 코드의 변경이 일어남
  - 구현 객체를 변경하기 위해서 기존 코드를 변경해야함
  - 다형성을 사용했지만 OCP 를 지키지 못함
- 해결 방법
  - `객체를 생성하고 연관 관계를 맺어주는 별도의 조립 설정자가 필요함`
  
```java
public class UserService {
  
  // private UserRepository userRepository = new UserJoinRepository();
  private UserRepository userRepository = new UserFindRepository();
  
}
```

### LSP

- 프로그램 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
- 다형성에서 하위 클래스는 `인터페이스 규약`을 다 지켜야한다. 다형성을 지원하기 위한 원칙. 
- 인터페이스를 구현한 구현체를 믿고 사용하려면 이 원칙이 필요하다.
- 단순히 컴파일 성공하는 것을 넘어서는 이야기
- ex) 자동차 엑셀은 앞으로 가야함. 뒤로 가게 만들면 LSP 원칙 위반. 느리더라도 앞으로 가야 함.

### ISP

- 특정 클라이언트를 위한 여러개의 인터페이스가 하나의 범용 인터페이스보다 낫다.
- 자동차 인터페이스 -> 운전 인터페이스, 정비 인터페이스로 분리
- 사용자 인터페이스 -> 운전자 클라이언트, 정비사 클라이언트로 분리
- 인터페이스를 분리하면 정비 인터페이스가 변경되어도 운전자에게 영향을 미치지 않음
- `인터페이스가 명확해지고 대체 가능성이 높아진다.`

### DIP

- 프로그래머는 `추상화에 의존해야지 구체화에 의존하면 안된다.`
  - 즉, 구현체에 의존하지 말고 인터페이스에 의존하라는 의미
  - 앞서 말한, `역할에 의존하게 해야한다는 것`과 같다.
  - 역할과 구현을 철저하게 분리 해야 한다.

```java
public class UserService {
  
  // private UserRepository userRepository = new UserJoinRepository();
  private UserRepository userRepository = new UserFindRepository();
  
}
```

UserService 는 인터페이스에 의존하지만 구현 클래스에도 동시에 의존한다. `클라이언트가 구현체를 직접 선택 : DIP 위반`

> 다형성 만으로는 OCP, DIP 를 지킬 수 없다.

## 객체지향설계와 스프링

- 스프링은 DI(Dependency Injection, 의존관계 주입, 의존성 주입)를 통해 `다형성 + OCP, DIP` 를 지원
- 클라이언트 코드 변경 없이 쉽게 기능 확장

순수하게 자바로 OCP, DIP 를 지키면서 만들다 보면 결국엔 스프링 프레임워크 DI 컨테이너를 만들게 된다.

> 인터페이스를 먼저 다 만들어 놓고 구현체를 만들게 되면 장점이, 기술 선택을 미룰 수 있다. 예를 들어 JDBC 를 쓸건지 JPA 를 쓸건지 안 정해졌어도 나중에 JDBCRepository or JPARepository
구현체를 만들어 사용하면된다.

## 실무

- 인터페이스를 도입하면 추상화라는 비용이 발생한다. (성능 문제는 아님)
  - 런타임시에 구체클래스가 선택되는데 클릭해서 들어가면 인터페이스만 있기 때문에 한번 더 들어가야 구체클래스가 뭔지 알 수 있다.
- 기능을 확장할 가능성이 없다면, 구체 클래스를 직접 사용하고, 향후 꼭 필요할 때 리팩토링해서 도입하는 것도 방법이다.

## 다이어그램

프로젝트 개발에 앞서 보통 3가지를 먼저 작성하는데 `도메인 협력관계`, `클래스 다이어그램`, `객체 다이어그램`

- 도메인 협력 관계
  - 기회자들도 볼 수 있음
- 클래스 다이어그램
  - 클래스 간의 관계 (정적)
- 객체 다이어그램
  - 실제로 new 로 만들어서 이루어지는 객체간의 다이어그램 (동적)
  
## IoC(Inversion of Control)

- IoC(Inversion of Control, 제어의 역전)
  - 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것을 제어의 역전(IoC)이라고 한다.

```java
@RequiredArgsConstructor
@RequestMapping("/user")
@Controller
public class UserController {

  /**
   * @Resource(name = "userService")
   * private UserService userService;
   *
   * @Autowired
   * private UserService userService;
   */
   
   private final UserService userService;
   
   public String join(User user) {
      // 생략
      userService.join(user);
      // 생략
   }

}
```

위 코드에서 UserController 는 UserService 에 어떤 구현 객체가 들어오고 의존성이 주입되는지 알지도 못한체 묵묵하게 자신이 할 일을 수행할 뿐이다. 이렇게 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것을 제어의 역전(IoC) 라고한다.

위 코드에서 프로그램의 제어 흐름을 제어하는 곳은 `DI 컨테이너`가 담당한다.

> 프레임워크 VS 라이브러리
>
> 프레임워크가 내가 작성한 코드를 제어하고, 대신 실행하면 그것은 프레임워크가 맞다. (JUnit)
> 
> 반면에 내가 작성한 코드가 직접 제어의 흐름을 담당한다면 그것은 프레임워크가 아니라 라이브러리다.

## DI(Dependecy Injection, 의존 관계 주입)

의존성 주입, 의존 관계 주입이라는 말이 있는데 `의존관계 주입`이라는 말이 더 와닿는다. 왜냐하면 의존은 객체들끼리의 관계가 중요하기 때문이다.

IoC 예제에서 UserController 는 UserService 인터페이스에 의존한다. 실제 어떤 구현 객체가 사용될지는 모른다.

- 의존관계는 `정적인 클래스 의존 관계와, 실행 시점에 결정되는 동적인 객체(인스턴스) 의존 관계` 둘을 분리해서 생각해야 한다.

### 정적인 클래스 의존 관계

클래스가 사용하는 import 코드만 보고 의존 관계를 쉽게 판단할 수 있다. 정적인 의존관계는 애플리케이션을 실행하지 않아도 분석할 수 있다.

UserController 는 UserService 인터페이스에 의존한다. (import 를 보면 알 수 있다.) 그런데 이러한 클래스 의존 관계 만으로는 실제 어떤 객체가
주입되는지 알수 없다.

### 동적인 객체 인스턴스 의존 관계

애플리케이션 실행 시점에 실제 생성된 객체 인스턴스의 참조가 연결된 의존 관계다.

- 애플리케이션 실행 시점(런타임)에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결 되는 것을 의존관계 주입이라 한다.
- 객체 인스턴스를 생성하고, 그 참조값을 전달해서 연결된다.
- 의존관계 주입을 사용하면 클라이언트 코드를 변경하지 않고, 클라이언트가 호출하는 대상의 타입 인스턴스를 변경할 수 있다.
- 의존관계 주입을 사용하면 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경할 수 있다.

## IoC 컨테이너, DI 컨테이너

- IoC 컨테이너, DI 컨테이너
  - AppConfig 처럼 객체를 생성하고 관리하면서 의존관계를 연결해 주는 것을
  - IoC 컨테이너 또는 DI 컨테이너라 한다.
  - 의존관계 주입에 초점을 맞추어 `최근에는 주로 DI 컨테이너`라 한다.
  - 또는 어샘블러, 오브젝트 팩토리 등으로 불리기도 한다.

## 스프링 컨테이너(ApplicationContext)

- ApplicationContext 를 스프링 컨테이너라 한다.
- ApplicationContext 는 인터페이스이다.
- 스프링 컨테이너는 XML을 기반으로 만들 수 있고, 애노테이션 기반의 자바 설정 클래스로 만들 수 있다. 직전에 AppConfig 를 사용했던 방식이 애노테이션 기반의 자바 설정 클래스로 스프링 컨테이너를 만든 것이다.

- 자바 설정 클래스를 기반으로 스프링 컨테이너(ApplicationContext)를 만들어보자.
  - new AnnotationConfigApplicationContext(AppConfig.class);
  - 이 클래스는 ApplicationContext 인터페이스의 구현체이다.

> 참고: 더 정확히는 스프링 컨테이너를 부를 때` BeanFactory, ApplicationContext` 로 구분해서 이야기
한다. 이 부분은 뒤에서 설명하겠다. BeanFactory 를 직접 사용하는 경우는 거의 없으므로 일반적으로
ApplicationContext 를 스프링 컨테이너라 한다.

- AppConfig 
  - `@Configuration` 어노테이션을 이용해서 설정 파일임을 나타내고 `@Bean` 어노테이션을 이용해서 스프링 컨테이너에 빈으로 등록해준다.
  
```java
/**
 * AppConfig.java
 * 애플리케이션에 대한 전반적인 동작 방식(환경 설정)
 * 구현 객체 생성 담당 및 생성자를 통한 주입
 */
@Configuration
public class AppConfig {

    /**
     * @Bean 어노테이션은 name 속성을 따로 지정하지 않으면
     * Ex) @Bean(name="memberService2")
     * default 로 메서드명을 name 으로 지정한다.
     */
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
```

> 주의: 빈 이름은 항상 다른 이름을 부여해야 한다. 같은 이름을 부여하면, 다른 빈이 무시되거나, 기존 빈을
덮어버리거나 설정에 따라 오류가 발생한다.

- MemberApp.java 

아래 코드를 관심있게 보면 된다. ApplicationContext 는 ac 라는 네이밍으로도 자주 사용

```java
// AppConfig 에 Bean 으로 등록되어있는 애들을 스프링 컨테이너에 넣어서 관리해준다.
// 스프링 컨테이너는 파라미터로 넘어온 설정 클래스 정보를 사용해서 스프링 빈을 등록한다.
ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
MemberService memberService = ac.getBean("memberService", MemberService.class); // memberService 는 Bean 으로 등록된 메서드 이름
```        
        

```java
public class MemberApp {

    public static void main(String[] args) {
        // pure java version
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // spring version
        // AppConfig 에 Bean 으로 등록되어있는 애들을 스프링 컨테이너에 넣어서 관리해준다.
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class); // memberService 는 Bean 으로 등록된 메서드 이름

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(findMember.getName());
        System.out.println(member.getName());

    }

}
```

## 스프링 컨테이너의 의존성 주입 단계

### 1. 스프링 컨테이너 생성

[img1](../tree/main/images/1.JPG)
