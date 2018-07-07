package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.Random;

@CrossOrigin(origins = {"http://localhost:5678", "http://localhost:4200"})
@RestController
public class UserController {
    @PostMapping("/api/echo")
    public String echo(@RequestBody String input) {
        return "[\"" + "You said " + input + "\"]";
    }

    @GetMapping("/api/health")
    public String getHealth() {
        Random random = new Random();
        int i = random.nextInt(3);

        String[] array = {"running", "down", "standby"};
        return "[\"" + array[i] + "\"]";
    }
}