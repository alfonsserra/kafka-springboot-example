package com.systelab.kafka.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.UUID;

@XmlRootElement

@Entity
@Data
@NoArgsConstructor
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @ApiModelProperty(notes = "The database generated tenant ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Size(min = 1, max = 255)
    private String name;

    @Size(min = 1, max = 255)
    private String nameSpace;


    @ManyToOne
    @JoinColumn(name = "customertype_fk", referencedColumnName = "id", nullable = false)
    private CustomerType type;
}