package com.biciman.go.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface GoBicimanAiService {

    @UserMessage("""
            Generate a friendly greeting message for the user with the name {{platform}}.
            """)
    String generateGreeting(@V("platform") String platform);

    @SystemMessage("""
            You are an expert in bicycles and bike recommendations.
            Based on the user's preferences, suggest the most suitable bike type.
            Consider factors such as terrain, usage, and user preferences.
            Provide a brief explanation for your recommendation.
            """)
    String GenerateBiciSuggestion(@UserMessage String preferences);
}
