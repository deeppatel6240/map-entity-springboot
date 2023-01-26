package com.deep.testproject.setting;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "setting")
public class Setting {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "setting_id")
    private Long id;

    @Column(name = "offset")
    private String offset;

    @Column(name = "date_format")
    private String dateFormat;

    @Column(name = "pre_partition")
    private int noOfPreviousPartitionScan;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "setting_id")
    private List<Fields> fields;
}
