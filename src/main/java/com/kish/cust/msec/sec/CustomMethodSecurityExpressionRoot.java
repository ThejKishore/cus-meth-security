package com.kish.cust.msec.sec;

import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot
        implements MethodSecurityExpressionOperations {

    private Object filterObject;

    private Object returnObject;

    private Object target;


    public CustomMethodSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }

    public boolean isMember(Long OrganizationId) {
        UserDetails user =  ((UserDetails)authentication.getPrincipal());
        return  user.isEnabled();
//        return user.getOrganization().getId().longValue() == OrganizationId.longValue();
    }


    public boolean isMember(Object targetId, Object permission) {

        UserDetails user =  ((UserDetails)authentication.getPrincipal());
        return  user.isEnabled();
//        return user.getOrganization().getId().longValue() == OrganizationId.longValue();
    }

    public boolean isMember(Object targetId, String targetType, Object permission) {

        UserDetails user =  ((UserDetails)authentication.getPrincipal());
        return  user.isEnabled();
//        return user.getOrganization().getId().longValue() == OrganizationId.longValue();
    }

    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    @Override
    public Object getFilterObject() {
        return this.filterObject;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    @Override
    public Object getReturnObject() {
        return this.returnObject;
    }

    /**
     * Sets the "this" property for use in expressions. Typically this will be the "this"
     * property of the {@code JoinPoint} representing the method invocation which is being
     * protected.
     * @param target the target object on which the method in is being invoked.
     */
    void setThis(Object target) {
        this.target = target;
    }

    @Override
    public Object getThis() {
        return this.target;
    }

}
