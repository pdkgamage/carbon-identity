/*
 * Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.authorization.core.dao;

import org.wso2.carbon.identity.authorization.core.dto.RolePermission;
import org.wso2.carbon.user.core.UserStoreException;

import java.sql.Connection;

/**
 * @author venura
 * @date May 15, 2013
 */
public abstract class RolePermissionDAO extends PermissionAssignmentDAO {

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void map(RolePermission rolePerm) {
        super.map(rolePerm);
        roleName = rolePerm.getRoleName();
    }

    @Override
    protected void saveDependentModules(Connection connection, boolean commit)
            throws UserStoreException {
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append("{").append(getClass()).append(" Role Name: ").append(roleName).append("}");
        return builder.toString();
    }

}
