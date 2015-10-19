package com.pallelli.hibpract.policymodel.junit;

import org.junit.Test;

import com.pallelli.hibpract.policymodel.PolicyDaoImpl;
import com.pallelli.hibpract.policymodel.beans.Risk;

public class PolicyDaoTest {

	@Test
	public void addRisk() {
		Risk risk = new Risk();
		risk.setName("tr1");
//		PolicyDao.getInstance().addRisk(risk);
	}

}
