package com.infogain.gcp.poc.service;

import com.infogain.gcp.poc.entity.OutboxEntity;
import com.infogain.gcp.poc.entity.OutboxStatusEntity;
import com.infogain.gcp.poc.entity.PNREntity;
import com.infogain.gcp.poc.model.OutboxModel;
import com.infogain.gcp.poc.model.OutboxStatusModel;
import com.infogain.gcp.poc.model.PNRModel;
import com.infogain.gcp.poc.repository.OutboxRepository;
import com.infogain.gcp.poc.repository.OutboxStatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OutboxService {

    @Value("${app.publish.end.point}")
    private String publishEndPoint;

    @Value("${app.publish.base.url}")
    private String baseUrl;

    @Autowired
    private OutboxStatusRepository outboxStatusRepository;

    @Autowired
    private OutboxRepository outboxRepository;

    @SuppressWarnings("all")
    @Transactional
    public OutboxModel saveOutboxModel(OutboxModel outboxModel){
        OutboxEntity outboxEntity = outboxModel.buildEntity();
        return outboxEntity.buildModel();
    }

    @SuppressWarnings("all")
    @Transactional
    public OutboxStatusModel saveOutboxStatusModel(OutboxStatusModel outboxStatusModel){
        OutboxStatusEntity outboxStatusEntity = outboxStatusModel.buildEntity();
        return outboxStatusEntity.buildModel();
    }

    public List<OutboxModel> findAllOutboxModelList(){
        log.info("find all PNREntity objects");
        Iterable<OutboxEntity> outboxEntities = outboxRepository.findAll();
        List<OutboxEntity> outboxStatusEntityList = IterableUtils.toList(outboxEntities);
        return outboxStatusEntityList.stream().map(OutboxEntity::buildModel).collect(Collectors.toList());
    }

    public List<OutboxStatusModel> findAllOutboxStatusModelList(){
        log.info("find all PNREntity objects");
        Iterable<OutboxStatusEntity> outboxStatusEntities = outboxStatusRepository.findAll();
        List<OutboxStatusEntity> outboxStatusEntityList = IterableUtils.toList(outboxStatusEntities);
        return outboxStatusEntityList.stream().map(OutboxStatusEntity::buildModel).collect(Collectors.toList());
    }
}