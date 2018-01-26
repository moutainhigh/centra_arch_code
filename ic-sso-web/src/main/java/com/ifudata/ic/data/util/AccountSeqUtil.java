package com.ifudata.ic.data.util;

import com.ifudata.centra.sdk.component.sequence.util.SeqUtil;
import com.ifudata.ic.data.constants.AccountConstants.SEQ;

/**
 * 生成账号Id Date: 2016年3月17日 <br>
 * Copyright (c) 2016 ifudata.com <br>
 * 
 * @author wangyongxin
 */
public final class AccountSeqUtil {

    private AccountSeqUtil() {
    }

    /**
     * 生成账号ID
     *
     * @return
     * @author wangyongxin
     * @ApiCode
     */
    public static long createAccountId() {
        return SeqUtil.getNewId(SEQ.ACCOUT_ID_SEQ);

    }

    /**
     * 生成昵称
     * 
     * @return
     * @author wangyongxin
     * @ApiCode
     */
    public static String createNickName() {
        String allName = SeqUtil.getNewId(SEQ.NICK_NAME, 6);
        char c = (char) (int) (Math.random() * 26 + 97);
        return c + allName;
    }
}
