package com.ifudata.ic.smc.preprocess.topology.core.flow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ifudata.dvp.storm.flow.BaseFlow;
import com.ifudata.dvp.storm.util.BaseConstants;
import com.ifudata.ic.smc.preprocess.topology.core.bolt.CheckBolt;
import com.ifudata.ic.smc.preprocess.topology.core.bolt.StatisticsBolt;
import com.ifudata.ic.smc.preprocess.topology.core.constant.SmcConstants;

/**
 * 结算预处理拓扑图
 * 
 * @author wangjl9
 * @since 2016.4.18
 */
public class SMCPreprocessFlow extends BaseFlow {
    private static Logger logger = LoggerFactory.getLogger(SMCPreprocessFlow.class);

    @Override
    public void define() {
        super.setKafkaSpout();

        builder.setBolt(SmcConstants.CHECK_BOLT, new CheckBolt(), 1).shuffleGrouping(
                BaseConstants.KAFKA_SPOUT_NAME);
        builder.setBolt(SmcConstants.STATISTICS_BOLT, new StatisticsBolt(), 1).shuffleGrouping(
                SmcConstants.CHECK_BOLT);
    }

    public static void main(String[] args) {
        logger.info("开始启动算费预处理拓扑...");
        args = new String[]{"/Users/wangluyang/文件/资采/结算/conf.yaml"};
        SMCPreprocessFlow flow = new SMCPreprocessFlow();
        flow.run(args);
    }

}
