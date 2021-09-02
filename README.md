-- --
# 방신호 MathFlat Kotlin 과제 제출
-- --
# Requirements
-- --
## Functional

기능적 요구 사항은 아래 내용들과 추가로 필요하다고 생각되는 기능들까지 자유롭게 개발합니다.

* 학생을 추가할 수 있다.
* 학생을 삭제할 수 있다.
* 과목을 추가할 수 있다.
* 과목을 삭제할 수 있다.
* 특정 과목에 대해 학생의 점수를 추가할 수 있다.
* 특정 과목에 대해 학생의 점수를 수정할 수 있다.
* 특정 과목에 대해 학생의 점수를 삭제할 수 있다.
* 특정 학생에 대해 평균 점수를 조회할 수 있다.
* 특정 과목에 대해 전체 학생들의 평균 점수를 조회할 수 있다.

## Non-functional

과제는 Spring Boot 를 사용해야만 합니다.

#### Common

* 관계형 데이터베이스를 사용해서 개발해주세요
* REST API 형식으로 개발해주세요
* 다른 사람이 읽기 좋은 코드로 개발해주세요
* 오류 사항을 최소화하고, 기능적 예외사항에 대해 사용자가 이해하기 쉽게 처리해주세요 (ex. 존재하지 않는 학생 삭제)

#### Spec

* [Kotlin](https://kotlinlang.org/)
* [Spring Boot 2.x](https://spring.io/projects/spring-boot) 이상 버전 사용

-- --
# Project Spec
- java 11
- gradle 11
- spring-boot 2.5.4
- use `lombok`
- use `h2` database > jpa (kotlin plugin.jpa 1.5.21)
-- --

# Code
## Package Structure
- com.senob.mathflat
    - controller : api 통신 컨트롤러
    - domain : jpa entity
    - dto : Request & Response 에 사용 되는 Dto
    - handler : exception 처리 핸들러
    - repository : JPA Persistence
    - service : Business Layer

## Resources
- application.yml : Spring Boot 기본 설정
- data.sql : db sample data
- ddl.sql : db ddl sql
- erd.png : db erd image

-- --
# Install & Excute
-- --
## Install
```
$ git clone https://github.com/mathflat-dev/20210819_seno-b.git
```
## Build
```
$ ./gradlew clean
$ ./gradlew build 
```

## Run
- build 아래 명령어 Run 진행
```
$ java -jar ./build/libs/20210819_seno-b-1.0.jar 
```
