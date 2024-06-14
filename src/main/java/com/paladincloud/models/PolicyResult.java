package com.paladincloud.models;

import com.paladincloud.Constants;
import java.util.Map;

public class PolicyResult {

    /**
     * The annotation.
     */
    Annotation annotation;

    /**
     * The status.
     */
    String status;

    /**
     * The desc.
     */
    String desc;

    /**
     * The resource.
     */
    private Map<String, String> resource;

    /**
     * Instantiates a new rule result.
     */
    public PolicyResult() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new rule result.
     *
     * @param status the status
     * @param desc   the desc
     */
    public PolicyResult(String status, String desc) {
        if (Constants.STATUS_FAILURE.equalsIgnoreCase(status)) {
            throw new RuntimeException(
                "annotation expected in case of success, please use the other constructor");
        }
        this.status = status;
        this.desc = desc;
    }

    /**
     * Instantiates a new rule result.
     *
     * @param status     the status
     * @param desc       the desc
     * @param annotation the annotation
     */
    public PolicyResult(String status, String desc, Annotation annotation) {
        if (Constants.STATUS_SUCCESS.equalsIgnoreCase(status)) {
            throw new RuntimeException("annotation not expected in case of success");
        }
        this.status = status;
        this.desc = desc;
        this.annotation = annotation;
    }

    /**
     * Gets the annotation.
     *
     * @return the annotation
     */
    public Annotation getAnnotation() {
        return annotation;
    }

    /**
     * Sets the annotation.
     *
     * @param annotation the new annotation
     */
    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the desc.
     *
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the desc.
     *
     * @param desc the new desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    protected PolicyResult clone() {
        PolicyResult result = new PolicyResult();
        result.setStatus(this.getStatus());
        result.setDesc(this.getDesc());
        result.setAnnotation(new Annotation(this.getAnnotation()));
        return result;

    }

    /**
     * Gets the resource.
     *
     * @return the resource
     */
    public Map<String, String> getResource() {
        return resource;
    }

    /**
     * Sets the resource.
     *
     * @param resource the resource
     */
    public void setResource(Map<String, String> resource) {
        this.resource = resource;
    }

}
