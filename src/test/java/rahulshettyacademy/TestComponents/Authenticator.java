package rahulshettyacademy.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Authenticator {

    public static class Retry implements IRetryAnalyzer {
        private int count = 0;
        private static final int maxTry = 1;

        @Override
        public boolean retry(ITestResult result) {
            if (count < maxTry) {
                count++;
                return true;
            }
            return false;
        }
    }
}
 

//public class Retry implements IRetryAnalyzer{
//    
//	int count=0;
//	int maxTry=1;
//	
//	@Override
//	public boolean retry(ITestResult result) {
//		// TODO Auto-generated method stub
//		if(count<maxTry) {
//			count++;
//			return true;
//		}
//		return false;
//	}
//
//}
