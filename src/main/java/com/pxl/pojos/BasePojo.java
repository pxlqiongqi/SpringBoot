package com.pxl.pojos;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class BasePojo implements Serializable,Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		try {
			return BeanUtils.describe(this).toString();
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
