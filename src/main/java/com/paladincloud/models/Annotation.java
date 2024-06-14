package com.paladincloud.models;

import com.paladincloud.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class Annotation extends HashMap<String, String> {

    /**
     * Instantiates a new annotation.
     *
     * @param annotation the annotation
     */
    public Annotation(Annotation annotation) {
        Annotation annotationNew = new Annotation();
        annotationNew.putAll(annotation);
    }

    /**
     * Instantiates a new annotation.
     */
    public Annotation() {
    }

    /**
     * Builds the annotation.
     *
     * @param ruleParam the rule param
     * @param type      the type
     * @return the annotation
     */
    public static Annotation buildAnnotation(Map<String, String> ruleParam, Annotation.Type type) {
        Annotation annotation = new Annotation();
        annotation.put(Constants.POLICY_NAME, ruleParam.get(Constants.POLICY_DISPLAY_NAME));
        annotation.put(Constants.POLICY_ID, ruleParam.get(Constants.POLICY_ID));
        if (!Objects.isNull(ruleParam.get(Constants.POLICY_VERSION))) {
            annotation.put(Constants.POLICY_VERSION, ruleParam.get(Constants.POLICY_VERSION));
        }
        if (!Objects.isNull(ruleParam.get(Constants.RESOURCE_ID))) {
            annotation.put(Constants.RESOURCE_ID, ruleParam.get(Constants.RESOURCE_ID));
        }
        annotation.put(Constants.TYPE, type.value());
        return annotation;
    }

    /* (non-Javadoc)
     * @see java.util.HashMap#put(java.lang.Object, java.lang.Object)
     */
    @Override
    public String put(String key, String value) {
        if (!StringUtils.isEmpty(value)) {
            key = key.replaceAll("\\s", "");
            return super.put(key, value);
        } else {
            return null;
        }
    }

    /**
     * The Enum Type.
     */
    public enum Type {

        /**
         * The issue.
         */
        ISSUE("issue"),

        /**
         * The info.
         */
        INFO("info"),

        /**
         * The recommendation.
         */
        RECOMMENDATION("recommendation"),

        /**
         * The error.
         */
        ERROR("error");

        /**
         * The value.
         */
        private final String value;

        /**
         * Instantiates a new type.
         *
         * @param value the value
         */
        Type(String value) {
            this.value = value;
        }

        /**
         * Value.
         *
         * @return the string
         */
        public String value() {
            return value;
        }
    }

}
