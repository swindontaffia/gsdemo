package test.brittonn.hibpract.junit;

import org.junit.Test;

import test.brittonn.hibpract.IFacesDao;
import test.brittonn.hibpract.model.Risk;

public class IFacesDaoTest {

	@Test
	public void addRisk() {
		Risk risk = new Risk();
		risk.setName("tr1");
		IFacesDao.getInstance().addRisk(risk);
	}

}
