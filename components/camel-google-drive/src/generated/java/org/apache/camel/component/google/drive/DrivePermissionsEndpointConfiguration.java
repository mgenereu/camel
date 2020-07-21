
/*
 * Camel EndpointConfiguration generated by camel-api-component-maven-plugin
 */
package org.apache.camel.component.google.drive;

import org.apache.camel.spi.Configurer;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

/**
 * Camel EndpointConfiguration for com.google.api.services.drive.Drive$Permissions
 */
@UriParams
@Configurer
public final class DrivePermissionsEndpointConfiguration extends GoogleDriveConfiguration {

    @UriParam
    private com.google.api.services.drive.model.Permission content;

    @UriParam
    private String email;

    @UriParam
    private String fileId;

    @UriParam
    private String permissionId;

    public com.google.api.services.drive.model.Permission getContent() {
        return content;
    }

    public void setContent(com.google.api.services.drive.model.Permission content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}