package org.jasig.cas.support.pac4j.plugin.baidu;

import org.pac4j.core.profile.AttributesDefinition;
import org.pac4j.oauth.profile.OAuth20Profile;

/**
 * 用于添加返回用户信息
 * @author b2c021
 *
 */
public class BaiduProfile extends OAuth20Profile {

    private static final long serialVersionUID = -7969484323692570444L;

    @Override
	public AttributesDefinition getAttributesDefinition() {
        return new BaiduAttributesDefinition();
    }

}
