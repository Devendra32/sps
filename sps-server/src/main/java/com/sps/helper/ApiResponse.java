package com.sps.helper;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class ApiResponse {
    private Object obj;
    private String msg;
}
