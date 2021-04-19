package com.infogain.gcp.poc.controller;

import com.infogain.gcp.poc.model.OutboxModel;
import com.infogain.gcp.poc.service.OutboxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping(value = "/")
public class OutboxController {

    @Autowired
    private OutboxService outboxService;

    @GetMapping(value="/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String index() {
        return "This is Home page";
    }

    @PostMapping(value = "/createOutboxRecord", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public OutboxModel saveOutboxModel(@RequestBody OutboxModel outboxModel){
        log.debug("Received Outbox Model {}",outboxModel.toString());
        return outboxService.saveOutboxModel(outboxModel);
    }

}