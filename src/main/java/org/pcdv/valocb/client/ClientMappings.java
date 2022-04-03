package org.pcdv.valocb.client;

import lombok.Data;

import java.util.Map;

@Data
public class ClientMappings {
    private Map<String, Client> clientsByName;
}
