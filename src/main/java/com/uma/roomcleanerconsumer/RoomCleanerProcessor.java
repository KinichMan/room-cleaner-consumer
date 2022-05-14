/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uma.roomcleanerconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 *
 * @author Kinich Mansilla
 */
@Component
public class RoomCleanerProcessor {

    @Bean
    @Primary
    public ObjectMapper scmsObjectMapper() {
        ObjectMapper responseMapper = new ObjectMapper();
        return responseMapper;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomCleanerProcessor.class);

    public void receiveMessage(String roomJson) {
        LOGGER.info("Message Received");
        try {
            Room room = this.scmsObjectMapper().readValue(roomJson, Room.class);
            LOGGER.info("Room ready for cleaning " + room.getNumber());
        } catch (IOException e) {
            LOGGER.error("Exception caught", e);
        }
    }

}
