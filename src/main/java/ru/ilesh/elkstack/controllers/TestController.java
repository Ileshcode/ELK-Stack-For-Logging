package ru.ilesh.elkstack.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@Slf4j
public class TestController {




    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        log.info("Server status OK");
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/new")
    public ResponseEntity<String> postNew(@RequestBody String body) {
        log.debug("New request received: {}", body);
        log.trace("New request received: {}", body);
        log.info("New request received: {}", body);
        log.warn("New request received: {}", body);
        log.error("New request received: {}", body);

        return ResponseEntity.ok(body);
    }
}
