package Generator;

import javax.management.RuntimeErrorException;
import javax.xml.datatype.DatatypeConfigurationException;

public class chloe51 {
	public static void main(String[] args) {
		try {
			test1();
		} catch (Exception e) {
			
		}
		test2();
		
		try {
			test1();
		}catch(Exception e) {
			
		}
	}
	
	static void test1() throws DatatypeConfigurationException{ // 事先做檢查，事先告知會有拋出exception, 可不只一個
		throw new DatatypeConfigurationException(); // 此處 throw => verb.
//		try {
//			throw new DatatypeConfigurationException();
//		}catch (Exception e) {
//			// 寫死了
//		}
	}
	
	static void test2() throws RuntimeException {
		throw new RuntimeException();
	}

}
