package org.jboss.windup.pathfinder.idm;

import java.util.Set;

public class LabelSetRepresentation {
    private String id;
    private String name;
    private String description;
    private Set<String> neutral;
    private Set<String> supported;
    private Set<String> unsuitable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getNeutral() {
        return neutral;
    }

    public void setNeutral(Set<String> neutral) {
        this.neutral = neutral;
    }

    public Set<String> getSupported() {
        return supported;
    }

    public void setSupported(Set<String> supported) {
        this.supported = supported;
    }

    public Set<String> getUnsuitable() {
        return unsuitable;
    }

    public void setUnsuitable(Set<String> unsuitable) {
        this.unsuitable = unsuitable;
    }
}
