package com.ifudata.ic.smc.check.topology.core.flow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ifudata.dvp.storm.flow.BaseFlow;
import com.ifudata.dvp.storm.util.BaseConstants;
import com.ifudata.ic.smc.check.topology.constants.SmcConstant;
import com.ifudata.ic.smc.check.topology.core.bolt.BillDetailCheckBolt;
import com.ifudata.ic.smc.check.topology.core.bolt.DataValidationBolt;
import com.ifudata.ic.smc.check.topology.core.bolt.UnpackingBolt;

public class SmcCheckGeneralFlow extends BaseFlow {
    private static final Logger LOG = LoggerFactory.getLogger(SmcCheckGeneralFlow.class);

    @Override
    public void define() {
        super.setKafkaSpout();
        /* 解包bolt */
        builder.setBolt(SmcConstant.UNPACKING_BOLT, new UnpackingBolt(), 1).shuffleGrouping(
                BaseConstants.KAFKA_SPOUT_NAME);
        /* 数据校验bolt */
        builder.setBolt(SmcConstant.DATA_VALIDATION_BOLT, new DataValidationBolt(), 1)
                .shuffleGrouping(SmcConstant.UNPACKING_BOLT);
        /* 对账bolt */
        builder.setBolt(SmcConstant.BILL_DETAIL_CHECK_BOLT, new BillDetailCheckBolt(), 1)
                .shuffleGrouping(SmcConstant.DATA_VALIDATION_BOLT);
    }

    public static void main(String[] args) {
        LOG.info("开始启动结算对账拓扑");
        SmcCheckGeneralFlow flow = new SmcCheckGeneralFlow();
        flow.run(args);
    }

}
