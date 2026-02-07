package com.novibe.dns.cloudflare.http.dto.response.rule;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class GatewayRuleDto {
    @EqualsAndHashCode.Include
    String id;
    String name;
    String description;
    @SerializedName("created_at")
    String createdAt;
    String traffic;
    int precedence;
    boolean enabled;
}
