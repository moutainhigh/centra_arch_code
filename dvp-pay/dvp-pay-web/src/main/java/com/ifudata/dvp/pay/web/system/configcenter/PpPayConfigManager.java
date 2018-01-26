package com.ifudata.dvp.pay.web.system.configcenter;

import com.ifudata.dvp.pay.web.system.util.ConfigUtil;

public class PpPayConfigManager extends AbstractPayConfigManager {

	private static final String PP_ORG_CODE = "PP";
	private static final String PAYPAL_PAYAPI = "/paypal/payapi";
	public static final String CHECKOUT_BUTTON_URL = "checkoutButtonUrl";
	private static final String MERCHANT_ACCOUNT_ID = "merchantAccountId";
	private static final String IPN_URL = "ipnUrl";

	@Override
	public String getPayActionUrl(String requestSource) {
		return PAYPAL_PAYAPI;
	}

	@Override
	public String getRefundActionUrl(String requestSource) {
		return null;
	}

	@Override
	public String getBatchRefundActionUrl(String requestSource) {
		return null;
	}

	@Override
	public String getWithDrawActionUrl(String requestSource) {
		return null;
	}

	@Override
	public String getBatchWithDrawActionUrl(String requestSource) {
		return null;
	}

	@Override
	public String getQueryActionUrl(String requestSource) {
		return null;
	}

	public static String getCheckoutButtonUrl() {
		return ConfigUtil.getPayOrgProperty(PP_ORG_CODE, CHECKOUT_BUTTON_URL);
	}

	public static String getMerchantAccountId(String tenantId) {
		return ConfigUtil.getProperty(tenantId, PP_ORG_CODE, MERCHANT_ACCOUNT_ID);
	}

	public static String getIpnUrl() {
		return ConfigUtil.getPayOrgProperty(PP_ORG_CODE, IPN_URL);
	}

}
