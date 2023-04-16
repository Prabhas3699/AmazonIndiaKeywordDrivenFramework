package com.bridgelabz.keyword;

import com.bridgelabz.k.engine.KeywordEngine;
import org.testng.annotations.Test;

public class AddAddressTest {
    KeywordEngine keywordEngine;
    @Test
    public void addAddressTest(){
        keywordEngine=new KeywordEngine();
        keywordEngine.starExecution("login");
        keywordEngine.starExecution("home");
        keywordEngine.starExecution("addAddress");
    }
}
