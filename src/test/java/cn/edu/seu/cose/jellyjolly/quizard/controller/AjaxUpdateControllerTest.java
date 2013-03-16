/*
 * The MIT License
 *
 * Copyright 2013 Jelly Jolly Team.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package cn.edu.seu.cose.jellyjolly.quizard.controller;

import cn.edu.seu.cose.jellyjolly.quizard.service.mock.MockQuizService;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Xeon
 */
public class AjaxUpdateControllerTest {
    
    public AjaxUpdateControllerTest() {
    }

    /**
     * Test of updateAdminQuizzes method, of class AjaxUpdateController.
     */
    @org.junit.Test
    public void testUpdateAdminQuizzes() {
        System.out.println("updateAdminQuizzes");
        int userId = 0;
        int offset = 0;
        int limit = 0;
        MockQuizService mockQuizService = new MockQuizService();
        AjaxUpdateController instance = new AjaxUpdateController(mockQuizService);
        ResponseEntity expResult = null;
        ResponseEntity result = instance.updateAdminQuizzes(userId, offset, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
