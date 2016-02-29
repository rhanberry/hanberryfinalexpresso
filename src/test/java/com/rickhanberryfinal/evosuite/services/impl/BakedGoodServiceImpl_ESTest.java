/*
 * This file was automatically generated by EvoSuite
 * Mon Feb 29 15:08:22 GMT 2016
 */

package com.rickhanberryfinal.evosuite.services.impl;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.rickhanberryfinal.entities.BakedGood;
import com.rickhanberryfinal.services.impl.BakedGoodServiceImpl;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class BakedGoodServiceImpl_ESTest extends BakedGoodServiceImpl_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      BakedGoodServiceImpl bakedGoodServiceImpl0 = new BakedGoodServiceImpl();
      // Undeclared exception!
      try { 
        bakedGoodServiceImpl0.findOne((Long) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("com.rickhanberryfinal.services.impl.BakedGoodServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      BakedGoodServiceImpl bakedGoodServiceImpl0 = new BakedGoodServiceImpl();
      // Undeclared exception!
      try { 
        bakedGoodServiceImpl0.delete((Long) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("com.rickhanberryfinal.services.impl.BakedGoodServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      BakedGoodServiceImpl bakedGoodServiceImpl0 = new BakedGoodServiceImpl();
      // Undeclared exception!
      try { 
        bakedGoodServiceImpl0.findAll();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("com.rickhanberryfinal.services.impl.BakedGoodServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      BakedGoodServiceImpl bakedGoodServiceImpl0 = new BakedGoodServiceImpl();
      // Undeclared exception!
      try { 
        bakedGoodServiceImpl0.save((BakedGood) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("com.rickhanberryfinal.services.impl.BakedGoodServiceImpl", e);
      }
  }
}
