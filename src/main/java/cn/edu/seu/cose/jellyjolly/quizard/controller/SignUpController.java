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
public class SignUpController {

    private AdminUserService adminUserService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUp() {
        return "/signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUp(@RequestParam String username,
            @RequestParam String password, @RequestParam String email,
            HttpSession session) {
        AdminUser adminUser = adminUserService.findAdminUser(username,
                email);
        if (adminUser == null) {
            AdminUser newUser = adminUserService.createAdminUser(username,
                    password, email);
            session.setAttribute("newUser", newUser);
            return "redirect:/home";
        } else {
            // 1 => email have already sign up
            return "redirect:signup?error=1";
        }

    }
}
