package com.bridgelabz.keyword;

import com.bridgelabz.k.engine.KeywordEngine;
import org.testng.annotations.Test;

public class LoginTest {
    KeywordEngine keywordEngine;

    @Test
    public void loginPageTest(){
        keywordEngine=new KeywordEngine();
        keywordEngine.starExecution("login");
    }
    @Test
    public void homePageTest(){
        keywordEngine=new KeywordEngine();
        keywordEngine.starExecution("home");
    }

}
