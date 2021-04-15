package com.infogain.gcp.poc.entity;

import com.google.cloud.Timestamp;
import com.infogain.gcp.poc.model.OutboxModel;
import lombok.*;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Column;
import org.springframework.cloud.gcp.data.spanner.core.mapping.PrimaryKey;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"locator", "version"})
@Table(name = "outbox")
public class OutboxEntity {

    @PrimaryKey(keyOrder = 1)
    @Column(name = "locator")
    private String locator;

    @PrimaryKey(keyOrder = 2)
    @Column(name = "version")
    private String version;

    @Column(name = "parent_locator")
    private String parent_locator;

    @Column(name = "created")
    private Timestamp created;

    @Column(name = "data")
    private Timestamp data;

    @SneakyThrows
    public OutboxModel buildModel(){
        OutboxModel outboxModel = new OutboxModel();
        BeanUtils.copyProperties(outboxModel, this);
        return outboxModel;
    }
}
