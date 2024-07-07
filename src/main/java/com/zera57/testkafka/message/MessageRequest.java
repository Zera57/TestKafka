package com.zera57.testkafka.message;

/**
 * @author Svyatoslav Avtonomov (zera57)
 */
public record MessageRequest(Long id, String message, MessageColor type) {}
