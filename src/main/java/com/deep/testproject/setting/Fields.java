package com.deep.testproject.setting;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fields")
public class Fields {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "source_col")
    private String sourceCol;

    @Column(name = "dest_col")
    private String destCol;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "setting_id")
    private Setting setting;

}
