package com.deep.testproject.setting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "setting")
public class Setting {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "setting_id")
    private int id;

    @Column(name = "offset")
    private String offset;

    @Column(name = "date_format")
    private String dateFormat;

    @Column(name = "pre_partition")
    private int noOfPreviousPartitionScan;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "field_id", referencedColumnName = "setting_id")
    private List<Fields> fields = new ArrayList<>();
}
