### Spring Boot Mini Project: User Management System
#### 1. Introduction:
This mini-project is a User Management System built using Spring Boot. It aims to provide user registration, login, password reset functionality, and a dashboard displaying quotes fetched from a third-party REST API.

#### 2. Technologies Used:
- **Backend:** Spring Boot, Spring Data JPA
- **Frontend:** Thymeleaf, jQuery, AJAX
- **Database:** MySQL
- **Email Service:** JavaMailSender (SMTP)

---

## 3. Project Structure:
```
src/main/java
│── in.kunal
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   ├── binding

src/main/resources
│── templates (Thymeleaf HTML files)
│── static (CSS, JS)
│── application.properties
```

---

### 4. Dependencies Used:
1. Spring Web (Tomcat)
2. Spring Dev Tools
3. jQuery
4. MySQL Driver
5. Spring Data JPA
6. Thymeleaf
7. JavaMail

---

### 5. Functional Requirements:
1. **Registration:**
   - Dynamic country, state, and city dropdowns.
   - AJAX used for fetching state and city data based on the selected country.
   - Random password generation and email notification.

2. **Login:**
   - Users log in with a temporary password.
   - Redirects to a reset password page upon first login.

3. **Password Reset:**
   - Users must change the temporary password to a permanent one.

4. **Dashboard:**
   - Displays quotes fetched from a third-party REST API.

5. **Forgot Password:**
   - If a user forgets the password, they can reset it via email verification.

---

### 6. Java Classes:
#### a. Entities:
- User.java
- Country.java
- State.java
- City.java

#### b. Binding Classes:
- Registration.java
- ForgotPwd.java
- QuotesAPI.java
- Login.java

#### c. Repository Interfaces:
- UserRepo.java
- CountryRepo.java
- StateRepo.java
- CityRepo.java

#### d. Service Interface:
```java
public interface UserService {
    boolean saveUser(Registration registration);
    Registration loginUser(Login login);
    boolean forgotPassword(ForgotPwd forgotPwd);
    boolean isEmailDuplicate(String email);
    Map<Integer, String> getCountries();
    Map<Integer, String> getStates(Integer countryId);
    Map<Integer, String> getCities(Integer stateId);
}
```

---

### 7. Database Configuration:
```yaml
server:
  port: 9090
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/User
    username: root
    password: Kunal@123
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate.format_sql: true

mail:
  host: smtp.gmail.com
  username: virajprajapat854@gmail.com
  password: oofm zrxy rbwi ysnm
  properties.mail.smtp.auth: true
  properties.mail.smtp.starttls.enable: true
```

### 8. Views (Thymeleaf Templates):
- register.html
- login.html
- forgotpwd.html
- dashboard.html

---

### 9. AJAX Integration:
- Dynamic data fetching for country, state, and city dropdowns.
- Asynchronous requests to avoid page reloads.

### 10. Future Enhancements:
- Implement JWT for secure authentication.
- Enhance UI with Bootstrap.
- Use OAuth for secure email configuration.


