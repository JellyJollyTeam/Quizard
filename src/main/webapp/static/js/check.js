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

var errorMessages = {
    '#username' : "请输入正确的用户名：以小写英语字母开头，长度5~16（允许a-z、0-9、_）",
    '#email' : "请输入正确的电子邮件",
    '#password' : "请输入正确的密码：长度6~20",
    '#confirm' : "两次密码输入不相同"
};

var registerChecker = {
    '#username' : {
        'check' : function(txt) {
            return txt.match(/^[a-z][a-z0-9_]{4,15}$/);
        },
        'error' : function(element) {
            showErrorMsg(errorMessages['#username']);
        }
    },
    '#email' : {
        'check' : function(txt) {
            return txt.match(/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/);
        },
        'error' : function(element) {
            showErrorMsg(errorMessages['#email']);
        }
    },
    '#password' : {
        'check' : function(txt) {
            return txt.length >= 6 && txt.length <= 20;
        },
        'error' : function(element) {
            showErrorMsg(errorMessages['#password']);
        }
    },
    '#confirm' : {
        'check' : function(txt) {
            return $('#password').val() === txt;
        },
        'error' : function(element) {
            showErrorMsg(errorMessages['#confirm']);
        }
    }
};

function showErrorMsg(msg) {
    $('#errorMsg').removeClass("hidden");
    $('#errorMsg').html(msg);
}

function hideErrorMsg() {
    $('#errorMsg').html('');
    $('#errorMsg').addClass("hidden");
}

function checkRegister(checker) {
    hideErrorMsg();
    for (var selector in checker) {
        var element = $(selector);
        eval('var check = ' + checker[selector]['check']);
        if (!check(element.val())) {
            eval('var error = ' + checker[selector]['error']);
            error(element);
            element.focus();
            return false;
        }
    }
    return true;
}