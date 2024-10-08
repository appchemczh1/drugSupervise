package org.jeecg.modules.demo.dzzz.certinfo.entity;

import java.io.Serializable;

/**
 * <p>Created by Raofeicheng on 2024/8/26.</p>
 * @author Raofeicheng
 * @version 1.0
 */
public abstract class ACertInfo implements Serializable {

	public abstract String getId();

	public abstract void setId(String id);

	public abstract String getCertTypeId();

}
