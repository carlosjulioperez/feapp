package ec.cjpq.fe.util;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ec.cjpq.fe.dao.EntidadDaoTest;

public class IntegralTest extends TestCase{
	
    public static Test suite(){
       TestSuite suite = new TestSuite("Prueba integral o de integración...");
       // $JUnit-BEGIN$
       //suite.addTestSuite(EntidadDaoTest.class);
       // $JUnit-END$
       return suite;
    }
}
