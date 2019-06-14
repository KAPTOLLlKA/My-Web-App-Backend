package demoShop.api.services;

import demoShop.data.topic.Topic;

import java.util.Collection;

public interface TopicsService {
    Collection<Topic> getAllTopics();

    Collection<Topic> searchTopics(String searchFor);

    Topic getTopic(int id);

    void addTopic(Topic topic);

    void updateTopic(Topic topic);
}
