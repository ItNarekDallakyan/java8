package collectors;

import java.util.*;

import static java.util.stream.Collectors.*;

public class ImmutableCollections {
    public final Map<String, Integer> map = Map.of("have", 1, "the", 2, "high", 3, "ground", 4);

    @SafeVarargs
    public final <T> List<T> createImmutableList(T... elements) {
        return Arrays.stream(elements)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    @SafeVarargs
    public final <T> List<T> createImmutableListJava7(T... elements) {
        return Collections.unmodifiableList(Arrays.asList(elements));
    }

    @SafeVarargs
    public final <T> Set<T> createImmutableSet(T... elements) {
        return Arrays.stream(elements)
                .collect(collectingAndThen(toSet(), Collections::unmodifiableSet));
    }

    @SafeVarargs
    public final <T> Set<T> createImmutableSetJava7(T... elements) {
        return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(elements)));
    }


}
