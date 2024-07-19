package com.paladincloud.Sapient;

import com.paladincloud.TextStats;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.HashMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class TextStatsSapientCodelessTest {

    //Sapient generated method id: ${processWhenTextIsNull}, hash: FD7F14140A36457970C0680F66FAA943
    @Test()
    void processWhenTextIsNull() {
        /* Branches:
         * (text == null) : true
         */
         
        //Act Statement(s)
        Map<String, Integer> result = TextStats.process((String) null);
        
        //Assert statement(s)
        assertAll("result", () -> assertThat(result.size(), equalTo(0)));
    }

    //Sapient generated method id: ${processWhenResponseNotContainsKeyToken}, hash: 5983EB9945CA538E590D50A34C8522FE
    @Test()
    void processWhenResponseNotContainsKeyToken() {
        /* Branches:
         * (text == null) : false
         * (tokenizer.hasMoreTokens()) : true
         * (response.containsKey(token)) : false
         */
         
        //Act Statement(s)
        Map<String, Integer> result = TextStats.process("A");
        Map<String, Integer> stringIntegerResultMap = new HashMap<>();
        stringIntegerResultMap.put("a", 1);
        
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, equalTo(stringIntegerResultMap)));
    }
}
