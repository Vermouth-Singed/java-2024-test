### 사용할 언어와 프레임워크
- Java 17 + Spring Boot

### JDK 17 을 선택한 이유
- OpenJDK 지원 종료 일정 여유 (https://access.redhat.com/ko/articles/6973017)
- JDK 11 버젼부터 HttpClient 지원
- JDK 21 버젼에 Virtual Thread 추가

### HttpURLConnection 사용 이유
- Java 에서 제공하는 표준 라이브러리, 추가 세팅 X
- HttpClient 예시가 훨씬 간결하지만 아직은 HttpURLConnection 이 권장되는 분위기
- 외부 라이브러리 (OkHttp, Unirest) 고려
```
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

try {
    URL url = new URL("http://localhost:8080/api/login");
    HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
    urlConn.setRequestMethod(HttpMethod.GET.name());
    urlConn.connect();

    BufferedReader bufferedReader = new BufferedReader(
      new InputStreamReader(urlConn.getInputStream())
    );
    StringBuilder sb = new StringBuilder();
    String line;

    while ((line = bufferedReader.readLine()) != null) {
        sb.append(line);
    }

    ObjectMapper objectMapper = new ObjectMapper();
    LoginResponseDTO result = objectMapper.readValue(
      sb.toString().replaceAll("null", "124"),//임의로 email 의 null 값을 변경
      LoginResponseDTO.class
    );

    log.info("출력 데이터 : [{}]", result.toString());
} catch (IOException e) {
    log.error(e.getMessage());
}
```

### 인터셉터 세팅
```
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
          .addInterceptor(new LoginInterceptor())
          .excludePathPatterns("/css/**", "/images/**", "/js/**", "/api/login");
    }
}

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler
    ) throws Exception {
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
```