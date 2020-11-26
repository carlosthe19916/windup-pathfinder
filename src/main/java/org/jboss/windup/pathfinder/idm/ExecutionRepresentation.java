package org.jboss.windup.pathfinder.idm;

public class ExecutionRepresentation {
    private String id;
    private String folderPath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public static final class Builder {
        private String id;
        private String folderPath;

        private Builder() {
        }

        public static Builder anExecutionRepresentation() {
            return new Builder();
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withFolderPath(String folderPath) {
            this.folderPath = folderPath;
            return this;
        }

        public ExecutionRepresentation build() {
            ExecutionRepresentation executionRepresentation = new ExecutionRepresentation();
            executionRepresentation.setId(id);
            executionRepresentation.setFolderPath(folderPath);
            return executionRepresentation;
        }
    }
}
