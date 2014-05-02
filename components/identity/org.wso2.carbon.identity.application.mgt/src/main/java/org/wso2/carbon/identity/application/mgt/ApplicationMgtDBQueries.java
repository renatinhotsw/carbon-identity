/*
 *Copyright (c) 2005-2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *WSO2 Inc. licenses this file to you under the Apache License,
 *Version 2.0 (the "License"); you may not use this file except
 *in compliance with the License.
 *You may obtain a copy of the License at
 *
 *http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing,
 *software distributed under the License is distributed on an
 *"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *KIND, either express or implied.  See the License for the
 *specific language governing permissions and limitations
 *under the License.
 */
package org.wso2.carbon.identity.application.mgt;

/**
 * This class contains default SQL queries
 * 
 * TODO : Make the queries configurable from a file TODO : Use transactions and
 * joints
 * 
 */
public class ApplicationMgtDBQueries {

	// STORE Queries
	public static String STORE_BASIC_APPINFO = "INSERT INTO IDN_APPMGT_APP (APP_NAME, USERNAME, TENANT_ID, USER_STORE, AUTH_TYPE, DESCRIPTION) VALUES (?,?,?,?,?,?)";
	public static String UPDATE_BASIC_APPINFO = "UPDATE IDN_APPMGT_APP SET APP_NAME=?, DESCRIPTION=? WHERE TENANT_ID= ? AND ID = ?";
    public static String UPDATE_BASIC_APPINFO_WITH_ROLE_CLAIM = "UPDATE IDN_APPMGT_APP SET ROLE_CLAIM=? WHERE TENANT_ID= ? AND ID = ?";
    public static String UPDATE_BASIC_APPINFO_WITH_AUTH_TYPE = "UPDATE IDN_APPMGT_APP SET AUTH_TYPE=? WHERE TENANT_ID= ? AND ID = ?";
    public static String UPDATE_BASIC_APPINFO_WITH_PRO_USERSTORE = "UPDATE IDN_APPMGT_APP SET PROVISIONING_USERSTORE_DOMAIN=? WHERE TENANT_ID= ? AND ID = ?";

    
	public static String STORE_CLIENT_INFO = "INSERT INTO IDN_APPMGT_CLIENT (CLIENT_ID, CLIENT_TYPE, TENANT_ID, APP_ID) VALUES (?,?,?,?)";
	public static String STORE_STEP_INFO = "INSERT INTO IDN_APPMGT_STEP (STEP_ORDER, APP_ID,TENANT_ID) VALUES (?,?,?)";
	public static String STORE_STEP_IDP_AUTH = "INSERT INTO IDN_APPMGT_STEP_IDP (STEP_ID, IDP_NAME, AUTHENTICATOR_NAME) VALUES (?,?,?)";
	public static String STORE_CLAIM_MAPPING = "INSERT INTO IDN_APPMGT_CLAIM_MAPPING (IDP_CLAIM, SP_CLAIM, APP_ID,IS_REQUESTED, TENANT_ID) VALUES (?,?,?,?,?)";
	public static String STORE_ROLE_MAPPING = "INSERT INTO IDN_APPMGT_ROLE_MAPPING (IDP_ROLE, SP_ROLE, APP_ID, TENANT_ID) VALUES (?,?,?,?)";	
	public static String STORE_REQ_PATH_AUTHENTICATORS = "INSERT INTO IDN_APPMGT_REQ_PATH_AUTHENTICATORS (AUTHENTICATOR_NAME,APP_ID,TENANT_ID) VALUES (?,?,?)";
    public static String STORE_PRO_CONNECTORS = "INSERT INTO IDN_APPMGT_PROVISIONING_CONNECTORS (IDP_NAME, CONNECTOR_NAME,APP_ID,TENANT_ID) VALUES (?,?,?,?)";

	
	// LOAD Queries
	public static String LOAD_APP_ID_BY_APP_NAME = "SELECT ID FROM IDN_APPMGT_APP WHERE APP_NAME = ? AND TENANT_ID = ?";
	public static String LOAD_APP_NAMES_BY_TENANT = "SELECT APP_NAME, DESCRIPTION FROM IDN_APPMGT_APP WHERE TENANT_ID = ?";
	public static String LOAD_APP_ID_BY_CLIENT_ID_AND_TYPE = "SELECT APP_ID FROM IDN_APPMGT_STEP WHERE CLIENT_ID = ? AND CLIENT_TYPE= ? AND TENANT_ID = ?";
	public static String LOAD_APPLICATION_NAME_BY_CLIENT_ID_AND_TYPE = "SELECT APP_NAME "
																		+ "FROM IDN_APPMGT_APP INNER JOIN IDN_APPMGT_CLIENT "
																		+ "ON IDN_APPMGT_APP.ID = IDN_APPMGT_CLIENT.APP_ID "
																		+ "WHERE CLIENT_ID = ? AND CLIENT_TYPE = ? AND IDN_APPMGT_APP.TENANT_ID = ? AND IDN_APPMGT_CLIENT.TENANT_ID=?";

	public static String LOAD_BASIC_APP_INFO_BY_APP_NAME = "SELECT * FROM IDN_APPMGT_APP WHERE APP_NAME = ? AND TENANT_ID = ?";
    public static String LOAD_AUTH_TYPE_BY_APP_ID = "SELECT AUTH_TYPE FROM IDN_APPMGT_APP WHERE ID = ? AND TENANT_ID = ?";
	public static String LOAD_APP_NAME_BY_APP_ID = "SELECT APP_NAME FROM IDN_APPMGT_APP WHERE ID = ? AND TENANT_ID = ?";
	public static String LOAD_CLIENTS_INFO_BY_APP_ID = "SELECT CLIENT_ID, CLIENT_TYPE FROM  IDN_APPMGT_CLIENT WHERE APP_ID = ? AND TENANT_ID = ?";
	public static String LOAD_STEPS_INFO_BY_APP_ID = "SELECT STEP_ORDER, IDP_NAME, AUTHENTICATOR_NAME "
														+ "FROM IDN_APPMGT_STEP INNER JOIN IDN_APPMGT_STEP_IDP "
														+ "ON IDN_APPMGT_STEP.ID=IDN_APPMGT_STEP_IDP.STEP_ID "
														+ "WHERE APP_ID = ?";
	public static String LOAD_STEP_ID_BY_APP_ID = "SELECT ID FROM IDN_APPMGT_STEP WHERE APP_ID = ?";
	public static String LOAD_CLAIM_MAPPING_BY_APP_ID = "SELECT IDP_CLAIM, SP_CLAIM, IS_REQUESTED FROM IDN_APPMGT_CLAIM_MAPPING WHERE APP_ID = ? AND TENANT_ID = ?";
	public static String LOAD_CLAIM_MAPPING_BY_APP_NAME = "SELECT IDP_CLAIM, SP_CLAIM, IS_REQUESTED FROM IDN_APPMGT_CLAIM_MAPPING WHERE APP_NAME = ? AND TENANT_ID = ?";
	public static String LOAD_ROLE_MAPPING_BY_APP_ID = "SELECT IDP_ROLE, SP_ROLE FROM IDN_APPMGT_ROLE_MAPPING WHERE APP_ID = ? AND TENANT_ID = ?";
    public static String LOAD_ROLE_CLAIM_BY_APP_ID = "SELECT ROLE_CLAIM FROM IDN_APPMGT_APP WHERE TENANT_ID= ? AND ID = ?";
    public static String LOAD_REQ_PATH_AUTHENTICATORS_BY_APP_ID = "SELECT AUTHENTICATOR_NAME FROM IDN_APPMGT_REQ_PATH_AUTHENTICATORS WHERE APP_ID = ? AND TENANT_ID = ?";
    public static String LOAD_PRO_USERSTORE_BY_APP_ID = "SELECT PROVISIONING_USERSTORE_DOMAIN FROM IDN_APPMGT_APP WHERE TENANT_ID= ? AND ID = ?";
    public static String LOAD_PRO_CONNECTORS_BY_APP_ID = "SELECT IDP_NAME, CONNECTOR_NAME FROM IDN_APPMGT_PROVISIONING_CONNECTORS WHERE APP_ID = ? AND TENANT_ID = ?";

	// DELETE queries
	public static String REMOVE_APP_FROM_APPMGT_APP = "DELETE FROM IDN_APPMGT_APP WHERE APP_NAME = ? AND TENANT_ID = ?";
	public static String REMOVE_APP_FROM_APPMGT_APP_WITH_ID = "DELETE FROM IDN_APPMGT_APP WHERE ID = ? AND TENANT_ID = ?";
	public static String REMOVE_CLIENT_FROM_APPMGT_CLIENT = "DELETE FROM IDN_APPMGT_CLIENT WHERE APP_ID = ? AND TENANT_ID = ?";
	public static String REMOVE_STEP_FROM_APPMGT_STEP = "DELETE FROM IDN_APPMGT_STEP WHERE APP_ID = ? AND TENANT_ID = ?";
	public static String REMOVE_CLAIM_MAPPINGS_FROM_APPMGT_CLAIM_MAPPING = "DELETE FROM IDN_APPMGT_CLAIM_MAPPING WHERE APP_ID = ? AND TENANT_ID = ?";
	public static String REMOVE_ROLE_MAPPINGS_FROM_APPMGT_ROLE_MAPPING = "DELETE FROM IDN_APPMGT_ROLE_MAPPING WHERE APP_ID = ? AND TENANT_ID = ?";
	public static String REMOVE_REQ_PATH_AUTHENTICATOR = "DELETE FROM IDN_APPMGT_REQ_PATH_AUTHENTICATORS WHERE APP_ID = ? AND TENANT_ID = ?";
    public static String REMOVE_PRO_CONNECTORS = "DELETE FROM IDN_APPMGT_PROVISIONING_CONNECTORS WHERE APP_ID = ? AND TENANT_ID = ?";

}