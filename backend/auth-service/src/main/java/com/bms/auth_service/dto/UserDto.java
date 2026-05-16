/*
 * Copyright (c) 2026. BookMySeat
 * All rights reserved.
 */

package com.bms.auth_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    private Integer role;
}
