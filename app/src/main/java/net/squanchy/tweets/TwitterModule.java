package net.squanchy.tweets;

import net.squanchy.tweets.service.TwitterRepository;
import net.squanchy.tweets.service.TwitterService;

import dagger.Module;
import dagger.Provides;

@Module
class TwitterModule {

    public final String query;

    TwitterModule(String query) {
        this.query = query;
    }

    @Provides
    TwitterRepository twitterRepository() {
        return new TwitterRepository(query);
    }

    @Provides
    TwitterService twitterService(TwitterRepository repository) {
        return new TwitterService(repository);
    }
}
