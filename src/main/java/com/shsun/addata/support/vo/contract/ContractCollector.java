package com.shsun.addata.support.vo.contract;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shsun.addata.vo.DIM_ADS_CONTRACT;

public class ContractCollector {
	private Map<BigDecimal, DIM_ADS_CONTRACT> collection = new HashMap<BigDecimal, DIM_ADS_CONTRACT>();

	public ContractCollector(List<DIM_ADS_CONTRACT> list) {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				collection.put(list.get(i).getCONTRACT_ID(), list.get(i));
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public DIM_ADS_CONTRACT getAmountSourContract(BigDecimal contractId) {
		DIM_ADS_CONTRACT amountSourceContract = null;
		BigDecimal amountSourContractId = this.collection.get(contractId).getAMOUNT_SOUR_ID();
		DIM_ADS_CONTRACT tmpContract = this.collection.get(amountSourContractId);
		if (tmpContract.getCONTRACT_ID().intValue() != contractId.intValue()) {
			amountSourceContract = tmpContract;
		}
		return amountSourceContract;
	}

	/**
	 * IsAmount==0表示原合同， 1表示补量合同
	 * 
	 * @param contractId
	 * @return
	 */
	public boolean hasAmountSourContract(BigDecimal contractId) {
		return (this.getAmountSourContract(contractId) != null);
	}

}
