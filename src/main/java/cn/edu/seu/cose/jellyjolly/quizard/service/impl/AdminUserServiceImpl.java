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
package cn.edu.seu.cose.jellyjolly.quizard.service.impl;

import cn.edu.seu.cose.jellyjolly.quizard.dao.AdminUserDataAccess;
import cn.edu.seu.cose.jellyjolly.quizard.model.AdminUser;
import cn.edu.seu.cose.jellyjolly.quizard.service.AdminUserService;
import cn.edu.seu.cose.jellyjolly.quizard.service.AuthenticationException;
import cn.edu.seu.cose.jellyjolly.quizard.service.UserInputFormatException;
import java.util.regex.Pattern;

/**
 *
 * @author rAy <predator.ray@gmail.com>
 */
public class AdminUserServiceImpl implements AdminUserService {

    private AdminUserDataAccess adminUserDataAccess;
    private static final String USERNAME_REGEX =
            "^[a-zA-Z][a-zA-Z0-9_]{4,15}$"; // 5~16
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    public AdminUserServiceImpl(AdminUserDataAccess adminUserDataAccess) {
        this.adminUserDataAccess = adminUserDataAccess;
    }

    @Override
    public AdminUser authenticate(String usernameOrEmail, String password)
            throws AuthenticationException {
        AdminUser adminUser = null;
        if (matchUsernameFormat(usernameOrEmail)) {
            adminUser = adminUserDataAccess.getAdminUserByUsernameIfConfirmed(
                    usernameOrEmail, password);
        } else if (matchEmailFormat(usernameOrEmail)) {
            adminUser = adminUserDataAccess.getAdminUserByEmailIfConfirmed(
                    usernameOrEmail, password);
        }

        if (adminUser == null) {
            throw new AuthenticationException();
        }
        return adminUser;
    }

    @Override
    public AdminUser createAdminUser(String username, String password,
            String email) {
        if (!matchUsernameFormat(username)
                || !matchEmailFormat(email)
                || !matchPasswordFormat(password)) {
            throw new UserInputFormatException();
        }
        return adminUserDataAccess.registerNewAdminUser(
                username, email, password);
    }

    @Override
    public AdminUser getAdminUserByUsername(String username) {
        return adminUserDataAccess.getAdminUserByUsername(username);
    }

    @Override
    public AdminUser getAdminUserByEmail(String email) {
        return adminUserDataAccess.getAdminUserByEmail(email);
    }

    @Override
    public boolean changePassword(String username, String prevPass,
            String newPass) {
        AdminUser adminUser = adminUserDataAccess
                .getAdminUserByUsernameIfConfirmed(username, prevPass);
        if (adminUser == null) {
            return false;
        }

        if (!matchPasswordFormat(newPass)) {
            throw new UserInputFormatException();
        }
        adminUser.setPassword(newPass);
        adminUserDataAccess.updateAdminUser(adminUser);
        return true;
    }

    @Override
    public boolean usernameHasRegistered(String username) {
        return adminUserDataAccess.getAdminUserByUsername(username) != null;
    }

    @Override
    public boolean emailHasRegistered(String email) {
        return adminUserDataAccess.getAdminUserByEmail(email) != null;
    }

    @Override
    public boolean matchUsernameFormat(String input) {
        return Pattern.matches(USERNAME_REGEX, input);
    }

    @Override
    public boolean matchEmailFormat(String input) {
        return Pattern.matches(EMAIL_REGEX, input);
    }

    @Override
    public boolean matchPasswordFormat(String input) {
        return (input != null) && (input.length() >= 6 && input.length() <= 20);
    }
}
