# example implemenation of [ff4j](http://ff4j.org/)

## docs
- [wiki](https://github.com/ff4j/ff4j/wiki)
- [javadocs](http://ff4j.org/javadocs/1.8.5/)
- [store technologies](https://github.com/ff4j/ff4j/wiki/Store-Technologies)
- [flipping strategies](https://github.com/ff4j/ff4j/wiki/Flipping-Strategies)
- [AOP](https://github.com/ff4j/ff4j/wiki/Advanced-Concepts#aspect-oriented-programming)
 
## Web console activation
- gradle bootRun
- hit this [link](http://localhost:8080/ff4j-web-console/)
- use stanard oe admin acct to login 

## Store Schema
- [Spring JDBC](https://github.com/ff4j/ff4j/wiki/Store-Technologies#springjdbc)
- see sql scripts at src/main/sql
- loaded via [flyway](https://flywaydb.org/)

## security
- [Srping](https://spring.io/projects/spring-security)
- [jdbc backed user store](https://www.websparrow.org/spring/spring-security-jdbc-authentication-with-spring-boot)
- [custom user detail service](https://www.javadevjournal.com/spring/spring-security-userdetailsservice/)

## jpa stuff...
- [linked tables](https://attacomsian.com/blog/spring-data-jpa-one-to-many-mapping)
- [lombok and jpa/hibernate](https://thorben-janssen.com/lombok-hibernate-how-to-avoid-common-pitfalls/)