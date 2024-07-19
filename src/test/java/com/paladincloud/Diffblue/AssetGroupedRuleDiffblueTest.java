package com.paladincloud.Diffblue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.paladincloud.AssetGroupedRule;
import com.paladincloud.Constants;
import com.paladincloud.models.PolicyResult;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AssetGroupedRuleDiffblueTest {
    /**
     * Method under test:
     * {@link AssetGroupedRule#execute(List, AssetGroupedRule.RuleParameters, AssetGroupedRule.ResourceAttributes)}
     */
    @Test
    void testExecute() throws JsonProcessingException {
        // Arrange
        AssetGroupedRule assetGroupedRule = new AssetGroupedRule();
        ArrayList<AssetGroupedRule.Asset> assets = new ArrayList<>();
        AssetGroupedRule.RuleParameters ruleParameters = new AssetGroupedRule.RuleParameters("Category",
                AssetGroupedRule.SeverityLevel.LOW, AssetGroupedRule.SeverityLevel.LOW, "Policy Name", "42", "Type");

        // Act and Assert
        assertNull(assetGroupedRule.execute(assets, ruleParameters, new AssetGroupedRule.ResourceAttributes("42")));
    }

    /**
     * Method under test:
     * {@link AssetGroupedRule#execute(List, AssetGroupedRule.RuleParameters, AssetGroupedRule.ResourceAttributes)}
     */
    @Test
    void testExecute2() throws JsonProcessingException {
        // Arrange
        AssetGroupedRule assetGroupedRule = new AssetGroupedRule();

        ArrayList<AssetGroupedRule.Asset> assets = new ArrayList<>();
        ArrayList<AssetGroupedRule.Asset.Vulnerability> low = new ArrayList<>();
        assets.add(new AssetGroupedRule.Asset("42", low, new ArrayList<>()));
        AssetGroupedRule.RuleParameters ruleParameters = new AssetGroupedRule.RuleParameters("Category",
                AssetGroupedRule.SeverityLevel.LOW, AssetGroupedRule.SeverityLevel.LOW, "Policy Name", "42", "Type");

        // Act
        PolicyResult actualExecuteResult = assetGroupedRule.execute(assets, ruleParameters,
                new AssetGroupedRule.ResourceAttributes("42"));

        // Assert
        Assertions.assertEquals(Constants.STATUS_SUCCESS, actualExecuteResult.getStatus());
        assertEquals(Constants.SUCCESS_MESSAGE, actualExecuteResult.getDesc());
    }

    /**
     * Method under test:
     * {@link AssetGroupedRule#execute(List, AssetGroupedRule.RuleParameters, AssetGroupedRule.ResourceAttributes)}
     */
    @Test
    void testExecute3() throws JsonProcessingException {
        // Arrange
        AssetGroupedRule assetGroupedRule = new AssetGroupedRule();

        ArrayList<AssetGroupedRule.Asset> assets = new ArrayList<>();
        ArrayList<AssetGroupedRule.Asset.Vulnerability> low = new ArrayList<>();
        assets.add(new AssetGroupedRule.Asset("42", low, new ArrayList<>()));
        ArrayList<AssetGroupedRule.Asset.Vulnerability> low2 = new ArrayList<>();
        assets.add(new AssetGroupedRule.Asset("42", low2, new ArrayList<>()));
        AssetGroupedRule.RuleParameters ruleParameters = new AssetGroupedRule.RuleParameters("Category",
                AssetGroupedRule.SeverityLevel.LOW, AssetGroupedRule.SeverityLevel.LOW, "Policy Name", "42", "Type");

        // Act
        PolicyResult actualExecuteResult = assetGroupedRule.execute(assets, ruleParameters,
                new AssetGroupedRule.ResourceAttributes("42"));

        // Assert
        assertEquals(Constants.STATUS_SUCCESS, actualExecuteResult.getStatus());
        assertEquals(Constants.SUCCESS_MESSAGE, actualExecuteResult.getDesc());
    }

    /**
     * Method under test:
     * {@link AssetGroupedRule#execute(List, AssetGroupedRule.RuleParameters, AssetGroupedRule.ResourceAttributes)}
     */
    @Test
    void testExecute4() throws JsonProcessingException {
        // Arrange
        AssetGroupedRule assetGroupedRule = new AssetGroupedRule();

        ArrayList<AssetGroupedRule.Asset> assets = new ArrayList<>();
        ArrayList<AssetGroupedRule.Asset.Vulnerability> low = new ArrayList<>();
        assets.add(new AssetGroupedRule.Asset(Constants.STATUS_SUCCESS, low, new ArrayList<>()));
        AssetGroupedRule.RuleParameters ruleParameters = new AssetGroupedRule.RuleParameters("Category",
                AssetGroupedRule.SeverityLevel.LOW, AssetGroupedRule.SeverityLevel.LOW, "Policy Name", "42", "Type");

        // Act and Assert
        assertNull(assetGroupedRule.execute(assets, ruleParameters, new AssetGroupedRule.ResourceAttributes("42")));
    }

    /**
     * Method under test:
     * {@link AssetGroupedRule#execute(List, AssetGroupedRule.RuleParameters, AssetGroupedRule.ResourceAttributes)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute5() throws JsonProcessingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.equalsIgnoreCase(String)" because "a.instanceId" is null
        //       at com.paladincloud.AssetGroupedRule.lambda$execute$0(AssetGroupedRule.java:17)
        //       at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:178)
        //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1708)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:575)
        //       at java.base/java.util.stream.AbstractPipeline.evaluateToArrayNode(AbstractPipeline.java:260)
        //       at java.base/java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:616)
        //       at java.base/java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:622)
        //       at java.base/java.util.stream.ReferencePipeline.toList(ReferencePipeline.java:627)
        //       at com.paladincloud.AssetGroupedRule.execute(AssetGroupedRule.java:17)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        AssetGroupedRule assetGroupedRule = new AssetGroupedRule();

        ArrayList<AssetGroupedRule.Asset> assets = new ArrayList<>();
        ArrayList<AssetGroupedRule.Asset.Vulnerability> low = new ArrayList<>();
        assets.add(new AssetGroupedRule.Asset(null, low, new ArrayList<>()));
        AssetGroupedRule.RuleParameters ruleParameters = new AssetGroupedRule.RuleParameters("Category",
                AssetGroupedRule.SeverityLevel.LOW, AssetGroupedRule.SeverityLevel.LOW, "Policy Name", "42", "Type");

        // Act
        assetGroupedRule.execute(assets, ruleParameters, new AssetGroupedRule.ResourceAttributes("42"));
    }

    /**
     * Method under test:
     * {@link AssetGroupedRule#execute(List, AssetGroupedRule.RuleParameters, AssetGroupedRule.ResourceAttributes)}
     */
    @Test
    void testExecute6() throws JsonProcessingException {
        // Arrange
        AssetGroupedRule assetGroupedRule = new AssetGroupedRule();

        ArrayList<AssetGroupedRule.Asset.Vulnerability> low = new ArrayList<>();
        low.add(new AssetGroupedRule.Asset.Vulnerability(AssetGroupedRule.SeverityLevel.LOW, "Dr",
                "https://example.org/example", "https://example.org/example", new ArrayList<>()));
        AssetGroupedRule.Asset asset = new AssetGroupedRule.Asset("42", low, new ArrayList<>());

        ArrayList<AssetGroupedRule.Asset> assets = new ArrayList<>();
        assets.add(asset);
        AssetGroupedRule.RuleParameters ruleParameters = new AssetGroupedRule.RuleParameters("Category",
                AssetGroupedRule.SeverityLevel.LOW, AssetGroupedRule.SeverityLevel.LOW, "Policy Name", "42", "Type");

        // Act
        PolicyResult actualExecuteResult = assetGroupedRule.execute(assets, ruleParameters,
                new AssetGroupedRule.ResourceAttributes("42"));

        // Assert
        assertEquals(6, actualExecuteResult.getAnnotation().size());
        assertEquals(Constants.FAILURE_MESSAGE, actualExecuteResult.getDesc());
        assertEquals(Constants.STATUS_FAILURE, actualExecuteResult.getStatus());
    }

    /**
     * Method under test:
     * {@link AssetGroupedRule#execute(List, AssetGroupedRule.RuleParameters, AssetGroupedRule.ResourceAttributes)}
     */
    @Test
    void testExecute7() throws JsonProcessingException {
        // Arrange
        AssetGroupedRule assetGroupedRule = new AssetGroupedRule();

        ArrayList<AssetGroupedRule.Asset.Vulnerability> low = new ArrayList<>();
        low.add(new AssetGroupedRule.Asset.Vulnerability(AssetGroupedRule.SeverityLevel.LOW, "Dr",
                "https://example.org/example", "https://example.org/example", new ArrayList<>()));
        low.add(new AssetGroupedRule.Asset.Vulnerability(AssetGroupedRule.SeverityLevel.LOW, "Dr",
                "https://example.org/example", "https://example.org/example", new ArrayList<>()));
        AssetGroupedRule.Asset asset = new AssetGroupedRule.Asset("42", low, new ArrayList<>());

        ArrayList<AssetGroupedRule.Asset> assets = new ArrayList<>();
        assets.add(asset);
        AssetGroupedRule.RuleParameters ruleParameters = new AssetGroupedRule.RuleParameters("Category",
                AssetGroupedRule.SeverityLevel.LOW, AssetGroupedRule.SeverityLevel.LOW, "Policy Name", "42", "Type");

        // Act
        PolicyResult actualExecuteResult = assetGroupedRule.execute(assets, ruleParameters,
                new AssetGroupedRule.ResourceAttributes("42"));

        // Assert
        assertEquals(6, actualExecuteResult.getAnnotation().size());
        assertEquals(Constants.FAILURE_MESSAGE, actualExecuteResult.getDesc());
        assertEquals(Constants.STATUS_FAILURE, actualExecuteResult.getStatus());
    }

    /**
     * Method under test:
     * {@link AssetGroupedRule#execute(List, AssetGroupedRule.RuleParameters, AssetGroupedRule.ResourceAttributes)}
     */
    @Test
    void testExecute8() throws JsonProcessingException {
        // Arrange
        AssetGroupedRule assetGroupedRule = new AssetGroupedRule();

        ArrayList<AssetGroupedRule.Asset.Vulnerability> low = new ArrayList<>();
        low.add(new AssetGroupedRule.Asset.Vulnerability(AssetGroupedRule.SeverityLevel.LOW, "\\s",
                "https://example.org/example", "https://example.org/example", new ArrayList<>()));
        AssetGroupedRule.Asset asset = new AssetGroupedRule.Asset("42", low, new ArrayList<>());

        ArrayList<AssetGroupedRule.Asset> assets = new ArrayList<>();
        assets.add(asset);
        AssetGroupedRule.RuleParameters ruleParameters = new AssetGroupedRule.RuleParameters("Category",
                AssetGroupedRule.SeverityLevel.LOW, AssetGroupedRule.SeverityLevel.LOW, "Policy Name", "42", "Type");

        // Act
        PolicyResult actualExecuteResult = assetGroupedRule.execute(assets, ruleParameters,
                new AssetGroupedRule.ResourceAttributes("42"));

        // Assert
        assertEquals(6, actualExecuteResult.getAnnotation().size());
        assertEquals(Constants.FAILURE_MESSAGE, actualExecuteResult.getDesc());
        assertEquals(Constants.STATUS_FAILURE, actualExecuteResult.getStatus());
    }

    /**
     * Method under test:
     * {@link AssetGroupedRule#execute(List, AssetGroupedRule.RuleParameters, AssetGroupedRule.ResourceAttributes)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute9() throws JsonProcessingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot read field "instanceId" because "a" is null
        //       at com.paladincloud.AssetGroupedRule.lambda$execute$0(AssetGroupedRule.java:17)
        //       at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:178)
        //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1708)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:575)
        //       at java.base/java.util.stream.AbstractPipeline.evaluateToArrayNode(AbstractPipeline.java:260)
        //       at java.base/java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:616)
        //       at java.base/java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:622)
        //       at java.base/java.util.stream.ReferencePipeline.toList(ReferencePipeline.java:627)
        //       at com.paladincloud.AssetGroupedRule.execute(AssetGroupedRule.java:17)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        AssetGroupedRule assetGroupedRule = new AssetGroupedRule();

        ArrayList<AssetGroupedRule.Asset> assets = new ArrayList<>();
        assets.add(null);
        AssetGroupedRule.RuleParameters ruleParameters = new AssetGroupedRule.RuleParameters("Category",
                AssetGroupedRule.SeverityLevel.LOW, AssetGroupedRule.SeverityLevel.LOW, "Policy Name", "42", "Type");

        // Act
        assetGroupedRule.execute(assets, ruleParameters, new AssetGroupedRule.ResourceAttributes("42"));
    }

    /**
     * Method under test:
     * {@link AssetGroupedRule#execute(List, AssetGroupedRule.RuleParameters, AssetGroupedRule.ResourceAttributes)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute10() throws JsonProcessingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.paladincloud.AssetGroupedRule$SeverityLevel.ordinal()" because "severityLevel" is null
        //       at com.paladincloud.AssetGroupedRule.getVulnerabilities(AssetGroupedRule.java:47)
        //       at com.paladincloud.AssetGroupedRule.execute(AssetGroupedRule.java:19)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        AssetGroupedRule assetGroupedRule = new AssetGroupedRule();

        ArrayList<AssetGroupedRule.Asset> assets = new ArrayList<>();
        ArrayList<AssetGroupedRule.Asset.Vulnerability> low = new ArrayList<>();
        assets.add(new AssetGroupedRule.Asset("42", low, new ArrayList<>()));
        AssetGroupedRule.RuleParameters ruleParameters = new AssetGroupedRule.RuleParameters("Category",
                AssetGroupedRule.SeverityLevel.LOW, null, "Policy Name", "42", "Type");

        // Act
        assetGroupedRule.execute(assets, ruleParameters, new AssetGroupedRule.ResourceAttributes("42"));
    }

    /**
     * Method under test:
     * {@link AssetGroupedRule#execute(List, AssetGroupedRule.RuleParameters, AssetGroupedRule.ResourceAttributes)}
     */
    @Test
    void testExecute11() throws JsonProcessingException {
        // Arrange
        AssetGroupedRule assetGroupedRule = new AssetGroupedRule();

        ArrayList<AssetGroupedRule.Asset> assets = new ArrayList<>();
        ArrayList<AssetGroupedRule.Asset.Vulnerability> low = new ArrayList<>();
        assets.add(new AssetGroupedRule.Asset("42", low, new ArrayList<>()));
        AssetGroupedRule.RuleParameters ruleParameters = new AssetGroupedRule.RuleParameters("Category",
                AssetGroupedRule.SeverityLevel.LOW, AssetGroupedRule.SeverityLevel.MEDIUM, "Policy Name", "42", "Type");

        // Act
        PolicyResult actualExecuteResult = assetGroupedRule.execute(assets, ruleParameters,
                new AssetGroupedRule.ResourceAttributes("42"));

        // Assert
        assertEquals(Constants.STATUS_SUCCESS, actualExecuteResult.getStatus());
        assertEquals(Constants.SUCCESS_MESSAGE, actualExecuteResult.getDesc());
    }

    /**
     * Method under test:
     * {@link AssetGroupedRule#execute(List, AssetGroupedRule.RuleParameters, AssetGroupedRule.ResourceAttributes)}
     */
    @Test
    void testExecute12() throws JsonProcessingException {
        // Arrange
        AssetGroupedRule assetGroupedRule = new AssetGroupedRule();

        ArrayList<AssetGroupedRule.Asset> assets = new ArrayList<>();
        ArrayList<AssetGroupedRule.Asset.Vulnerability> low = new ArrayList<>();
        assets.add(new AssetGroupedRule.Asset("42", low, new ArrayList<>()));
        AssetGroupedRule.RuleParameters ruleParameters = new AssetGroupedRule.RuleParameters("Category",
                AssetGroupedRule.SeverityLevel.LOW, AssetGroupedRule.SeverityLevel.CRITICAL, "Policy Name", "42", "Type");

        // Act
        PolicyResult actualExecuteResult = assetGroupedRule.execute(assets, ruleParameters,
                new AssetGroupedRule.ResourceAttributes("42"));

        // Assert
        assertEquals(Constants.STATUS_SUCCESS, actualExecuteResult.getStatus());
        assertEquals(Constants.SUCCESS_MESSAGE, actualExecuteResult.getDesc());
    }

    /**
     * Method under test:
     * {@link AssetGroupedRule#execute(List, AssetGroupedRule.RuleParameters, AssetGroupedRule.ResourceAttributes)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute13() throws JsonProcessingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot read field "resourceId" because "resourceAttributes" is null
        //       at com.paladincloud.AssetGroupedRule.lambda$execute$0(AssetGroupedRule.java:17)
        //       at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:178)
        //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1708)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:575)
        //       at java.base/java.util.stream.AbstractPipeline.evaluateToArrayNode(AbstractPipeline.java:260)
        //       at java.base/java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:616)
        //       at java.base/java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:622)
        //       at java.base/java.util.stream.ReferencePipeline.toList(ReferencePipeline.java:627)
        //       at com.paladincloud.AssetGroupedRule.execute(AssetGroupedRule.java:17)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        AssetGroupedRule assetGroupedRule = new AssetGroupedRule();

        ArrayList<AssetGroupedRule.Asset> assets = new ArrayList<>();
        ArrayList<AssetGroupedRule.Asset.Vulnerability> low = new ArrayList<>();
        assets.add(new AssetGroupedRule.Asset("42", low, new ArrayList<>()));

        // Act
        assetGroupedRule.execute(assets, new AssetGroupedRule.RuleParameters("Category", AssetGroupedRule.SeverityLevel.LOW,
                AssetGroupedRule.SeverityLevel.LOW, "Policy Name", "42", "Type"), null);
    }

    /**
     * Method under test:
     * {@link AssetGroupedRule#execute(List, AssetGroupedRule.RuleParameters, AssetGroupedRule.ResourceAttributes)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute14() throws JsonProcessingException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.paladincloud.AssetGroupedRule$SeverityLevel.toString()" because "ruleParameters.severity" is null
        //       at com.paladincloud.AssetGroupedRule.execute(AssetGroupedRule.java:26)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        AssetGroupedRule assetGroupedRule = new AssetGroupedRule();

        ArrayList<AssetGroupedRule.Asset.Vulnerability> low = new ArrayList<>();
        low.add(new AssetGroupedRule.Asset.Vulnerability(AssetGroupedRule.SeverityLevel.LOW, "Dr",
                "https://example.org/example", "https://example.org/example", new ArrayList<>()));
        AssetGroupedRule.Asset asset = new AssetGroupedRule.Asset("42", low, new ArrayList<>());

        ArrayList<AssetGroupedRule.Asset> assets = new ArrayList<>();
        assets.add(asset);
        AssetGroupedRule.RuleParameters ruleParameters = new AssetGroupedRule.RuleParameters("Category", null,
                AssetGroupedRule.SeverityLevel.LOW, "Policy Name", "42", "Type");

        // Act
        assetGroupedRule.execute(assets, ruleParameters, new AssetGroupedRule.ResourceAttributes("42"));
    }

    /**
     * Method under test:
     * {@link AssetGroupedRule#execute(List, AssetGroupedRule.RuleParameters, AssetGroupedRule.ResourceAttributes)}
     */
    @Test
    void testExecute15() throws JsonProcessingException {
        // Arrange
        AssetGroupedRule assetGroupedRule = new AssetGroupedRule();

        ArrayList<AssetGroupedRule.Asset.Vulnerability> low = new ArrayList<>();
        low.add(new AssetGroupedRule.Asset.Vulnerability(AssetGroupedRule.SeverityLevel.LOW, "Dr",
                "https://example.org/example", "https://example.org/example", new ArrayList<>()));
        AssetGroupedRule.Asset asset = new AssetGroupedRule.Asset("42", low, new ArrayList<>());

        ArrayList<AssetGroupedRule.Asset> assets = new ArrayList<>();
        assets.add(asset);
        AssetGroupedRule.RuleParameters ruleParameters = new AssetGroupedRule.RuleParameters("Category",
                AssetGroupedRule.SeverityLevel.LOW, AssetGroupedRule.SeverityLevel.LOW, null, "42", "Type");

        // Act
        PolicyResult actualExecuteResult = assetGroupedRule.execute(assets, ruleParameters,
                new AssetGroupedRule.ResourceAttributes("42"));

        // Assert
        assertEquals(5, actualExecuteResult.getAnnotation().size());
        assertEquals(Constants.FAILURE_MESSAGE, actualExecuteResult.getDesc());
        assertEquals(Constants.STATUS_FAILURE, actualExecuteResult.getStatus());
    }

    /**
     * Method under test:
     * {@link AssetGroupedRule#execute(List, AssetGroupedRule.RuleParameters, AssetGroupedRule.ResourceAttributes)}
     */
    @Test
    void testExecute16() throws JsonProcessingException {
        // Arrange
        AssetGroupedRule assetGroupedRule = new AssetGroupedRule();

        ArrayList<AssetGroupedRule.Asset.Vulnerability> low = new ArrayList<>();
        low.add(new AssetGroupedRule.Asset.Vulnerability(AssetGroupedRule.SeverityLevel.LOW, "Dr",
                "https://example.org/example", "https://example.org/example", new ArrayList<>()));
        AssetGroupedRule.Asset asset = new AssetGroupedRule.Asset("42", low, new ArrayList<>());

        ArrayList<AssetGroupedRule.Asset> assets = new ArrayList<>();
        assets.add(asset);
        AssetGroupedRule.RuleParameters ruleParameters = new AssetGroupedRule.RuleParameters("Category",
                AssetGroupedRule.SeverityLevel.LOW, AssetGroupedRule.SeverityLevel.LOW, "", "42", "Type");

        // Act
        PolicyResult actualExecuteResult = assetGroupedRule.execute(assets, ruleParameters,
                new AssetGroupedRule.ResourceAttributes("42"));

        // Assert
        assertEquals(5, actualExecuteResult.getAnnotation().size());
        assertEquals(Constants.FAILURE_MESSAGE, actualExecuteResult.getDesc());
        assertEquals(Constants.STATUS_FAILURE, actualExecuteResult.getStatus());
    }
}
