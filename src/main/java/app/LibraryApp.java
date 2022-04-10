package app;

import jakarta.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LibraryApp extends Application {
    private final Set<Class<?>> classes;

    public LibraryApp() {
        HashSet<Class<?>> resourceClasses = new HashSet<>();
        resourceClasses.add(BookResource.class);
        classes = Collections.unmodifiableSet(resourceClasses);
    }

    @Override
    public Set<Class<?>> getClasses(){
        return classes;
    }
}
