package com.infogain.gcp.poc.controller;

import com.infogain.gcp.poc.model.OutboxModel;
import com.infogain.gcp.poc.model.PNRModel;
import com.infogain.gcp.poc.service.OutboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class OutboxController {

    @Autowired
    private OutboxService outboxService;

    @PostMapping(value = "/outbox", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public OutboxModel saveOutboxModel(@RequestBody OutboxModel outboxModel){
        return outboxService.saveOutboxModel(outboxModel);
    }
/*
    @GetMapping(value = "/v1/pnrs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PNRModel> findAllPNRModelList(){
        return outboxService.findAllPNRModelList();
    }*/

}