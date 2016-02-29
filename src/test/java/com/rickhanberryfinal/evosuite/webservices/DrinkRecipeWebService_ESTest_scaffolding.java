/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Mon Feb 29 15:06:16 GMT 2016
 */

package com.rickhanberryfinal.evosuite.webservices;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class DrinkRecipeWebService_ESTest_scaffolding {

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);

  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.rickhanberryfinal.webservices.DrinkRecipeWebService"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init(); 
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("java.vm.vendor", "Oracle Corporation"); 
    java.lang.System.setProperty("java.specification.version", "1.8"); 
            java.lang.System.setProperty("java.home", "/Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/jre"); 
        java.lang.System.setProperty("java.awt.headless", "true"); 
    java.lang.System.setProperty("user.home", "/Users/rhanberry"); 
                                        java.lang.System.setProperty("user.dir", "/Users/rhanberry/Desktop/rickhfinprojblank/hanberryfinalexpresso"); 
    java.lang.System.setProperty("java.io.tmpdir", "/var/folders/rx/tf_0j07j3lxgm_pk03cb4zbc0000gn/T/"); 
    java.lang.System.setProperty("awt.toolkit", "sun.lwawt.macosx.LWCToolkit"); 
    java.lang.System.setProperty("file.encoding", "UTF-8"); 
    java.lang.System.setProperty("file.separator", "/"); 
        java.lang.System.setProperty("java.awt.graphicsenv", "sun.awt.CGraphicsEnvironment"); 
    java.lang.System.setProperty("java.awt.printerjob", "sun.lwawt.macosx.CPrinterJob"); 
    java.lang.System.setProperty("java.class.path", "/var/folders/rx/tf_0j07j3lxgm_pk03cb4zbc0000gn/T/EvoSuite_pathingJar1196730580504912126.jar"); 
    java.lang.System.setProperty("java.class.version", "52.0"); 
        java.lang.System.setProperty("java.endorsed.dirs", "/Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/jre/lib/endorsed"); 
    java.lang.System.setProperty("java.ext.dirs", "/Users/rhanberry/Library/Java/Extensions:/Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/jre/lib/ext:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java"); 
    java.lang.System.setProperty("java.library.path", "lib"); 
    java.lang.System.setProperty("java.runtime.name", "Java(TM) SE Runtime Environment"); 
    java.lang.System.setProperty("java.runtime.version", "1.8.0_65-b17"); 
    java.lang.System.setProperty("java.specification.name", "Java Platform API Specification"); 
    java.lang.System.setProperty("java.specification.vendor", "Oracle Corporation"); 
        java.lang.System.setProperty("java.vendor", "Oracle Corporation"); 
    java.lang.System.setProperty("java.vendor.url", "http://java.oracle.com/"); 
    java.lang.System.setProperty("java.version", "1.8.0_65"); 
    java.lang.System.setProperty("java.vm.info", "mixed mode"); 
    java.lang.System.setProperty("java.vm.name", "Java HotSpot(TM) 64-Bit Server VM"); 
    java.lang.System.setProperty("java.vm.specification.name", "Java Virtual Machine Specification"); 
    java.lang.System.setProperty("java.vm.specification.vendor", "Oracle Corporation"); 
    java.lang.System.setProperty("java.vm.specification.version", "1.8"); 
    java.lang.System.setProperty("java.vm.version", "25.65-b01"); 
    java.lang.System.setProperty("line.separator", "\n"); 
    java.lang.System.setProperty("os.arch", "x86_64"); 
    java.lang.System.setProperty("os.name", "Mac OS X"); 
    java.lang.System.setProperty("os.version", "10.11.2"); 
    java.lang.System.setProperty("path.separator", ":"); 
    java.lang.System.setProperty("user.country", "US"); 
    java.lang.System.setProperty("user.language", "en"); 
    java.lang.System.setProperty("user.name", "rhanberry"); 
    java.lang.System.setProperty("user.timezone", "America/Los_Angeles"); 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(DrinkRecipeWebService_ESTest_scaffolding.class.getClassLoader() ,
      "org.springframework.util.LinkedCaseInsensitiveMap",
      "org.springframework.http.HttpStatus$Series",
      "org.springframework.http.MediaType$1",
      "org.springframework.web.bind.annotation.RequestMapping",
      "org.springframework.http.MediaType$2",
      "org.springframework.stereotype.Controller",
      "org.springframework.http.ResponseEntity$BodyBuilder",
      "org.springframework.util.MimeType",
      "com.rickhanberryfinal.entities.DrinkRecipe",
      "org.springframework.http.HttpRange$ByteRange",
      "org.springframework.http.HttpRange$SuffixByteRange",
      "org.springframework.util.MimeType$SpecificityComparator",
      "org.springframework.util.InvalidMimeTypeException",
      "com.rickhanberryfinal.services.DrinkRecipeService",
      "org.springframework.http.HttpHeaders",
      "org.springframework.http.ResponseEntity$DefaultBuilder",
      "org.springframework.http.MediaType",
      "org.springframework.http.HttpMethod",
      "org.springframework.web.bind.annotation.RequestMethod",
      "org.springframework.util.MultiValueMap",
      "org.springframework.http.HttpRange",
      "org.springframework.util.MimeTypeUtils",
      "org.springframework.web.bind.annotation.ResponseBody",
      "org.springframework.web.bind.annotation.RestController",
      "org.springframework.http.HttpStatus",
      "org.springframework.http.InvalidMediaTypeException",
      "org.springframework.http.HttpEntity",
      "org.springframework.stereotype.Component",
      "org.springframework.util.CollectionUtils",
      "org.springframework.http.ResponseEntity",
      "org.springframework.http.ResponseEntity$HeadersBuilder",
      "com.rickhanberryfinal.webservices.DrinkRecipeWebService",
      "org.springframework.util.LinkedMultiValueMap",
      "org.springframework.web.bind.annotation.Mapping",
      "org.springframework.util.Assert",
      "org.springframework.util.StringUtils"
    );
  } 

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(DrinkRecipeWebService_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "org.springframework.web.bind.annotation.RequestMethod",
      "org.springframework.http.HttpStatus",
      "org.springframework.http.HttpMethod",
      "org.springframework.http.HttpHeaders",
      "org.springframework.util.LinkedCaseInsensitiveMap",
      "org.springframework.http.HttpEntity",
      "com.rickhanberryfinal.entities.DrinkRecipe",
      "org.springframework.util.StringUtils",
      "org.springframework.util.MimeType",
      "org.springframework.util.MimeTypeUtils",
      "org.springframework.http.MediaType",
      "org.springframework.util.LinkedMultiValueMap",
      "org.springframework.util.InvalidMimeTypeException",
      "org.springframework.http.InvalidMediaTypeException",
      "org.springframework.http.HttpRange"
    );
  }
}