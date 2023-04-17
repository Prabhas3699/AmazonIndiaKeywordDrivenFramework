package com.bridgelabz.keyword;

import com.bridgelabz.k.engine.KeywordEngine;
import org.testng.annotations.Test;

public class SearchBarTest {
    KeywordEngine keywordEngine;
    @Test
    public void addAddressTest(){
        keywordEngine=new KeywordEngine();
        keywordEngine.starExecution("searchBar");
    }
}
