package com.rickhanberryfinal.services.impl;

import com.rickhanberryfinal.entities.Allergens;
import com.rickhanberryfinal.repository.AllergensRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rhanberry on 2/27/16.
 */
public class AllergensServiceImplTest {

    AllergensRepository allergensRepository;



    @Test
    public void testSave() throws Throwable {
        AllergensServiceImpl allergensServiceImpl0 = new AllergensServiceImpl();
        // Undeclared exception!
        try {
            allergensServiceImpl0.save((Allergens) null);
            fail("Expecting exception: NullPointerException");

        } catch(NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }

    }

    @Test
    public void testFindAll() throws Exception {

    }

    @Test
    public void testFindOne() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}