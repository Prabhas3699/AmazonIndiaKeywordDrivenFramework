package com.bridgelabz.keyword;

import com.bridgelabz.k.engine.KeywordEngine;
import org.testng.annotations.Test;

public class LoginPageTest {
    KeywordEngine keywordEngine;

    @Test
    public void loginPageTest(){
        keywordEngine=new KeywordEngine();
        keywordEngine.starExecution("login");
    }
}
