package be.pxl.services.controller;

import be.pxl.services.domain.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
@Slf4j
public class NotificationController {

    @PostMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void send(@RequestBody NotificationRequest request) {
        log.info("Received notification for employee {}: {}", request.getEmployeeId(), request.getMessage());
        // Hier kun je later echte e-mail/SMS/.. logica toevoegen
    }
}

