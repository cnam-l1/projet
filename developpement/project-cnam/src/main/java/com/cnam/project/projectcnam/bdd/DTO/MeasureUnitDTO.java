package com.cnam.project.projectcnam.bdd.DTO;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Developed by Hugo Seban
 * Date : 16/06/2018
 * email : hugoseban@icloud.com
 */

@Entity
@Table(name = "mesure_unit")
@EntityListeners(AuditingEntityListener.class)
public class MeasureUnitDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesure_unit")
    private Long idMesureUnit;

    @NotBlank
    private String name;

    public MeasureUnitDTO() {
    }

    public MeasureUnitDTO(Long idMesureUnit, @NotBlank String name) {
        this.idMesureUnit = idMesureUnit;
        this.name = name;
    }

    public Long getIdMesureUnit() {
        return idMesureUnit;
    }

    public void setIdMesureUnit(Long idMesureUnit) {
        this.idMesureUnit = idMesureUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
