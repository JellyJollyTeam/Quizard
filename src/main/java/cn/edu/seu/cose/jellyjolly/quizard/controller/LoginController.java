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

import cn.edu.seu.cose.jellyjolly.quizard.model.AdminUser;
import cn.edu.seu.cose.jellyjolly.quizard.service.AdminUserService;
import cn.edu.seu.cose.jellyjolly.quizard.service.AuthenticationException;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author xeon
 */
@Controller
public class LoginController {

    private AdminUserService adminUserService;

    public LoginController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, params ="rememberMe=true")
    public String loginAndSaveStatus(@RequestParam String username,
            @RequestParam String password, HttpSession session) {
        try {
            AdminUser adminUser = this.adminUserService.authenticate(username,
                    password);

            session.setAttribute("adminUser", adminUser);
            return "redirect:/";
        } catch (AuthenticationException ex) {
            // 1 => username and password not match
            return "redirect:/login?error=1";
        }
    }
        @RequestMapping(value = "/login", method = RequestMethod.POST, params ="!rememberMe")
    public String login(@RequestParam String username,
            @RequestParam String password, HttpSession session) {
        try {
            AdminUser adminUser = this.adminUserService.authenticate(username,
                    password);

            session.setAttribute("adminUser", adminUser);
            return "redirect:/";
        } catch (AuthenticationException ex) {
            // 1 => username and password not match
            return "redirect:/login?error=1";
        }
    }
}
