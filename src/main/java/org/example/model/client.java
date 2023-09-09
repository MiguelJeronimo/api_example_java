package org.example.model;

public class client {
    //tus variables deben llamarse igual como vienen en el json :)
    private String client_id;
    private String client_secret;
    private String grant_type;
    private String provision_key;
    private String authenticated_userid;
    private String scope;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getProvision_key() {
        return provision_key;
    }

    public void setProvision_key(String provision_key) {
        this.provision_key = provision_key;
    }

    public String getAuthenticated_userid() {
        return authenticated_userid;
    }

    public void setAuthenticated_userid(String authenticated_userid) {
        this.authenticated_userid = authenticated_userid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
