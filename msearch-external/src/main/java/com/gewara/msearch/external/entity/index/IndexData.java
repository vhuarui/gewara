package com.gewara.msearch.external.entity.index;

import java.io.Serializable;

public abstract class IndexData implements Serializable{
	protected String dataID=null;
	protected Long order1 = 0L;
	protected Long order2 = 0L;
	protected Long order3 = 0L;
	/**
	 * ��ʾÿ�������ID
	 * @return
	 */
	public String getDataID() {
		return dataID;
	}

	public void setDataID(String dataID) {
		this.dataID = dataID;
	}

	/**
	 * �����ֶ�1
	 * @return
	 */
	public Long getOrder1() {
		return order1;
	}

	/**
	 * �����ֶ�1
	 * @param order1
	 */
	public void setOrder1(Long order1) {
		this.order1 = order1;
	}

	/**
	 * �����ֶ�3
	 * @return
	 */
	public Long getOrder2() {
		return order2;
	}

	/**
	 * �����ֶ�2
	 * @param order2
	 */
	public void setOrder2(Long order2) {
		this.order2 = order2;
	}

	/**
	 * �����ֶ�3
	 * @return
	 */
	public Long getOrder3() {
		return order3;
	}

	/**
	 * �����ֶ�3
	 * @param order3
	 */
	public void setOrder3(Long order3) {
		this.order3 = order3;
	}
	
	
	
}
