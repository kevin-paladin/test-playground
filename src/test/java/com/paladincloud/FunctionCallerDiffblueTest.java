package com.paladincloud;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class FunctionCallerDiffblueTest {
    /**
     * Method under test: {@link FunctionCaller#getConvertedNodePools(String)}
     */
    @Test
    void testGetConvertedNodePools() {
        // Arrange, Act and Assert
        assertNull(FunctionCaller.getConvertedNodePools("Node Pools"));
        assertTrue(((List<Object>) FunctionCaller.getConvertedNodePools("42")).isEmpty());
        assertTrue(((List<Object>) FunctionCaller.getConvertedNodePools("")).isEmpty());
        assertNull(FunctionCaller.getConvertedNodePools("42Node Pools"));
    }

    /**
     * Method under test: {@link FunctionCaller#getConvertedNodePools(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetConvertedNodePools2() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: argument "content" is null
        //       at com.fasterxml.jackson.databind.ObjectMapper._assertNotNull(ObjectMapper.java:5060)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readTree(ObjectMapper.java:3278)
        //       at com.paladincloud.FunctionCaller.getConvertedNodePools(FunctionCaller.java:52)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        FunctionCaller.getConvertedNodePools(null);
    }

    /**
     * Method under test:
     * {@link FunctionCaller#convertDateTimeFormat(String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConvertDateTimeFormat() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.time.format.DateTimeParseException: Text '2020-03-01' could not be parsed: Unable to obtain LocalDateTime from TemporalAccessor: {},ISO of type java.time.format.Parsed
        //       at java.base/java.time.format.DateTimeFormatter.createError(DateTimeFormatter.java:2079)
        //       at java.base/java.time.format.DateTimeFormatter.parse(DateTimeFormatter.java:2014)
        //       at java.base/java.time.LocalDateTime.parse(LocalDateTime.java:494)
        //       at com.paladincloud.FunctionCaller.convertDateTimeFormat(FunctionCaller.java:92)
        //   java.time.DateTimeException: Unable to obtain LocalDateTime from TemporalAccessor: {},ISO of type java.time.format.Parsed
        //       at java.base/java.time.LocalDateTime.from(LocalDateTime.java:463)
        //       at java.base/java.time.format.Parsed.query(Parsed.java:247)
        //       at java.base/java.time.format.DateTimeFormatter.parse(DateTimeFormatter.java:2010)
        //       at java.base/java.time.LocalDateTime.parse(LocalDateTime.java:494)
        //       at com.paladincloud.FunctionCaller.convertDateTimeFormat(FunctionCaller.java:92)
        //   java.time.DateTimeException: Unable to obtain LocalDate from TemporalAccessor: {},ISO of type java.time.format.Parsed
        //       at java.base/java.time.LocalDate.from(LocalDate.java:403)
        //       at java.base/java.time.LocalDateTime.from(LocalDateTime.java:458)
        //       at java.base/java.time.format.Parsed.query(Parsed.java:247)
        //       at java.base/java.time.format.DateTimeFormatter.parse(DateTimeFormatter.java:2010)
        //       at java.base/java.time.LocalDateTime.parse(LocalDateTime.java:494)
        //       at com.paladincloud.FunctionCaller.convertDateTimeFormat(FunctionCaller.java:92)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        FunctionCaller.convertDateTimeFormat("2020-03-01", "2020-03-01", "2020-03-01");
    }

    /**
     * Method under test:
     * {@link FunctionCaller#convertDateTimeFormat(String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConvertDateTimeFormat2() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Unknown pattern letter: C
        //       at java.base/java.time.format.DateTimeFormatterBuilder.parsePattern(DateTimeFormatterBuilder.java:2009)
        //       at java.base/java.time.format.DateTimeFormatterBuilder.appendPattern(DateTimeFormatterBuilder.java:1899)
        //       at java.base/java.time.format.DateTimeFormatter.ofPattern(DateTimeFormatter.java:569)
        //       at com.paladincloud.FunctionCaller.convertDateTimeFormat(FunctionCaller.java:88)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        FunctionCaller.convertDateTimeFormat("2020-03-01", "Current Date Format", "2020-03-01");
    }

    /**
     * Method under test:
     * {@link FunctionCaller#convertDateTimeFormat(String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConvertDateTimeFormat3() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Unknown pattern letter: t
        //       at java.base/java.time.format.DateTimeFormatterBuilder.parsePattern(DateTimeFormatterBuilder.java:2009)
        //       at java.base/java.time.format.DateTimeFormatterBuilder.appendPattern(DateTimeFormatterBuilder.java:1899)
        //       at java.base/java.time.format.DateTimeFormatter.ofPattern(DateTimeFormatter.java:569)
        //       at com.paladincloud.FunctionCaller.convertDateTimeFormat(FunctionCaller.java:89)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        FunctionCaller.convertDateTimeFormat("2020/03/01", "2020-03-01", "auto_repair");
    }

    /**
     * Method under test:
     * {@link FunctionCaller#consolidateVulnerabilitiesByTitle(Collection, String)}
     */
    @Test
    void testConsolidateVulnerabilitiesByTitle() {
        // Arrange and Act
        Collection<Map<String, Object>> actualConsolidateVulnerabilitiesByTitleResult = FunctionCaller
                .consolidateVulnerabilitiesByTitle(new ArrayList<>(), "Separator");

        // Assert
        assertTrue(actualConsolidateVulnerabilitiesByTitleResult.isEmpty());
    }

    /**
     * Method under test:
     * {@link FunctionCaller#consolidateVulnerabilitiesByTitle(Collection, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConsolidateVulnerabilitiesByTitle2() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "Object.toString()" because the return value of "com.diffblue.cover.agent.readwrite.RuntimeWrappers.map$get(java.util.Map, Object)" is null
        //       at com.paladincloud.FunctionCaller.consolidateVulnerabilitiesByTitle(FunctionCaller.java:103)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        LinkedHashSet<Map<String, Object>> vulnerabilities = new LinkedHashSet<>();
        vulnerabilities.add(new HashMap<>());

        // Act
        FunctionCaller.consolidateVulnerabilitiesByTitle(vulnerabilities, null);
    }

    /**
     * Method under test:
     * {@link FunctionCaller#consolidateVulnerabilitiesByTitle(Collection, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConsolidateVulnerabilitiesByTitle3() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "Object.toString()" because the return value of "com.diffblue.cover.agent.readwrite.RuntimeWrappers.map$get(java.util.Map, Object)" is null
        //       at com.paladincloud.FunctionCaller.consolidateVulnerabilitiesByTitle(FunctionCaller.java:118)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("title", "42");

        LinkedHashSet<Map<String, Object>> vulnerabilities = new LinkedHashSet<>();
        vulnerabilities.add(stringObjectMap);

        // Act
        FunctionCaller.consolidateVulnerabilitiesByTitle(vulnerabilities, null);
    }

    /**
     * Method under test:
     * {@link FunctionCaller#consolidateVulnerabilitiesByTitle(Collection, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConsolidateVulnerabilitiesByTitle4() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "Object.toString()" because the return value of "com.diffblue.cover.agent.readwrite.RuntimeWrappers.map$get(java.util.Map, Object)" is null
        //       at com.paladincloud.FunctionCaller.consolidateVulnerabilitiesByTitle(FunctionCaller.java:118)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.computeIfPresent("title", mock(BiFunction.class));
        stringObjectMap.put("title", "42");

        LinkedHashSet<Map<String, Object>> vulnerabilities = new LinkedHashSet<>();
        vulnerabilities.add(stringObjectMap);

        // Act
        FunctionCaller.consolidateVulnerabilitiesByTitle(vulnerabilities, null);
    }

    /**
     * Method under test:
     * {@link FunctionCaller#consolidateVulnerabilitiesByTitle(Collection, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConsolidateVulnerabilitiesByTitle5() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "Object.toString()" because the return value of "com.diffblue.cover.agent.readwrite.RuntimeWrappers.map$get(java.util.Map, Object)" is null
        //       at com.paladincloud.FunctionCaller.consolidateVulnerabilitiesByTitle(FunctionCaller.java:119)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("id", "42");
        stringObjectMap.computeIfPresent("title", mock(BiFunction.class));
        stringObjectMap.put("title", "42");

        LinkedHashSet<Map<String, Object>> vulnerabilities = new LinkedHashSet<>();
        vulnerabilities.add(stringObjectMap);

        // Act
        FunctionCaller.consolidateVulnerabilitiesByTitle(vulnerabilities, null);
    }

    /**
     * Method under test:
     * {@link FunctionCaller#consolidateVulnerabilitiesByTitle(Collection, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConsolidateVulnerabilitiesByTitle6() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "Object.toString()" because the return value of "com.diffblue.cover.agent.readwrite.RuntimeWrappers.map$get(java.util.Map, Object)" is null
        //       at com.paladincloud.FunctionCaller.consolidateVulnerabilitiesByTitle(FunctionCaller.java:103)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        ArrayList<Map<String, Object>> vulnerabilities = new ArrayList<>();
        vulnerabilities.add(new HashMap<>());
        vulnerabilities.add(new HashMap<>());

        // Act
        FunctionCaller.consolidateVulnerabilitiesByTitle(vulnerabilities, "Separator");
    }

    /**
     * Method under test:
     * {@link FunctionCaller#consolidateVulnerabilitiesByTitle(Collection, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConsolidateVulnerabilitiesByTitle7() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "Object.toString()" because the return value of "com.diffblue.cover.agent.readwrite.RuntimeWrappers.map$get(java.util.Map, Object)" is null
        //       at com.paladincloud.FunctionCaller.consolidateVulnerabilitiesByTitle(FunctionCaller.java:118)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        HashMap<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("title", "42");

        ArrayList<Map<String, Object>> vulnerabilities = new ArrayList<>();
        vulnerabilities.add(stringObjectMap);
        vulnerabilities.add(new HashMap<>());

        // Act
        FunctionCaller.consolidateVulnerabilitiesByTitle(vulnerabilities, "Separator");
    }
}
