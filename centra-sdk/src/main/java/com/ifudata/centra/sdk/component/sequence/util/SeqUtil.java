package com.ifudata.centra.sdk.component.sequence.util;

import com.ifudata.centra.sdk.component.sequence.factory.SeqClientFactory;
import com.ifudata.centra.sdk.util.StringUtil;

public final class SeqUtil {

    private SeqUtil() {

    }

    public static Long getNewId(String seqName) {
        return SeqClientFactory.getSeqClient().nextValue(seqName);
    }

    public static String getNewId(String seqName, int seqLen) {
        Long newId = getNewId(seqName);
        String seqStr = StringUtil.toString(newId);
        while (seqStr.length() < seqLen) {
            seqStr = "0000000" + seqStr;
        }
        return seqStr.substring(seqStr.length() - seqLen);
    }

}
