package com.ifudata.centra.sdk.component.sequence.service;

public interface ISequenceService {

    Long nextValue(String sequenceName);

    void modifySequence(String sequenceName, long nextVal);

}
