package com.ai.opt.stest.sandbox.dubbo;

public class RegistryCenterFactory {

    public static RegistryCenter getRegistryCenter(String registryCenter) {
        RegistryCenter.clear(registryCenter);
        RegistryCenter instance = RegistryCenter.getInstance(registryCenter);
        instance.start();
        return instance;
    }

}
