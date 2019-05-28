package rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/doodle")
public class RestApplication extends Application {
 
    private Set<Object> singletons = new HashSet<Object>();
 
    public RestApplication() {
        singletons.add(new ParticipantService());
        singletons.add(new PollService());
        singletons.add(new SlotService());
    }
 
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}