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
package cn.edu.seu.cose.jellyjolly.quizard.dao.impl;

import cn.edu.seu.cose.jellyjolly.quizard.dao.AdminUserDataAccess;
import cn.edu.seu.cose.jellyjolly.quizard.dao.DataAccessException;
import cn.edu.seu.cose.jellyjolly.quizard.model.AdminUser;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class MockAdminUserDataAccess implements AdminUserDataAccess {

    private Map<String, AdminUser> usernameMapped;
    private Map<String, AdminUser> emailMapped;

    public MockAdminUserDataAccess() {
        usernameMapped = new HashMap<String, AdminUser>();
        emailMapped = new HashMap<String, AdminUser>();
    }

    @Override
    public AdminUser getAdminUserByUsername(String username)
            throws DataAccessException {
        return usernameMapped.get(username);
    }

    @Override
    public AdminUser getAdminUserByEmail(String email)
            throws DataAccessException {
        return emailMapped.get(email);
    }

    @Override
    public AdminUser getAdminUserByUsernameIfConfirmed(
            String username, String password) throws DataAccessException {
        AdminUser adminUser = usernameMapped.get(username);
        boolean confirmed = (password != null)
                && password.equals(adminUser.getPassword());
        return confirmed ? adminUser : null;
    }

    @Override
    public AdminUser getAdminUserByEmailIfConfirmed(
            String email, String password) throws DataAccessException {
        AdminUser adminUser = emailMapped.get(email);
        boolean confirmed = (password != null)
                && password.equals(adminUser.getPassword());
        return confirmed ? adminUser : null;
    }

    @Override
    public AdminUser registerNewAdminUser(String username, String email,
            String password) throws DataAccessException {
        AdminUser adminUser = new AdminUser();
        adminUser.setEmail(email);
        adminUser.setPassword(password);
        adminUser.setUsername(username);
        usernameMapped.put(username, adminUser);
        emailMapped.put(email, adminUser);
        return adminUser;
    }

    @Override
    public void updateAdminUser(AdminUser adminUser)
            throws DataAccessException {
        String username = adminUser.getUsername();
        String email = adminUser.getEmail();
        usernameMapped.put(username, adminUser);
        emailMapped.put(email, adminUser);
    }
}
