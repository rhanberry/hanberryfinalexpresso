/*
 * This file was automatically generated by EvoSuite
 * Mon Feb 29 07:35:49 GMT 2016
 */

package com.rickhanberryfinal.services.impl;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.rickhanberryfinal.entities.BakeryCategory;
import com.rickhanberryfinal.services.impl.BakeryCategoryServiceImpl;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class BakeryCategoryServiceImpl_ESTest extends BakeryCategoryServiceImpl_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      BakeryCategoryServiceImpl bakeryCategoryServiceImpl0 = new BakeryCategoryServiceImpl();
      Long long0 = new Long(0L);
      // Undeclared exception!
      try { 
        bakeryCategoryServiceImpl0.findOne(long0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("com.rickhanberryfinal.services.impl.BakeryCategoryServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      BakeryCategoryServiceImpl bakeryCategoryServiceImpl0 = new BakeryCategoryServiceImpl();
      // Undeclared exception!
      try { 
        bakeryCategoryServiceImpl0.findAll();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("com.rickhanberryfinal.services.impl.BakeryCategoryServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      BakeryCategoryServiceImpl bakeryCategoryServiceImpl0 = new BakeryCategoryServiceImpl();
      // Undeclared exception!
      try { 
        bakeryCategoryServiceImpl0.delete((Long) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("com.rickhanberryfinal.services.impl.BakeryCategoryServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      BakeryCategoryServiceImpl bakeryCategoryServiceImpl0 = new BakeryCategoryServiceImpl();
      // Undeclared exception!
      try { 
        bakeryCategoryServiceImpl0.save((BakeryCategory) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("com.rickhanberryfinal.services.impl.BakeryCategoryServiceImpl", e);
      }
  }
}