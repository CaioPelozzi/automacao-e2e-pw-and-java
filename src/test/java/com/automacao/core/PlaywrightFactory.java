package com.automacao.core;

import com.microsoft.playwright.*;

import java.util.Arrays;

public class PlaywrightFactory {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;

    public static Page createPageWithState() {
        if (playwright == null) {
            playwright = Playwright.create();
            //Ativar/Desativar modo headless
            boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(headless)
                            //Maximizar tela
                            .setArgs(Arrays.asList("--start-maximized"))
            );
        }

        //Seta configurações para aplicar ao context
        Browser.NewContextOptions options = new Browser.NewContextOptions()
                .setViewportSize(null);

        //Aplica essas configurações ao context
        context = browser.newContext(options);

        return context.newPage();
    }

    public static void close() {
        if (context != null) context.close();

        if (browser != null){
            browser.close();
            browser = null; //Zera o atributo para o próximo teste
        }

        if (playwright != null){
            playwright.close();
            playwright = null; // Zera o atributo para o próximo teste
        }
    }


}
