package com.ai.opt.uac.web.controller.Kingsoft;

import org.jasig.cas.support.pac4j.plugin.baidu.BaiduAttributesDefinition;
import org.pac4j.core.profile.AttributesDefinition;
import org.pac4j.oauth.profile.OAuth20Profile;

/**
 * 用于添加返回用户信息
 * @author b2c021
 *
 */
public class KingSoftProfile extends OAuth20Profile {

	private static final long serialVersionUID = -1754846052774410385L;

	@Override
	public AttributesDefinition getAttributesDefinition() {
        return new KingSoftAttributesDefinition();
    }
}
