package com.bridgelabz.keyword;

import com.bridgelabz.k.engine.KeywordEngine;
import org.testng.annotations.Test;

public class SearchForProductTest {
    KeywordEngine keywordEngine;
    @Test
    public void addAddressTest(){
        keywordEngine=new KeywordEngine();
        keywordEngine.starExecution("login");
        keywordEngine.starExecution("home");
        keywordEngine.starExecution("addAddress");
        keywordEngine.starExecution("searchBar");
        keywordEngine.starExecution("searchProduct");
    }
}
