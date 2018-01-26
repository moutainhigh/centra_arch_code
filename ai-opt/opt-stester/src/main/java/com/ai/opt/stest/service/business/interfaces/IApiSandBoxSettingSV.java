package com.ai.opt.stest.service.business.interfaces;

import com.ai.opt.stest.api.sandbox.param.APICallCase;
import com.ai.opt.stest.api.sandbox.param.APICallSetting;
import com.ai.opt.stest.model.ApiTemplate;

public interface IApiSandBoxSettingSV {

    void saveAPICallSetting(APICallSetting req,ApiTemplate apiTemplate);

    String mockTest(APICallCase callCase,String registryURL);
    
    
    void addAPICallSetting(APICallSetting req,ApiTemplate apiTemplate);

}
