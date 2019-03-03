package com.example.unit_04_assessment.Model;

import java.util.List;

public class EchinodermsList {

    private List<Echinoderm> message;

    public EchinodermsList(List<Echinoderm> echinodermResponseList) {
        this.message = echinodermResponseList;
    }

    public List<Echinoderm> getEchinodermResponseList() {
        return message;
    }
}
