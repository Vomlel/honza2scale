package net.toscalecz.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {

    @GetMapping("/test")
    public String foo() {
        System.out.println("foo");
        return "foo";
    }

}
