package com.evry.fs.payment.pms.srv.model;

import lombok.Builder;
import lombok.Getter;

/**
 * 
 * @author venkata.kuppili
 *
 */
@Getter
@Builder
public class Employee {
    private String firstName;
    private String lastName;
    private String address;
}
