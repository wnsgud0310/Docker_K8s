package com.example.factorialcacheapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialCacheController {

    /**
     * K8S ConfigMap 객체에서 설정된 language 환경변수
     */
    @Value("${APP_LANGUAGE}")
    private String language;
    /**
     * K8S secret 객체 생성 명령문을 참조
     */

    @Value("$API_KEY")
    private String apiKey;

    // http://localhost/factorial/10&key=123
    @GetMapping("/factorial/{n}")
    public String calculateFactorial(@PathVariable("n") int number,
                                     @RequestParam(value = "key", required = false) String key) {

        if (number > 10) {
            if (!apiKey.equals(key)) {
                throw new IncorrectApiKeyException("Incorrect API Key" + apiKey
                );
            }
        }

        return switch (language) {
            case "ko" -> number + " 팩토리얼은 " + number + " 입니다.";
            case "en" -> "the factorial of " + number + " is " + number;
            default -> "Unknown language.";
        };
    }


}

