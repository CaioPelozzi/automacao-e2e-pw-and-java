package com.automacao.core;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    protected Page page;

    //URLs
    protected static final String HOME = "https://sauce-demo.myshopify.com/";
    protected static final String SEARCH = "https://sauce-demo.myshopify.com/search";
    protected static final String ABOUT_US = "https://sauce-demo.myshopify.com/pages/about-us";
    protected static final String LOGIN = "https://sauce-demo.myshopify.com/account/login";
    protected static final String MY_ACCOUNT = "https://sauce-demo.myshopify.com/account";
    protected static final String SIGN_UP = "https://sauce-demo.myshopify.com/account/register";
    protected static final String CATALOG = "https://sauce-demo.myshopify.com/collections/all";
    protected static final String BLOG = "https://sauce-demo.myshopify.com/blogs/news";
    protected static final String CHECK_OUT = "https://sauce-demo.myshopify.com/blogs/news";

    //Logins
    protected static final String USUARIO = "Automacao Teste";
    protected static final String SENHA = "automacaoteste";

    @BeforeEach
    public void setUp(){
        page = PlaywrightFactory.createPageWithState();
    }

    @AfterEach
    public void closeUp(){
        PlaywrightFactory.close();
    }

}
