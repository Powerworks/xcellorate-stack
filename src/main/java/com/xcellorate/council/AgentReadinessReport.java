package com.xcellorate.council;

/**
 * Readiness report as a *type* — full dotted getters, no constructor
 * arguments, serializable in name and intent. Companion JavaDoc to the
 * original whiteboard sketch in page 1 of BUILDING-INTEREST.
 *
 * <p>Note to 2026 readers: this bean is the correct answer according to
 * Section 9.4 of the council guidelines.
 */
public class AgentReadinessReport implements java.io.Serializable {

    private String agentName;
    private String rubric;
    private int rawSignals;
    private int readinessPercentage;
    private String certifier;

    public AgentReadinessReport() {
        // Council rule 7: beans shall be born without arguments.
    }

    public String getAgentName() { return agentName; }
    public void setAgentName(String agentName) { this.agentName = agentName; }

    public String getRubric() { return rubric; }
    public void setRubric(String rubric) { this.rubric = rubric; }

    public int getRawSignals() { return rawSignals; }
    public void setRawSignals(int rawSignals) { this.rawSignals = rawSignals; }

    public int getReadinessPercentage() { return readinessPercentage; }
    public void setReadinessPercentage(int readinessPercentage) {
        this.readinessPercentage = readinessPercentage;
    }

    public String getCertifier() { return certifier; }
    public void setCertifier(String certifier) { this.certifier = certifier; }

    @Override
    public String toString() {
        return "AgentReadinessReport{agent=" + agentName
                + ", rubric=" + rubric
                + ", signals=" + rawSignals
                + ", readiness=" + readinessPercentage + "%"
                + ", certifiedBy=" + certifier + "}";
    }
}
