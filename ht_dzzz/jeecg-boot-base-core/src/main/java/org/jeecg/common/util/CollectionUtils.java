package org.jeecg.common.util;

import java.util.Collection;

/**
 * <p>Created by Raofeicheng on 2024/8/28.</p>
 * @author Raofeicheng
 * @version 1.0
 */
public class CollectionUtils extends org.apache.commons.collections.CollectionUtils {

	public static <T extends Collection<P>, P> T defaultIfEmpty(T coll, T defaultVal) {
		return isEmpty(coll) ? defaultVal : coll;
	}

}
