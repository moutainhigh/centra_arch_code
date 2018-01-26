package com.ifudata.centra.sdk.component.sequence.client.impl;

import com.ifudata.centra.sdk.component.sequence.client.ISeqClient;
import com.ifudata.centra.sdk.component.sequence.service.ISequenceService;
import com.ifudata.centra.sdk.component.sequence.service.impl.SequenceServiceImpl;

public class NormalSeqClientImpl implements ISeqClient {

    private ISequenceService sequenceService;

    public NormalSeqClientImpl() {
        this.sequenceService = new SequenceServiceImpl();
    }

    @Override
    public Long nextValue(String sequenceName) {
        return sequenceService.nextValue(sequenceName);
    }

}
