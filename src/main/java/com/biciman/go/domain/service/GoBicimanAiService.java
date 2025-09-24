package com.biciman.go.domain.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface GoBicimanAiService {

    @UserMessage("""
            Generate a friendly greeting message for the user with the name {{platform}}.
            """)
    String generateGreeting(@V("platform") String platform);
}
