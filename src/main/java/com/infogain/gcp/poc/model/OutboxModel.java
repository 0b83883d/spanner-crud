package com.infogain.gcp.poc.model;

import com.google.cloud.Timestamp;
import com.infogain.gcp.poc.entity.OutboxEntity;
import lombok.*;
import org.apache.commons.beanutils.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"locator","version"})
public class OutboxModel {

    private String locator;
    private String version;
    private String parent_locator;
    private Timestamp created;
    private Timestamp data;

    @SneakyThrows
    public OutboxEntity buildEntity(){
        OutboxEntity outboxEntity = new OutboxEntity();
        BeanUtils.copyProperties(outboxEntity, this);
        return outboxEntity;
    }

}