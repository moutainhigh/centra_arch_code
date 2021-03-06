package com.ifudata.ic.sdk.test.paas.ccs;

//import com.ai.opt.sdk.components.ccs.CCSClientFactory;
//import com.ai.opt.sdk.constants.SDKConstants;
//import com.ai.paas.ipaas.ccs.IConfigClient;

//public class CCSTest {
//
//    private IConfigClient client;
//
//    @Before
//    public void initData() {
//        this.client = CCSClientFactory.getDefaultConfigClient();
//    }
//
////    @Ignore
//    @Test
//    public void testGetConfig() throws Exception {
//        client.add("/test", "test");
//        assertEquals("test", client.get("/test"));
//        System.out.println("aaaaaa");
//    }
//
////    @Ignore
//    @Test
//    public void addServiceIdPwdMap() throws ConfigException {
//    	String cachesnsConfig = "{\"MCS003\":\"" + "123456"     
//    			+ "\",\"MCS002\":\"" + "123456"
//    			+ "\",\"MDS001\":\"" + "123456"
//    			+ "\",\"DSS001\":\"" + "123456"
//    			+ "\"}";
//        
//        // paas serviceid password 映射配置
//        if (!client.exists(SDKConstants.PAAS_SERVICE_PWD_MAPPED_PATH))
//            client.add(SDKConstants.PAAS_SERVICE_PWD_MAPPED_PATH,
//                    cachesnsConfig);
//        else {
//            client.modify(SDKConstants.PAAS_SERVICE_PWD_MAPPED_PATH,
//                    cachesnsConfig);
//        }
//    }
//    
////    @Ignore
//    @Test
//    public void addMcsConfig() throws ConfigException {
//        // 缓存服务主机
//        String mcs002 = "MCS003";
//        // 缓存空间
//        String cachesnsConfig = "{\"com.ifudata.dvp.pay.cache.paytenantinfo\":\"" + mcs002
//                + "\",\"com.ifudata.dvp.pay.cache.payterminalorgrel\":\"" + mcs002 + "\"}";
//        
//        
//
//        // 缓存空间配置
//        if (!client.exists(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH))
//            client.add(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH,
//                    cachesnsConfig);
//        else {
//            client.modify(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH,
//                    cachesnsConfig);
//        }
//    }
////    @Ignore
//    @Test
//    public void readMcsConfig() throws ConfigException {
//    	
//    	String cachesns=client.get(SDKConstants.PAAS_CACHENS_MCS_MAPPED_PATH);
//    	
//    	System.out.println("cachesns:"+cachesns);
//    	
//    }
//
//    @Ignore
//    @Test
//    public void addMdsConfig() throws ConfigException {
//        // 
//        String mds001 = "MDS001";
//        // 空间
//        String mdssnsConfig = "{\"baas-bmc-topic\":\"" + mds001
//                + "\",\"baas-amc-topic\":\"" + mds001
//                + "\",\"baas-omc-topic\":\"" + mds001
//                + "\",\"baas-smc-topic\":\"" + mds001 + "\"}";
//
//        // MDS空间配置
//        if (!client.exists(SDKConstants.PAAS_MDSNS_MDS_MAPPED_PATH))
//            client.add(SDKConstants.PAAS_MDSNS_MDS_MAPPED_PATH,
//                    mdssnsConfig);
//        else {
//            client.modify(SDKConstants.PAAS_MDSNS_MDS_MAPPED_PATH,
//                    mdssnsConfig);
//        }
//        
//     // 
//        String mdsRealTopic = "BCA976731EF24B899B143755A3AF5794_MDS001_1743120261";
//        // 空间
//        String mdstopicConfig = "{\"MDS001\":\"" + mdsRealTopic
//                + "\"}";
//
//        // MDS空间配置
//        if (!client.exists(SDKConstants.PAAS_MDS_TOPIC_MAPPED_PATH))
//            client.add(SDKConstants.PAAS_MDS_TOPIC_MAPPED_PATH,
//            		mdstopicConfig);
//        else {
//            client.modify(SDKConstants.PAAS_MDS_TOPIC_MAPPED_PATH,
//            		mdstopicConfig);
//        }
//        
//    }
//    @Ignore
//    @Test
//    public void addDssConfig() throws ConfigException {
//        // 缓存服务主机
//        String dssId = "DSS001";
//        // 缓存空间
//        String dssnsConfig = "{\"baas-bmc-dss\":\"" + dssId
//                + "\",\"baas-amc-dss\":\"" + dssId
//                + "\",\"baas-omc-dss\":\"" + dssId
//                + "\",\"baas-smc-dss\":\"" + dssId + "\"}";
//        
//        
//
//        // 缓存空间配置
//        if (!client.exists(SDKConstants.PAAS_DSSNS_DSS_MAPPED_PATH))
//            client.add(SDKConstants.PAAS_DSSNS_DSS_MAPPED_PATH,
//                    dssnsConfig);
//        else {
//            client.modify(SDKConstants.PAAS_DSSNS_DSS_MAPPED_PATH,
//                    dssnsConfig);
//        }
//    }
//    @Ignore
//    @Test
//    public void addIdpsConfig() throws ConfigException {
//        // 缓存服务主机
//        String idpsId = "IDPS001";
//        // 缓存空间
//        String idpsnsConfig = "{\"slp-mall-web-idps\":\"" + idpsId
////                + "\",\"slp-mall-web-idps2\":\"" + idpsId
////                + "\",\"baas-omc-dss\":\"" + idpsId
//                + "\",\"slp-mall-web-idps2\":\"" + idpsId + "\"}";
//        
//        
//
//        // 缓存空间配置
//        if (!client.exists(SDKConstants.PAAS_IDPSNS_IDPS_MAPPED_PATH))
//            client.add(SDKConstants.PAAS_IDPSNS_IDPS_MAPPED_PATH,
//                    idpsnsConfig);
//        else {
//            client.modify(SDKConstants.PAAS_IDPSNS_IDPS_MAPPED_PATH,
//                    idpsnsConfig);
//        }
//    }
//
//    /**
//     * DB配置
//     * @throws ConfigException 
//     */
////    @Ignore
//     @Test
//    public void addDbConfInfo() throws ConfigException {
//        System.out.println("DBConf config ... start");
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("{																																																				");
//        sb.append("		\"slp-pay-db\":                                                                                   ");
//        sb.append("		{                                                                                                     ");
//        sb.append("			\"driverClassName\":\"com.mysql.jdbc.Driver\",                                                          ");
//        sb.append("			\"jdbcUrl\":\"jdbc:mysql://10.1.245.7:31306/devslppaydb1?useUnicode=true&characterEncoding=UTF-8\",   ");
//        sb.append("			\"username\":\"devslppayusr1\",                                                                         ");
//        sb.append("			\"password\":\"devslppay@8899\",                                                                         ");
//        sb.append("			\"autoCommit\":\"true\",                                                                                ");
//        sb.append("			\"connectionTimeout\":\"30000\",                                                                        ");
//        sb.append("			\"idleTimeout\":\"600000\",                                                                             ");
//        sb.append("			\"maxLifetime\":\"1800000\",                                                                            ");
//        sb.append("			\"maximumPoolSize\":\"10\"                                                                              ");
//        sb.append("		}                                                                                                     ");
//        sb.append("}                                                                                                        ");
//
//        if (!client.exists(SDKConstants.DB_CONF_PATH)) {
//            client.add(SDKConstants.DB_CONF_PATH, sb.toString());
//        } else {
//            client.modify(SDKConstants.DB_CONF_PATH, sb.toString());
//        }
//
//        System.out.println("DBConf config ... end");
//    }
//    
////    @Ignore
//    @Test
//    public void readDbConfInfo() throws ConfigException {
//    	System.out.println("DBConf conf = " + client.get(SDKConstants.DB_CONF_PATH));
//    }
//    @Ignore
//    @Test
//    public void addDtsInfo() throws ConfigException {
//        System.out.println("dts config ... start");
//        StringBuilder sb = new StringBuilder();
//
//
//        
//       sb.append("{                                                                                          ");
//       sb.append("	   \"org.quartz.jobStore.dataSource\":\"myDS\",                                              ");
//       sb.append("	   \"org.quartz.dataSource.myDS.driver\":\"com.mysql.jdbc.Driver\",                          ");
//       sb.append("	   \"org.quartz.dataSource.myDS.URL\":\"jdbc:mysql://10.1.245.7:31306/devslpdtsdb1\",        ");
//       sb.append("	   \"org.quartz.dataSource.myDS.user\":\"devslpdtsusr1\",                                    ");
//       sb.append("	   \"org.quartz.dataSource.myDS.password\":\"devslpdtsusr1@8899\",                           ");
//       sb.append("	   \"org.quartz.dataSource.myDS.maxConnections\":\"5\",                                      ");
//       sb.append("	   \"org.quartz.dataSource.myDS.validationQuery\":\"select 0\",                              ");
//       sb.append("	   \"org.quartz.jobStore.misfireThreshold\":\"60000\",                                       ");
//       sb.append("	   \"org.quartz.jobStore.useProperties\":\"false\",                                          ");
//       sb.append("	   \"org.quartz.jobStore.tablePrefix\":\"QRTZ_\",                                            ");
//       sb.append("	   \"org.quartz.jobStore.class\":\"com.ai.opt.sdk.dts.jdbcstore.DTSJobStore\",               ");
//       sb.append("	   \"org.quartz.jobStore.isClustered\":\"true\",                                             ");
//       sb.append("	   \"org.quartz.scheduler.skipUpdateCheck\":\"true\",                                        ");
//       sb.append("	   \"org.quartz.threadPool.threadCount\":\"5\",                                              ");
//       sb.append("	   \"org.quartz.threadPool.class\":\"org.quartz.simpl.SimpleThreadPool\",                    ");
//       sb.append("	   \"org.quartz.threadPool.threadPriority\":\"5\"                                            ");
//       sb.append("	}                                                                                        ");
//        
//        
//        if (!client.exists(SDKConstants.DTS_QUARTZ_CONF_PATH)) {
//            client.add(SDKConstants.DTS_QUARTZ_CONF_PATH, sb.toString());
//        } else {
//            client.modify(SDKConstants.DTS_QUARTZ_CONF_PATH, sb.toString());
//        }
//
//        System.out.println("dts config ... end");
//    }
//
//}
