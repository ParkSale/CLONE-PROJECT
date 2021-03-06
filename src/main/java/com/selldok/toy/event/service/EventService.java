package com.selldok.toy.event.service;

import com.selldok.toy.event.entity.Event;
import com.selldok.toy.event.dao.EventRepository;
import com.selldok.toy.event.mapper.EventMapper;
import com.selldok.toy.event.model.EventSearchRequest;
import com.selldok.toy.event.model.InsertEventRequest;
import com.selldok.toy.event.model.UpdateEventRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author HJ Lee
 */
@Service
public class EventService {
    private final EventRepository eventRepository;

    private final EventMapper eventMapper;

    public EventService(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    public Optional<Event> findById(Long id){
        return eventRepository.findById(id);
    }

    public List<Event> getList(EventSearchRequest request) {
        return eventMapper.getEvent(request);
    }

    public void insert(InsertEventRequest request) {
        Event event = Event.builder()
                .imageLink(request.getImageLink())
                .type(request.getType())
                .title(request.getTitle())
                .text(request.getText())
                .date(request.getDate())
                .keywords(request.getKeywords())
                .owner(request.getOwner())
                .location(request.getLocation())
                .isFree(request.getIsFree())
                .isRecommend(request.getIsRecommend())
                .build();

        eventRepository.save(event);
    }

    public void update(Long id, UpdateEventRequest request) {
        Optional<Event> event = eventRepository.findById(id);
        event.ifPresent(presentEvent -> {
            presentEvent = Event.builder()
                    .id(id)
                    .imageLink(request.getImageLink())
                    .type(request.getType())
                    .title(request.getTitle())
                    .text(request.getText())
                    .date(request.getDate())
                    .keywords(request.getKeywords())
                    .owner(request.getOwner())
                    .location(request.getLocation())
                    .isFree(request.getIsFree())
                    .isRecommend(request.getIsRecommend())
                    .build();

            eventRepository.save(presentEvent);
        });
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
