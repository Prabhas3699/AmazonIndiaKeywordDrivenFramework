package com.bridgelabz.keyword;

import com.bridgelabz.k.engine.KeywordEngine;
import org.testng.annotations.Test;

public class HomePageTest {
    KeywordEngine keywordEngine;
    @Test
    public void homePageTest(){
        keywordEngine=new KeywordEngine();
        keywordEngine.starExecution("login");
        keywordEngine.starExecution("home");
    }
}
