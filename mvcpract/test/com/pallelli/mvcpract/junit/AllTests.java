package com.pallelli.mvcpract.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FoodItemServiceTest.class, LoginServiceTest.class, MySecurityProviderTest.class })
public class AllTests {

}
