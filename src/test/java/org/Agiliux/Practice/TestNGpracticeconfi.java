package org.Agiliux.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGpracticeconfi {

	
   @BeforeSuite
   public void beforesuit() {
	   System.out.println("Before Suit Script 1");
   }
   
   @AfterSuite
   public void afterSuit() {
	   System.out.println("After Suit Script 2");
   }
   
   @BeforeTest
   public void beforeTest() {
	   System.out.println("Before Test Script 1");
   }
   
   @AfterTest 
   public void afterTest() {
	   System.out.println("After Test Script 2");
   }
   
   @BeforeClass
   public void beforeClass() {
	   System.out.println("Before Class Script 1");
   }
   
   @AfterClass
   public void afterclass() {
	   System.out.println("After class Script 2");
   }
   
   @BeforeMethod
   public void beforeMethod() {
	   System.out.println(" Before Method Script 1");
   }
   @AfterMethod
   public void afterMethod() {
	   System.out.println("After Method Script 2");
   }
   @Test
   public void test1() {
	   System.out.println("Test Sript 1");
   }
   @Test
   public void test2() {
	  System.out.println("Test Script 2");
   }
}
