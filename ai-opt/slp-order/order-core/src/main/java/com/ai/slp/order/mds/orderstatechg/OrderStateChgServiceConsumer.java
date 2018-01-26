package com.ai.slp.order.mds.orderstatechg;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.sdk.components.mds.MDSClientFactory;
import com.ai.opt.sdk.components.mds.base.AbstractMdsConsumer;
import com.ai.paas.ipaas.mds.IMessageConsumer;
import com.ai.paas.ipaas.mds.IMessageProcessor;
import com.ai.paas.ipaas.mds.IMsgProcessorHandler;
import com.ai.slp.order.constants.OrdersConstants;
import com.ai.slp.order.service.business.interfaces.IOrderFrameCoreSV;

@Component
public class OrderStateChgServiceConsumer extends AbstractMdsConsumer {
	private static Logger logger = LoggerFactory.getLogger(OrderStateChgServiceConsumer.class);

	@Autowired
	private IOrderFrameCoreSV orderFrameCoreSV;
	@Override
	public void startMdsConsumer() throws Exception {
		logger.error("开始启动OrderStateChgServiceConsumer。。。。。");
		IMsgProcessorHandler msgProcessorHandler=new IMsgProcessorHandler() {
            @Override
            public IMessageProcessor[] createInstances(int paramInt) {
                List<IMessageProcessor> processors = new ArrayList<>();
                IMessageProcessor processor = null;
                for (int i = 0; i < paramInt; i++) {
                    processor = new OrderStateChgServiceMessProcessorImpl(orderFrameCoreSV);
                    processors.add(processor);
                }
                return processors.toArray(new IMessageProcessor[processors.size()]);
            }
        };
        IMessageConsumer msgConsumer= MDSClientFactory.getConsumerClient(
                OrdersConstants.MDSNS.MDS_NS_ORDER_STATE_TOPIC, msgProcessorHandler);
        msgConsumer.start();
        logger.error("成功启动OrderStateChgServiceConsumer。。。。。");

	}

}
