package org.bssm.attachit.global.security.socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.bssm.attachit.domain.attachment.domain.Attachment;
import org.bssm.attachit.domain.attachment.exception.SocketIOException;
import org.bssm.attachit.domain.attachment.service.GetAttachmentListService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {

    private final GetAttachmentListService getAttachmentListService;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ConcurrentHashMap<String, WebSocketSession> CLIENTS = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws RuntimeException {
        CLIENTS.put(session.getId(), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws RuntimeException {
        CLIENTS.remove(session.getId());
    }

    @Scheduled(fixedRate = 1000, initialDelay = 5000)
    public void sendAttachmentListToAllClients() throws JsonProcessingException {
        List<Attachment> attachmentList = getAttachmentListService.execute();
        String jsonAttachments = objectMapper.writeValueAsString(attachmentList);
        TextMessage message = new TextMessage(jsonAttachments);
        CLIENTS.forEach((key, value) -> {
            try {
                value.sendMessage(message);
            } catch (IOException e) {
                throw SocketIOException.EXCEPTION;
            }
        });
    }
}
