package com.ifudata.centra.sdk.component.sequence.datasource;

import com.ifudata.centra.sdk.exception.SdkException;


public final class SeqDataSourceLoaderFactory {
    
    private SeqDataSourceLoaderFactory(){
        
    }

    private static SeqDataSourceLoader dsLoader;

    public static void init(SeqDataSourceLoader loader) {
        dsLoader = loader;
    }

    public static SeqDataSourceLoader getSeqDsLoader() {
        if (dsLoader == null) {
            throw new SdkException("未初始化SEQ数据源");
        }
        return dsLoader;
    }

}
