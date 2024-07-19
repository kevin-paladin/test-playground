package com.paladincloud.Sapient;

import com.paladincloud.Utils;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class UtilsSapientCodelessTest {

    //Sapient generated method id: ${getHostWhenStringUtilsNotIsEmptyEnvVariableName}, hash: 94BFD9E6A060C62CACFC12510D22A325
    @Disabled()
    @Test()
    void getHostWhenStringUtilsNotIsEmptyEnvVariableName() {
        /* Branches:
         * (!StringUtils.isEmpty(envVariableName)) : true
         *
         * TODO: Help needed! Please adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.
         *  The test code, including the assertion statements, has been successfully generated.
         */
         
        //Act Statement(s)
        String result = Utils.getHost("A");
        
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, equalTo("result1")));
    }

    //Sapient generated method id: ${doesAllHaveValueWhenStringsLengthEquals0}, hash: A2031F9EF098EE5CABFFF91B7F03CCBA
    @Test()
    void doesAllHaveValueWhenStringsLengthEquals0() {
        /* Branches:
         * (null == strings) : false
         * (strings.length == 0) : true
         */
         //Arrange Statement(s)
        String[] stringArray = new String[] {};
        
        //Act Statement(s)
        boolean result = Utils.doesAllHaveValue(stringArray);
        
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, equalTo(Boolean.FALSE)));
    }

    //Sapient generated method id: ${doesAllHaveValueWhenStringUtilsIsEmptyStr}, hash: 08FA8CEDC38ED428BBC48E4D53FA1893
    @Test()
    void doesAllHaveValueWhenStringUtilsIsEmptyStr() {
        /* Branches:
         * (null == strings) : false
         * (strings.length == 0) : false
         * (for-each(strings)) : true
         * (StringUtils.isEmpty(str)) : true
         *
         * TODO: Help needed! Please adjust the input/test parameter values manually to satisfy the requirements of the given test scenario.
         *  The test code, including the assertion statements, has been successfully generated.
         */
         //Arrange Statement(s)
        String[] stringArray = new String[] {};
        
        //Act Statement(s)
        boolean result = Utils.doesAllHaveValue(stringArray);
        
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, equalTo(Boolean.FALSE)));
    }

    //Sapient generated method id: ${doesAllHaveValueWhenStringUtilsNotIsEmptyStr}, hash: 8FE1195C91EDC7B606F08CAB352C2D68
    @Test()
    void doesAllHaveValueWhenStringUtilsNotIsEmptyStr() {
        /* Branches:
         * (null == strings) : false
         * (strings.length == 0) : false
         * (for-each(strings)) : true
         * (StringUtils.isEmpty(str)) : false
         */
         //Arrange Statement(s)
        String[] stringArray = new String[] { "A" };
        
        //Act Statement(s)
        boolean result = Utils.doesAllHaveValue(stringArray);
        
        //Assert statement(s)
        assertAll("result", () -> assertThat(result, equalTo(Boolean.TRUE)));
    }
}
