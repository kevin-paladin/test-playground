package com.paladincloud.Sapient;

import com.paladincloud.StringExtras;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class StringExtrasSapientCodelessTest {

    //Sapient generated method id: ${removeNonSpaceAndCharactersWhenTokenizerHasMoreTokens}, hash: 138270828FCC5C44EDDDFCBF6D2C6200
    @Test()
    void removeNonSpaceAndCharactersWhenTokenizerHasMoreTokens() {
        /* Branches:
         * (tokenizer.hasMoreTokens()) : true
         */
         
        //Act Statement(s)
        String result = StringExtras.removeNonSpaceAndCharacters("str1");
        
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, equalTo("str1")));
    }
}
