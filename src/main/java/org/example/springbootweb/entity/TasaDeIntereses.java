package org.example.springbootweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Audited
@Table(name="tasa_de_intereses")
public class TasaDeIntereses {
    @Id
    private Long id;

    @Column(name="interes_code")
    private String interesCode;

    @Column(name="interes_monto")
    private String interesMonto;

    public TasaDeIntereses() {
    }

    public TasaDeIntereses(Long id, String interesCode, String interesMonto) {
        this.id = id;
        this.interesCode = interesCode;
        this.interesMonto = interesMonto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInteresCode() {
        return interesCode;
    }

    public void setInteresCode(String interesCode) {
        this.interesCode = interesCode;
    }

    public String getInteresMonto() {
        return interesMonto;
    }

    public void setInteresMonto(String interesMonto) {
        this.interesMonto = interesMonto;
    }
}
