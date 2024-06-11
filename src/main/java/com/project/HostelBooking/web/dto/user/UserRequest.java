package com.project.HostelBooking.web.dto.user;

import com.project.HostelBooking.model.user.RoleType;
import lombok.Data;

@Data
public class UserRequest {

    private String username;

    private String password;

    private String email;

    private RoleType roleType;
}
